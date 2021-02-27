package com.Spring.Boot.java_web.Repository;

import com.Spring.Boot.java_web.entitits.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
