package com.kdes.dbservice.service;

import com.kdes.dbservice.model.Item;
import com.kdes.dbservice.model.Order;
import com.kdes.dbservice.repository.ItemRepo;
import com.kdes.dbservice.repository.OrderRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final ItemRepo itemRepo;

    @Transactional
    public UUID createOrder(Map<String, Object> orderMap) {
        var order = orderRepo.save(Order.builder()
            .customerId(UUID.randomUUID())
            .createdAt(LocalDateTime.now())
            .totalAmount((int) orderMap.get("total_amount"))
            .build());
        var itemsMap = (List<Map<String, Object>>) orderMap.get("items");
        var items = itemsMap
            .stream()
            .map(i -> Item
                .builder()
                .itemId(UUID.randomUUID())
                .orderId(order)
                .productId(UUID.randomUUID())
                .quantity((int) i.get("quantity"))
                .price((int) i.get("price"))
                .build()
            )
            .toList();
        itemRepo.saveAll(items);
        return order.getOrderId();
    }
}
