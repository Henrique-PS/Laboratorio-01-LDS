package app;

import java.util.LinkedList;
import java.util.List;

public class Curso {

    private LinkedList<Disciplina> disciplinas;

    public LinkedList<Disciplina> getDisciplinas() {
        return (LinkedList<Disciplina>) List.copyOf(disciplinas);
    }
}
