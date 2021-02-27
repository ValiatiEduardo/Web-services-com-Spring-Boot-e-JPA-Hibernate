package com.Spring.Boot.java_web.resource.user;

import com.Spring.Boot.java_web.Services.CategoryServices;
import com.Spring.Boot.java_web.Services.ProductServices;
import com.Spring.Boot.java_web.entitits.Product;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {
    @Autowired
    private ProductServices services;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findId(@PathVariable Long id) {
        Product obj = services.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
