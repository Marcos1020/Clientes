package com.testes.Clientes.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String nomeCliente;
    private String email;
    @Size(min=6,message="Senha deve ter no minimo 6 caracteres")
    private String senha;
    private String nomeUsuario;
}
