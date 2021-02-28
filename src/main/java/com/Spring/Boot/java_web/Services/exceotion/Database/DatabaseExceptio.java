package com.Spring.Boot.java_web.Services.exceotion.Database;

public class DatabaseExceptio extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DatabaseExceptio(String msg) {
        super(msg);
    }
}
