package br.com.dicasdeumdev.api.domain;


import jakarta.persistence.*;
import lombok.*;

// a anotação @Data adiciona todos os metodoa, get, set e hashcode
// sem ficar com muitas anotações
@Getter // gerou um metodo getter de todos os atributos
@Setter // gerou um metodo setter para todos os atributos
@AllArgsConstructor // gerou o construtor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
/*
essas anotações servem para adicionar os métodos get, set de cada atributo
o construtor e o HashCode, usando o lombok, assim o codigo nao fica enorme
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(unique = true)
    private String email;
    /*
    foi colocado no banco de dados que a coluna de email é unica,
    isso significa que duas pessoas não podem ter o mesmo email
     */
    private String password;

}
