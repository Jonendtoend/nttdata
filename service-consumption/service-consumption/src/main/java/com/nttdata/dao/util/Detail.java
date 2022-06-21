package com.nttdata.dao.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Detail {


    /**
     * monto generado por la transaccion
     * */
    private BigDecimal amount;

    /**
     * detalle de la transaccion
     * */
    private String details;

    /**
     * 1: consumo
     * 2: depositos
     * 3: retiros
     * */
    private int transactionType;

    /**
     * 1: Ahorro
     * 2: Cuenta corriente
     * 3: Plazo fijo
     *
     * 4: Personal
     * 5: Empresarial
     * 6: Tarjeta de Crédito personal o empresarial
     * */
    private int accountType;

    /**
     * numero de la tarjeta de la transaccion,
     * se la obtiene de conulta a microservicio
     * de productos
     * */
    private String cardNumber;

    /**
     * fecha de la transaccion
     * */
    private LocalDateTime createdAt;

    public Detail(){
        createdAt=LocalDateTime.now();
    }



}
