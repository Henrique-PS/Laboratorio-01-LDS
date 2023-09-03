package app;

import java.util.HashMap;
import java.util.LinkedList;

public class Turma {

    private int id;
    private int semestre;
    private LinkedList<Disciplina> disciplinas;
    private LinkedList<Aluno> alunos;
    private static final int MAX_ALUNOS = 60;
    private static final int MIN_ALUNOS = 3;


    public Integer getSemestre() {
        return semestre;
    }


    public LinkedList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

}
