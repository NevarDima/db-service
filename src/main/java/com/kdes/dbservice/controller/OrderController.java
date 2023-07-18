package com.kdes.dbservice.controller;

import com.kdes.dbservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/")
    public ResponseEntity<?> createOrder(@RequestBody Map<String, Object> orderMap){
        var orderId = orderService.createOrder(orderMap);
        log.info("Order was created with uuid: '{}'", orderId);
        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }
}
