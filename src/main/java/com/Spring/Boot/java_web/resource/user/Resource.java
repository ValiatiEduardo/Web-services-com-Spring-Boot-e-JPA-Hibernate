package com.Spring.Boot.java_web.resource.user;

import com.Spring.Boot.java_web.Services.UserServices;
import com.Spring.Boot.java_web.entitits.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    //Endpoint para enserir
    //Para inserir é usado o metodo HTTP Post
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) { //recebe um objeto do tipo User
    //para garantir que vai chegar uma requisição do tipo JSON @RequestBody
        //Chamar services que já foi injeto   '@Autowired private UserServices services;'
        //Para executar a opração de insert que já foi feita na class UserServices
        // está da aqui
        // public User insert(User obj){
        //        return repository.save(obj);
        //obj recebendo o resultado
        obj = services.insert(obj);
        //para retornar o codigo 201 http quer dizer que algo foi criado!!
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    //Endepoint para deletar usuario

    @DeleteMapping(value = "/{id}")
    //PathVariable serve para o id ser reconhecido com uma variavel da URL
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        services.delete(id);
        //noContent retorna um corpo vasio co o código http 204 correto
        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj ){
        obj = services.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
