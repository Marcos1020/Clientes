package com.testes.Clientes.Entity;

import com.testes.Clientes.enums.StatusEmail;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EMAIL")
    private int idEmail;

    @Column(name = "OWNER_REF")
    private String ownerRef;

    @Column(name = "EMAIL_FROM")
    private String emailFrom;

    @Column(name = "EMAIL_TO")
    private String emailTo;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "DATA_ENVIO")
    private Data dataEnvio;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;
}
