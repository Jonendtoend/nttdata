package com.bootcamp.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person extends Client{

    /**
     * Registra el apellido del cliente
     * */
    private String lastName;

}
