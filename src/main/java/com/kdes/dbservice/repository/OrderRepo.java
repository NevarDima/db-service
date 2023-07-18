package com.kdes.dbservice.repository;

import com.kdes.dbservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepo extends JpaRepository<Order, UUID> {

}
