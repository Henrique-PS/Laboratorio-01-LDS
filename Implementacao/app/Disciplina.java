package app;

import java.util.LinkedList;

public class Disciplina {
    private String nome;
    private ETipo tipo;
    private EStatus status;
    private Integer codigoDisciplina;
    private int semestre;
    private LinkedList<Turma> turmas;



    private Integer codCurso;

    public Disciplina(String nome, Integer codigoDisciplina, ETipo tipo, Integer codCurso) {
        this.nome = nome;
        this.codigoDisciplina = codigoDisciplina;
        this.semestre = semestre;
        this.tipo = tipo;
        this.codCurso = codCurso;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo.getNome();
    }

    public void addTurma(Turma turma){
        this.turmas.add(turma);
    }

    public boolean addAluno(Aluno aluno) {
        for(Turma x : turmas){
            if(x.addAluno(aluno)){
                return true;
            }
        }
        return false;
    }

}
