package com.testes.Clientes.Controller.Response;

import com.testes.Clientes.enums.StatusUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private int idUsuario;
    private String nomeCliente;
    private String email;
    private String nomeUsuario;
    private StatusUser statusUser;
}
