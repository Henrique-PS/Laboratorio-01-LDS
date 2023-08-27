package app;

import java.util.HashSet;

public class Universidade {
    private HashSet<Curso> cursos;
    private String nome;

    public Universidade(HashSet<Curso> cursos, String nome) {
        this.cursos = new HashSet<>();
        this.nome = nome;
    }

    public void finalizarSemestre(){}
    public void iniciarSemestre(){}

}
