package com.testes.Clientes.Entity;

import com.testes.Clientes.enums.StatusUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_TB")
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_USUARIO")
    private int idUsuario;

    @Column(name = "NOME_CLIENTE")
    private String nomeCliente;

    @Column(name = "NOME_USUARIO")
    private String nomeUsuario;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "STATUS_USER")
    @Enumerated(EnumType.STRING)
    private StatusUser statusUser;

}
