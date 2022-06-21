package com.bootcamp.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company extends Client{

    /**
     * Registra el ruc de la empresa
     * */
    private String ruc;
}
