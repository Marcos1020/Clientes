package com.testes.Clientes.Repository;

import com.testes.Clientes.Entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
}
