package app;

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
        return this.email.equals(login) && this.senha.equals(senha) ? true : false;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }
}
