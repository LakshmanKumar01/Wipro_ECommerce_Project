package com.wipro.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.cart.entities.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

}
