package com.digitalinnovationone.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${app.message}")  //indica que vamos injetar todos os valores com esta anotacao cujo inicio seja o valor app.message
    private String appMessage;

    //para declarar uma variavel de ambiente(um argumento q vai vir do cmd ao rodar o projeto)
    @Value("${ENV_DB_URL:NENHUMA}")
    private String dbEnvironmentVariable;

    @GetMapping("/")  //para fazermos a exibicao direto do browser a partir do contexto de barra "/" do nosso browser
    public String getAppMessage() { return appMessage; }

    @GetMapping("/envVariable")
    public String getDbEnvironmentVariable() {
        return "A seguinte variavel de ambiente foi passada: " + dbEnvironmentVariable;
    }
}
