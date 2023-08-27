package app;

public class Scretaria extends Usuario{
    private Universidade universidade;

    public Scretaria(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public Universidade realizarAlteracaoInformacoes(){
        return this.universidade;
    }

    public String gerarCurriculoSemestre(){
        return "";
    }
}
