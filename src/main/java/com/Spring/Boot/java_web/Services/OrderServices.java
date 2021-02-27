package com.Spring.Boot.java_web.Services;

import com.Spring.Boot.java_web.Repository.OrderRepository;
import com.Spring.Boot.java_web.entitits.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderServices {

    @Autowired
    private OrderRepository repository;

    //metodo para retornar todos os objetos do banco de dados
    public List<Order> findAll(){
        return repository.findAll();
    }

    //recuperando um usuário por id
    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
