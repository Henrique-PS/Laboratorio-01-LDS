package app;

import java.util.HashSet;

public class Aluno extends Usuario{
    private HashSet<Disciplina> disciplinasMatriculadas;
    private HashSet<Disciplina> disciplinasConcluidas;
    private int semestreEmCurso;
    private Financeiro financeiro;

    public Aluno(String nome, String email, String senha, int semestreEmCurso) {
        super(nome, email, senha);
        this.semestreEmCurso = semestreEmCurso;
        this.disciplinasMatriculadas = new HashSet<>();
        this.disciplinasConcluidas = new HashSet<>();
    }

    public void ralizarMatricula(Disciplina disciplina){}

    public void cancelarMatricula(Disciplina disciplina){}
}
