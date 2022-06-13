package com.testes.Clientes.Repository;

import com.testes.Clientes.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByNomeUsuarioOrEmail(final String nomeUsuario, final String email);

    UserEntity findByIdUsuario(final int idUsuario);
}