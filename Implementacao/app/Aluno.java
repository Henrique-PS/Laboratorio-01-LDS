package app;

import java.util.LinkedList;

public class Aluno extends Usuario{
    private int semestreEmCurso;
    private Curso curso;
    private Financeiro financeiro;

    public Aluno(String nome, String email, String senha, Curso curso, int semestreEmCurso) {
        super(nome, email, senha);
        this.curso = curso;
        this.semestreEmCurso = semestreEmCurso;
        financeiro = new Financeiro();
    }

    public void realizarMatricula(LinkedList<Disciplina> disciplinas){

    }

    public void cancelarMatricula(Turma turma){

    }

    public Integer getSemestreAtual() {
        return this.semestreEmCurso;
    }

    public Curso getCurso() {
        return curso;
    }
}
