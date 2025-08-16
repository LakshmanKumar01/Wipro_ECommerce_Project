package com.wipro.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.order.entities.OrderEntity;

public interface OrderRepsitory extends JpaRepository<OrderEntity, Long> {

}
