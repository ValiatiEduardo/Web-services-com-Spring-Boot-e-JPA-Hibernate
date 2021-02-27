package com.Spring.Boot.java_web.Services;

import com.Spring.Boot.java_web.Repository.OrderRepository;
import com.Spring.Boot.java_web.Repository.ProductRepository;
import com.Spring.Boot.java_web.entitits.Order;
import com.Spring.Boot.java_web.entitits.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServices {

    @Autowired
    private ProductRepository repository;

    //metodo para retornar todos os objetos do banco de dados
    public List<Product> findAll(){
        return repository.findAll();
    }

    //recuperando um usuário por id
    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}