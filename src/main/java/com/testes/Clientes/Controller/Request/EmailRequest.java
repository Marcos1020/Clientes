package com.testes.Clientes.Controller.Request;

import com.testes.Clientes.enums.StatusEmail;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmailRequest {

    @NotBlank
    private String ownerRef;

    @NotBlank
    private String emailTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;

    @NotBlank
    private StatusEmail statusEmail;



}
