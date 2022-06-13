package com.testes.Clientes.Config;

import com.testes.Clientes.Repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.UUID;

public class AuthorizeServer {

//    @Configuration
//    @Import(OAuth2AuthorizationServerConfiguration.class)
//    public class AuthorizationServerConfig {
//        @Bean
//        public UserRepository userRepository() {
//            RegisteredUsers registeredUsers = RegisteredUsers.withId(UUID.randomUUID().toString())
//                    .clientId("articles-client")
//                    .clientSecret("{noop}secret")
//                    .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                    .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                    .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//                    .redirectUri("http://127.0.0.1:8080/login/oauth2/code/articles-client-oidc")
//                    .redirectUri("http://127.0.0.1:8080/authorized")
//                    .scope(OidcScopes.OPENID)
//                    .scope("articles.read")
//                    .build();
//            return new userRepository(registeredUsers);
//        }
//    }
}
