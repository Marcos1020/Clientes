package com.testes.Clientes.Controller;

import com.testes.Clientes.Request.UserRequest;
import com.testes.Clientes.Response.UserResponse;
import com.testes.Clientes.Service.UserService;
import com.testes.Clientes.exception.NotFoundException;
import com.testes.Clientes.exception.ObjectAlreadyExists;
import com.testes.Clientes.exception.PreconditionFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class UserController {

    @Autowired
    UserService userService;

    @Value("${access.token}")
    private String token;

    public UserController(String token) {
        this.token = token;
    }

    @PostMapping
    public ResponseEntity<UserResponse>newUser(@RequestBody UserRequest usuarioRequest, @RequestHeader String accessToken) throws PreconditionFailedException {
        if(!accessToken.equals(token)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        UserResponse response = this.userService.newUser(usuarioRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse>search(@PathVariable("id") int idUsuario,@RequestHeader String accessToken) throws NotFoundException{
        if(!accessToken.equals(token)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        final UserResponse userResponse = this.userService.searchById(idUsuario);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);

    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponse>userUpdate (
            @PathVariable("id") int idUsuario, @RequestBody UserRequest userRequest,@RequestHeader String accessToken) throws NotFoundException {
        if(!accessToken.equals(token)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        final UserResponse userResponse = this.userService.updateUser(idUsuario, userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> inativar(@PathVariable("id") int idUsuario,@RequestHeader String accessToken) throws ObjectAlreadyExists{
        if(!accessToken.equals(token)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        this.userService.inativar(idUsuario);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
