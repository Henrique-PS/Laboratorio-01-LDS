package app;

import java.util.LinkedList;

public class Turma {

    private int id;
    private int semestre;
    private LinkedList<Usuario> pessoas;
    private static final int MAX_ALUNOS = 60;
    private static final int MIN_ALUNOS = 3;


    public Integer getSemestre() {
        return semestre;
    }

    public int qtdAlunos(){
        int aux =0;
        for (Usuario aln : pessoas) {
            if (aln instanceof Aluno)  aux++;
        }
        return aux;
    }

    public boolean qtdAlunosSuficiente(){
        if (qtdAlunos() >= MIN_ALUNOS && qtdAlunos() <= MAX_ALUNOS) return true;
        return false;
    }

    public boolean addAluno(Aluno aluno) {
        if(pessoas.size() < 60){
            pessoas.add(aluno);
            return true;
        }
        return false;
    }

    public void removeAluno() {
        for (Usuario aln : pessoas) {
            if (this.equals(aln)) {
                pessoas.remove(aln);
                return;
            }
        }
    }
}
