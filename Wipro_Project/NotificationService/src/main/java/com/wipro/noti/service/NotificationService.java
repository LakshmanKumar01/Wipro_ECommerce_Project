package com.wipro.noti.service;

import org.springframework.stereotype.Service;

@Service
public interface NotificationService {

	String showOrderMessage(Long paymentId);

}
