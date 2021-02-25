package com.Spring.Boot.java_web.resource.user;

import com.Spring.Boot.java_web.Services.OrderServices;
import com.Spring.Boot.java_web.Services.UserServices;
import com.Spring.Boot.java_web.entitits.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    @Autowired
    private OrderServices services;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = services.findAll();
        return ResponseEntity.ok().body(list);

    }

    //endpoint para buscar um usuário por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findId(@PathVariable Long id) {
        Order obj = services.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
