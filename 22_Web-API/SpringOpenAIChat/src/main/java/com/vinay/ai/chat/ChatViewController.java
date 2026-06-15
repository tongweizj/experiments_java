package com.vinay.ai.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatViewController {
	
	 @GetMapping("/")
	    public String home() {
	        return "chat"; // maps to templates/chat.html
	    }

}
