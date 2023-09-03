package app;

import java.util.HashMap;
import java.util.LinkedList;

public class Turma {

    private int id;
    private int semestre;
    private LinkedList<Aluno> alunos;
    private static final int MAX_ALUNOS = 60;
    private static final int MIN_ALUNOS = 3;


    public Integer getSemestre() {
        return semestre;
    }


    public boolean addAluno(Aluno aluno) {
        if(alunos.size() < 60){
            alunos.add(aluno);
            return true;
        }
        return false;
    }


}
