package app;

import java.util.Enumeration;

public abstract class Usuario {

    private String nome;
    private Integer numPessoa;
    private String email;
    private String senha;
    private static Integer parseNumPessoa;

    static {
        parseNumPessoa = 0;
    } 

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.numPessoa = ++parseNumPessoa;
    }

    public Boolean logar(String login, String senha){
        if(this.email == login && this.senha == senha)
            return true;
        else
            return false;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }
}
