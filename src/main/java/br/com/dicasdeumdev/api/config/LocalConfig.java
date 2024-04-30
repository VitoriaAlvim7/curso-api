package br.com.dicasdeumdev.api.config;

import br.com.dicasdeumdev.api.domain.User;
import br.com.dicasdeumdev.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Configuration
@Profile("Local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB() {
        User u1 = new User(null, "Vitoria", "vitoria@mail.com", "123");
        User u2 = new User(null, "Vivi", "vivi@mail.com", "321");

        repository.saveAll(List.of(u1, u2));
    }

    /*
    foi startado o Banco de Dados e adicionado dois usuários no repository
     */
}
