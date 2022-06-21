package com.nttdata.dao;

import com.nttdata.dao.util.Detail;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Document
public class Account {

    @Id
    String id;




    /**
     * 1: persona
     * 2: empresa
     * */
    private int clientType;

    /**
     *  id del cliente que se obtiene de
     *  microservicio de clientes,
     *  en caso de empresa en ruc
     *  y de person es dni
     * */
    private String clientId;

    private String clientName;
    private String clientIdentification;
    /**
     *  0 : inactivo
     *  1: activo
     * */
    private int state;




    /**
     *  fecha de creacion
     * */
    private LocalDateTime createdAt;



    /**
     *  detalle de la transaccion
     * */
    private Detail detail;
    public Account(){
        createdAt = LocalDateTime.now();
        state=1;
    }
}
