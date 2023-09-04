package app;

public class Secretaria extends Usuario{

    public Secretaria(String nome, String email, String senha) {
        super(nome, email, senha);
        tipoUsuario = "S";
    }

    public void alteracaoInformacoes(Usuario usuario){
        
    }

    public Curriculo gerarCurriculoSemestre(){
        Curriculo curriculo = new Curriculo();
        return curriculo;
    }

    public void mudarStatusDisciplina(Disciplina disciplina){

    }
}
