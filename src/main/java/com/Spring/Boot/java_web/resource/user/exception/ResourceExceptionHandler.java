package com.Spring.Boot.java_web.resource.user.exception;

import com.Spring.Boot.java_web.Services.exceotion.Database.DatabaseExceptio;
import com.Spring.Boot.java_web.Services.exceotion.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

//Intercepta as possiveis exception para que o objeto possa executar o tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

    //O metodo vai receber um como parametro uma excessão do tipo personalisado
    // e é o nome ''apelido' para  ResourceNotFoundException
    //recebe  como parametro Hppt..  e o nome ou aprlido para essa variavel vai ser request
    //Com essa anotação o método vai intersepta qualquer exception do tipo ResourceNotFoundException que foi lançada
    //E vai fazer o tratamento que estiver dentro do metodo.
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND; //Retorna um código http 404
        //Instânciar um objeto do tipo da class que criamos
        //momento em que ocorreu a exception
        //Status vai ser o status estânciado
        //error criado anteriormente
        //Mensagem que eu recebi na exception ResourceNotFoundException e
        //Path que é o caminho da requisição veio HttpServletRequest
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    //Mesma coisa feita ali em cima, porém erro diferente
    @ExceptionHandler(DatabaseExceptio.class)
    public ResponseEntity<StandardError> database(DatabaseExceptio e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
