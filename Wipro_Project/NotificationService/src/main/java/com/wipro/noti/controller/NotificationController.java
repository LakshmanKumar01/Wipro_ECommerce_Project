package com.wipro.noti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.noti.service.NotificationService;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
	@Autowired
	private NotificationService notiService;
	
	@GetMapping("/textMessage/{paymentId")
	public String testMessage(@PathVariable Long paymentId) {
		return notiService.showOrderMessage(paymentId);
	}
}
