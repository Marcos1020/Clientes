package com.testes.Clientes;

import com.testes.Clientes.Repository.UserRepository;
import com.testes.Clientes.Request.UserRequest;
import com.testes.Clientes.Response.UserResponse;
import com.testes.Clientes.Service.UserService;
import com.testes.Clientes.enums.StatusUser;
import com.testes.Clientes.exception.PreconditionFailedException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientesApplicationTests {


	@Mock
	private UserRepository repository;

	@InjectMocks
	private UserService service ;

	@Test
	void contextLoads() {
	}
	@Test
	public void registerAUserSuccess() {

		UserResponse response = new UserResponse();
		response.setNomeCliente("Daniela Fernanda");
		response.setNomeUsuario("daniela10");
		response.setEmail("Daniela@gmail.com");
		response.setIdUsuario(0);
		response.setStatusUser(StatusUser.ACTIVE);
		UserRequest user = new UserRequest();
		user.setNomeCliente("Daniela Fernanda");
		user.setNomeUsuario("daniela10");
		user.setEmail("Daniela@gmail.com");
		user.setSenha("asdcer");
		UserResponse responseUser = service.newUser(user);
		assertEquals(responseUser, response);

	}

	@Test
	public void registerAUserError() {
		UserRequest user = new UserRequest();
		user.setNomeCliente("Daniela Fernanda");
		user.setNomeUsuario("daniela10");
		user.setEmail("Daniela@gmail.com");
		user.setSenha("asdcer");
		UserResponse responseUser = service.newUser(user);
		when(user.getEmail()).thenThrow(PreconditionFailedException.class);
	}
}
