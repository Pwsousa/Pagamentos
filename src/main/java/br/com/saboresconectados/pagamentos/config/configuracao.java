package br.com.saboresconectados.pagamentos.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configuracao {
    
    @Bean
    public ModelMapper obterModelMapper(){
        return new ModelMapper();
    }
}
