package com.Spring.Boot.java_web.Services;

import com.Spring.Boot.java_web.Repository.Repository;
import com.Spring.Boot.java_web.entitits.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

//REGISTRAR CLASS COMO UM COMPONENTE DO SPRING '@cOMPONENT'
//Assim ele podera ser injetado automaticamente com @alrtward
@Component//Ou @Services como é um serviço questão de semantica
public class UserServices {

    //injeção de dependencia
    @Autowired
    private Repository repository;

    //metodo para retornar todos os usuarios do banco de dados
    public List<User> findAll(){
        return repository.findAll();
    }
    // recuperando um usuário por ID
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
    //operação para inserir no banco de dados um novo objeto do tipo user
    public User insert(User obj){
        return repository.save(obj);
    }
}
