package com.bootcamp.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;

@Data
@Document( )
public class Client {

    @Id
    String id;

    /**
     * para la identificaion del dni o ruc
     * */
    private String identificaiton;

    /**
     * para el nombre del cliente
     * */
    private String name;

    /**
     * Guarda la fecha de crecion,
     * del registro
     * */
    private LocalDateTime createdAt;

    /**
     * Registra la modificaion del producto
     * */
    private LocalDateTime modifiedAt;

    /**
     * 0: inactivo
     * 1: activo
     * */
    private int state;
    public Client(){
        createdAt=LocalDateTime.now();
        modifiedAt=LocalDateTime.now();
        state=1;
    }
}
