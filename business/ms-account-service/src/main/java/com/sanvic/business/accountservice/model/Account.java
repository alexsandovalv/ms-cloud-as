package com.sanvic.business.accountservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountName;
    private String accountType;
    private Double balance;
    private Long customerId;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

}
