package app;

import java.io.FileWriter;
import java.io.IOException;

public abstract class Usuario {

    private String nome;
    private Integer numPessoa;
    private String email;
    private String senha;
    private static Integer parseNumPessoa;
    protected String tipoUsuario;

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

    public String toString(){
        return this.tipoUsuario + ";" + this.numPessoa + ";" + this.nome;
    }

    public void salvar(String caminhoArq){
        try {
            FileWriter writer = new FileWriter(caminhoArq, true);

            if (!caminhoArq.equals("")) {
                writer.write(this.toString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados no arquivo.");
        }
    }
    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }
}
