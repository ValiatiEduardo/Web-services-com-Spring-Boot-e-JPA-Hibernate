package com.Spring.Boot.java_web.Services.exceotion;

public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    //Construtor passo Id que tentei encontrar e não encontrei
    public ResourceNotFoundException(Object id) {
        //super é o construtor da super class
        //passa uma mensagem id não encontrado + id
        super("Resource not found. Id" + id);
    }


}
