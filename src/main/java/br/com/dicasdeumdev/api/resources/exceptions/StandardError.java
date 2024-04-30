package br.com.dicasdeumdev.api.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class StandardError {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;

    /*
    São as informações que serão mostradas quando ocorrer algum erro

     timestamp - em que momento o erro aconteceu
     status - o numero do erro, por exemplo 404 (objeto não encontrado)
     error - o erro "Objeto não encontrado" o que mostraria se o erro fosse 404
     path - a onde foi o erro por exemplo /user/6 não existe um objeto salvo com o id 6
     na tabela do banco de dados
     */
}
