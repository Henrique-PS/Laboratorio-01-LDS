package app;

import java.io.FileWriter;
import java.util.HashSet;

public class Universidade {
    private HashSet<Usuario> usuarios;
    private HashSet<Curso> cursos;
    private String nome;

    public Universidade(String nome) {
        this.usuarios = new HashSet<>();
        this.cursos = new HashSet<>();
        this.nome = nome;
    }
    public void finalizarSemestre(){}
    public void iniciarSemestre(){}
}
