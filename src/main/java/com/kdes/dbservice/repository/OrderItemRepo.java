package com.kdes.dbservice.repository;

import com.kdes.dbservice.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, UUID> {

}
