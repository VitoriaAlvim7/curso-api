package br.com.dicasdeumdev.api.repositories;

import br.com.dicasdeumdev.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Repository do banco onde é guardado as informações
    Optional<User> findByEmail(String email);

}
