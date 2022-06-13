package com.testes.Clientes.Response;

import com.testes.Clientes.enums.StatusUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String nomeCliente;
    private String email;
    private String nomeUsuario;
    private StatusUser statusUser;
}
