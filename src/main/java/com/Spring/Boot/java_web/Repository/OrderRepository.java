package com.Spring.Boot.java_web.Repository;

import com.Spring.Boot.java_web.entitits.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface  OrderRepository extends JpaRepository<Order, Long>{
}
