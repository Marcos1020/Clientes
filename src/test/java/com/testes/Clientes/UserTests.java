package com.testes.Clientes;

import com.testes.Clientes.Controller.UserController;

import com.testes.Clientes.Entity.UserEntity;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserTests {

//    @Autowired
//    private MockMvc mockMvc;
//
////    @Test
////    public void TestUsernameAndEmailAlreadyRegisteredShouldReturnBadRequest() {
////
////    }
//
//    @Test
//    public void VerificaSe() {
//
//       UserEntity entity = new UserEntity();
//       String senha = entity.getSenha();
//
//        assertEquals(0, senha);
//
//    };

}



//    @Test
//    public void TestUsernameAndEmailAlreadyRegisteredShouldReturnBadRequest()throws Exception{
//      UserEntity user = userRepository.findByNomeUsuarioOrEmail();
//
//    }





