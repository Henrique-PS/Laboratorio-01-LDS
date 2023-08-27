package app;

import java.util.Enumeration;

public abstract class Usuario {

    private String nome;
    private Integer numPessoa;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.numPessoa = numPessoa;
    }

    public Boolean logar(String login, String senha){
        return true;
    }
}
