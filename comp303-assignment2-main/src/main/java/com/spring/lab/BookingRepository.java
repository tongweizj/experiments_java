package com.spring.lab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository  extends JpaRepository<Booking, Integer>  {
	List<Booking> findByCustomer(Customer customer);

}
