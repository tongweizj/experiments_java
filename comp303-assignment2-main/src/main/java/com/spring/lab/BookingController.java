package com.spring.lab;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.lab.Booking;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CruiseRepository cruiseRepository;
    
    @GetMapping("")
    public String showBookingsPage(HttpSession session,Model model) {
    	Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
    	// 如果用户没登录直接访问此页面，可以重定向回登录页（安全检查）
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        List<Booking> userBookings = bookingRepository.findByCustomer(loggedInUser);
    	// 3. 逻辑跳转：如果没有记录，直接去添加页面
        if (userBookings.isEmpty()) {
            return "redirect:/bookings/add"; 
        }
        model.addAttribute("allBookings", userBookings);
        model.addAttribute("customer", loggedInUser); // 传递用户信息用于页面显示
    	return "bookings";
    }
    
    @GetMapping("/add")
    public String showBookingPage(HttpSession session, Model model) {
    	Customer customer = (Customer) session.getAttribute("loggedInUser");
    	// 如果用户没登录直接访问此页面，可以重定向回登录页（安全检查）
        if (customer == null) {
            return "redirect:/login";
        }
        model.addAttribute("customer", customer); // 传给 Thymeleaf 显示名字
        
    	Booking booking = new Booking();
    	booking.setCruise(new Cruise());
    	model.addAttribute("cruiseBooking", booking);
    	
    	model.addAttribute("allCruises", cruiseRepository.findAll());
    	model.addAttribute("cabinTypes", List.of("Interior", "Ocean View", "Balcony", "Suite"));
    	return "add-booking";
    }
    
 // 第一步：从预约页跳转到支付预览页
    @PostMapping("/checkout")
    public String proceedToCheckout(@ModelAttribute("cruiseBooking") Booking booking, Model model) {
        // 获取邮轮详情用于显示价格
        Cruise selectedCruise = cruiseRepository.findById(booking.getCruise().getCruise_id()).orElseThrow();
        double totalPrice = selectedCruise.getPrice() * booking.getNo_of_passengers();
        booking.setTotal_price(totalPrice);
        
        model.addAttribute("cruiseBooking", booking);
        model.addAttribute("selectedCruise", selectedCruise);
        return "checkout"; // 转向支付页面
    }
    // save booking information
    @PostMapping("/save")
    public String saveBooking(@ModelAttribute("booking") Booking booking, BindingResult result,HttpSession session,Model model) {
    	if (result.hasErrors()) {
    		model.addAttribute("allCruises", cruiseRepository.findAll());
            model.addAttribute("cabinTypes", List.of("Interior", "Ocean View", "Balcony", "Suite"));
            return "add-booking";
        }
    	// 2. 从 Session 中获取登录的客户 (不再用测试 ID)
        Customer loggedInCustomer = (Customer) session.getAttribute("loggedInUser");
        if (loggedInCustomer == null) {
            // 如果 Session 过期或未登录，踢回登录页
            return "redirect:/login";
        }
        booking.setCustomer(loggedInCustomer);
    	Cruise selectedCruise = cruiseRepository.findById(booking.getCruise().getCruise_id()).orElseThrow();
    
        
        // counting totalPrice
        double totalPrice = selectedCruise.getPrice() * booking.getNo_of_passengers();
        booking.setTotal_price(totalPrice);
        // 4. 设置其他必须字段
    	booking.setBooking_date(LocalDate.now());
        booking.setStatus("Confirmed");
        // 5. 执行保存
        Booking savedBooking = bookingRepository.save(booking);
        
        // 傳遞確認訊息至 View [cite: 39]
        model.addAttribute("booking", savedBooking);
        return "confirmation";
    }

 // 第一步：打开编辑页面并回显数据 (GET)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model, HttpSession session) {
        // 权限检查：确保用户已登录
        Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
        if (loggedInUser == null) return "redirect:/login";
        
        model.addAttribute("customer", loggedInUser);

        // 获取旧订单
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid booking Id:" + id));

        model.addAttribute("cruiseBooking", booking); // 这里的 key 要和表单 th:object 一致
        model.addAttribute("allCruises", cruiseRepository.findAll());
        model.addAttribute("cabinTypes", List.of("Interior", "Ocean View", "Balcony", "Suite"));
        
        return "add-booking"; // 复用新增页面，或者你新建一个 edit-booking.html
    }

    // 第二步：处理修改后的保存 (POST)
    @PostMapping("/update/{id}")
    public String updateBooking(@PathVariable("id") int id, 
                                @ModelAttribute("cruiseBooking") Booking booking, 
                                HttpSession session) {
        
        // 获取数据库中原始的记录
        Booking oldBooking = bookingRepository.findById(id).orElseThrow();
        
        // 更新允许修改的字段 (Requirement 5)
        oldBooking.setDeparture_date(booking.getDeparture_date());
        oldBooking.setReturn_date(booking.getReturn_date());
        oldBooking.setCabinType(booking.getCabinType());
        oldBooking.setNo_of_passengers(booking.getNo_of_passengers());
        
        // 重新计算总价 (如果人数或邮轮变了，价格也要变)
        Cruise cruise = cruiseRepository.findById(booking.getCruise().getCruise_id()).orElseThrow();
        oldBooking.setTotal_price(cruise.getPrice() * booking.getNo_of_passengers());
        oldBooking.setCruise(cruise);

        bookingRepository.save(oldBooking);
        return "redirect:/bookings?success=updated";
    }
    
    
    @PostMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable("id") int id, HttpSession session, RedirectAttributes ra) {
        // 1. 获取登录用户，确保安全
        Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
        if (loggedInUser == null) return "redirect:/login";

        // 2. 查找订单
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid booking Id:" + id));

        // 3. 安全校验：只能取消自己的订单
        if (booking.getCustomer().getCustomer_id() != loggedInUser.getCustomer_id()) {
            return "redirect:/bookings";
        }

        // 4. 【核心逻辑】执行 10 天政策校验
        LocalDate today = LocalDate.now();
        LocalDate departureDate = booking.getDeparture_date();
        
        // 计算天数差
        long daysUntilDeparture = ChronoUnit.DAYS.between(today, departureDate);

        if (daysUntilDeparture >= 10) {
            // 满足政策：设为取消状态并保存
            booking.setStatus("Cancelled");
            bookingRepository.save(booking);
            // 使用 FlashAttribute 传递成功提示
            ra.addFlashAttribute("successMessage", "Reservation #CR-" + id + " has been successfully cancelled.");
        } else {
            // 不满足政策：给出错误提示
            ra.addFlashAttribute("errorMessage", "Cancellation Policy: You can only cancel at least 10 days before departure. (Current: " + daysUntilDeparture + " days remaining)");
        }

        return "redirect:/bookings";
    }
}
