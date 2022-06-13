package com.testes.Clientes.Service;

import com.testes.Clientes.Entity.UserEntity;
import com.testes.Clientes.Repository.UserRepository;
import com.testes.Clientes.Request.UserRequest;
import com.testes.Clientes.Response.UserResponse;
import com.testes.Clientes.enums.StatusUser;
import com.testes.Clientes.exception.NotFoundException;
import com.testes.Clientes.exception.ObjectAlreadyExists;
import com.testes.Clientes.exception.PreconditionFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserResponse newUser(UserRequest userRequest)throws PreconditionFailedException {
        log.info("Cadastrando novo Usuario", userRequest);

       UserEntity domain = this.userRepository.findByNomeUsuarioOrEmail(userRequest.getNomeUsuario(), userRequest.getEmail());

       if(Objects.nonNull(domain)){
           log.error("Nome de usuario e email já existente");
           throw new PreconditionFailedException("Favor insera um usuario valido " + userRequest.getNomeUsuario() + " já está sendo utilizdo," +
                   " favor verifique seu email" + userRequest.getEmail() + "e tente noavamente, obrigado");
       }

       UserEntity userEntity = new UserEntity();
       ConvertUserRequest(userRequest, userEntity);
       this.userRepository.save(userEntity);

       UserResponse userResponse = ConvertToResponse(userEntity);

            return userResponse;
    }

    public UserResponse searchById(final int idUsuario) throws NotFoundException {

        UserEntity user = this.userRepository.findByIdUsuario(idUsuario);
        if(Objects.isNull(user)){
            throw new NotFoundException("Id usuario não encontrado");
        }

        UserResponse userResponse = ConvertToResponse(user);
        return userResponse;
    }

    public UserResponse updateUser(final int idUsuario, UserRequest userRequest) throws NotFoundException {

        UserEntity userEntity = this.userRepository.findByIdUsuario(idUsuario);

        if(Objects.isNull(userEntity)){
            log.error("Favor verificar o id " + userEntity.getIdUsuario() + " pois não encontramos o usuario", idUsuario);
            throw new NotFoundException(idUsuario + " Não encontrado");
        }
        try{
            userEntity.setNomeUsuario(userRequest.getNomeUsuario());
            userEntity.setEmail(userRequest.getEmail());
            userEntity.setNomeCliente(userRequest.getNomeCliente());
            userEntity.setSenha(userRequest.getSenha());
        }catch (Exception error){
            log.error("Preencha todos os campos", error);
            throw new NotFoundException("Verifique todos os campos");
        }
        this.userRepository.save(userEntity);

        UserResponse userResponse = ConvertToResponse(userEntity);

        return userResponse;

    }

    public void inativar(final int idUsuario) throws ObjectAlreadyExists{

        UserEntity userEntity = this.userRepository.findByIdUsuario(idUsuario);

        if(Objects.isNull(userEntity)){
            log.error("Usuario não encontrado");
            throw new ObjectAlreadyExists("Insira um numero de ID valido");
        }

        userEntity.setStatusUser(StatusUser.DELETED);
        this.userRepository.save(userEntity);
    }


    private UserResponse ConvertToResponse(UserEntity userEntity) {

        UserResponse userResponse = new UserResponse();
        userResponse.setNomeUsuario(userEntity.getNomeUsuario());
        userResponse.setNomeCliente(userEntity.getNomeCliente());
        userResponse.setEmail(userEntity.getEmail());
        userResponse.setStatusUser(StatusUser.ACTIVE);

        return userResponse;
    }

    private void ConvertUserRequest(UserRequest userRequest, UserEntity userEntity) {

        userEntity.setNomeCliente(userRequest.getNomeCliente());
        userEntity.setNomeUsuario(userRequest.getNomeUsuario());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setSenha(userRequest.getSenha());
        userEntity.setStatusUser(StatusUser.ACTIVE);
    }


}
