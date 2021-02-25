package com.Spring.Boot.java_web.resource.user;

import com.Spring.Boot.java_web.Repository.Repository;
import com.Spring.Boot.java_web.Services.UserServices;
import com.Spring.Boot.java_web.entitits.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class Resource {
    @Autowired
    private UserServices services;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    //ENDIPOINT para buscar um usuário por id
    @GetMapping(value = "/{id}") //Sgnifica que a url vai aceitar um valor valor
    //do tipo User por que vai receber apenas um usuário
    //@PathVariavle para o findById aceitar o Id na url
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = services.findById(id);
        //.ok é para indicar que teve sucesso
        // e no corpo da requisição passa o objeto obj
        return ResponseEntity.ok().body(obj);
    }
}
