package com.Spring.Boot.java_web.Services;

import com.Spring.Boot.java_web.Repository.CategotyRepository;
import com.Spring.Boot.java_web.Repository.OrderRepository;
import com.Spring.Boot.java_web.entitits.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryServices {

    @Autowired
    private CategotyRepository repository;

    //metodo para retornar todos os objetos do banco de dados
    public List<Category> findAll(){
        return repository.findAll();
    }

    //recuperando um usuário por id
    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
