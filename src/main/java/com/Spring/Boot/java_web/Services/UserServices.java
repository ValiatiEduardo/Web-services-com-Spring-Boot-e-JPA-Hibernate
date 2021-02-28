package com.Spring.Boot.java_web.Services;

import com.Spring.Boot.java_web.Repository.Repository;
import com.Spring.Boot.java_web.Services.exceotion.ResourceNotFoundException;
import com.Spring.Boot.java_web.entitits.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;


import javax.persistence.EntityNotFoundException;
import javax.xml.crypto.Data;
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
        //Trocar o get pelo orElseThorow
        // A diferença é que ele vai tentar dar o get se ele não encontrar User ele retorna o exception tratado
        //get retornava um erro padrão
        return obj.orElseThrow( ()-> new ResourceNotFoundException(id));
    }
    //operação para inserir no banco de dados um novo objeto do tipo user
    public User insert(User obj){
        return repository.save(obj);
    }

    //Deletar o usuario do banco de dados
    public void delete (Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

    //atualisar dados no banco
    //Long id para indicar qual usuaário vai ser atualisado
    //User obj contendo os dados para serem atualisados
    //getOne é diferente do findById: vai la no banco de dados e pega e leva os dados
    //getOne só prepara o objeto para minha manipulação e só depois efetuar uma operação com o banco
    public User update(Long id, User obj) {
        try {
            User enttity = repository.getOne(id);
            //atualisa os dados do entity baseado com os dados do obj
            updateData(enttity, obj);
            //salvar no banco de dados o entity
            return repository.save(enttity);
        }catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    //Atualisar os dados do entity com base com que chedo no obj
    private void updateData(User enttity, User obj) {
        enttity.setName(obj.getName());
        enttity.setEmail(obj.getEmail());
        enttity.setPhone(obj.getPhone());
    }

}
