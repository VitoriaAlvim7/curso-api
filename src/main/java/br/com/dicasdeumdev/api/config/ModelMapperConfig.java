package br.com.dicasdeumdev.api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();

        /*
        a função ModelMapper é usada para transformar um tipo de Objeto em um Objeto de outro tipo
        por exemplo, um User para um UserDTO
         */
    }
}
