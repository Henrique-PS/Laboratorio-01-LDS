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

    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void adicionarCurso(Curso curso){
        cursos.add(curso);
    }

    public void salvarUsuarios(String caminho){
        usuarios.forEach(u -> u.salvar(caminho));
    }

    public void salvarCursos(String caminho){
        cursos.forEach(curso -> curso.salvar(caminho));
    }
    public void finalizarSemestre(){}
    public void iniciarSemestre(){}
}
