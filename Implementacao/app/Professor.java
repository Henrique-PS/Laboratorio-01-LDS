package app;

import java.util.HashSet;

public class Professor extends Usuario {
    public Professor(String nome, String email, String senha) {
        super(nome, email, senha);
        tipoUsuario = "P";
    }

    public HashSet<Aluno> alunosMatriculados(){
        HashSet<Aluno> aluno = new HashSet<>();
        return aluno;
    }
}

