package com.rersdev.logisticapi.dao.repositories;

import com.rersdev.logisticapi.dao.extended.OrderExtRepo;
import com.rersdev.logisticapi.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>, OrderExtRepo {

    Optional<Order> findByOrderNumber(String orderNumber);
}
