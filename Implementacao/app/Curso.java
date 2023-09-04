package app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Curso {

    private String nome;
    private int creditos;
    private LinkedList<Disciplina> disciplinas;
    private Integer codigoCurso;
    public Curso(String nome, int creditos) {
        this.nome = nome;
        this.creditos = creditos;
        this.disciplinas = new LinkedList<>();
        this.codigoCurso = codigoCurso;
    }

    public String toString(){
        return this.nome + ";" + this.creditos;
    }

    public void salvar(String caminhoArq){
        try {
            FileWriter writer = new FileWriter(caminhoArq, true);

            if (!caminhoArq.equals("")) {
                writer.write(this.toString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados no arquivo.");
        }
    }

    public void adicionarDisciplina(Disciplina disciplina){
        disciplinas.add(disciplina);
    }

    public LinkedList<Disciplina> getDisciplinas() {
        return (LinkedList<Disciplina>) List.copyOf(disciplinas);
    }
}
