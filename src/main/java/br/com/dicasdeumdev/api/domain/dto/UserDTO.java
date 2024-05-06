package br.com.dicasdeumdev.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class UserDTO {

    private Integer id;
    private String name;
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    /*
    @JsonIgnore
    usando o DTO é possivel omitir informações, com a anotação @JsonIgnore
    foi possivel omitir/ignorar a senha e não mostrar no retorno

    @JsonProperty Write Only, vai liberar o acesso apenas para escrita, então
    é possivel escrever uma senha, não será mostrada na url, mas estará salva no
    banco de dados
     */
}
