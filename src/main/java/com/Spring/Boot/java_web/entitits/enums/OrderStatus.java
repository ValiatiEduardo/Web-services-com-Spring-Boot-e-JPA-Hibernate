package com.Spring.Boot.java_web.entitits.enums;

import java.util.IllformedLocaleException;

public enum OrderStatus {

    WAIING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    //código para o tipo que foi enumerado
    private int code;

    //construtor do tipo especial
    private OrderStatus(int code) {
        this.code = code;
    }
    // para o vicar visivel fora do escopo
    public int getCode(){
        return code;
    }
    //metodo estatic para não precisar instanciar
    //Ex se eu passar codigo 1 ele retorna WATTING_PAYMENT
    public static OrderStatus valueOf(int code) {
        for(OrderStatus value : OrderStatus.values()){
            if (value.getCode() == code) {
                return value;
            }
        }
        // Se for passado um valor(code) que não existe
        //lança uma ecessão
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
