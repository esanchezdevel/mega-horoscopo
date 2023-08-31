package com.mega.horoscopo.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mega.horoscopo.domain.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
