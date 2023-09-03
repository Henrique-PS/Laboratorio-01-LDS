package app;

import java.util.HashSet;

public class Aluno extends Usuario{
    private int semestreEmCurso;
    private Financeiro financeiro;

    public Aluno(String nome, String email, String senha, int semestreEmCurso) {
        super(nome, email, senha);
        this.semestreEmCurso = semestreEmCurso;
        financeiro = new Financeiro();
    }

    public void ralizarMatricula(Disciplina disciplina){}

    public void cancelarMatricula(Disciplina disciplina){}
}
