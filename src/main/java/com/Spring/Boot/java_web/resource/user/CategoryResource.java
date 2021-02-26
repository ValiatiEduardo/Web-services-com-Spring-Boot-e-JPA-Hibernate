package com.Spring.Boot.java_web.resource.user;

import com.Spring.Boot.java_web.Services.CategoryServices;
import com.Spring.Boot.java_web.entitits.Category;
import com.Spring.Boot.java_web.entitits.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    @Autowired
    private CategoryServices services;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = services.findAll();
        return ResponseEntity.ok().body(list);

    }

    //endpoint para buscar um usuário por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findId(@PathVariable Long id) {
        Category obj = services.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
