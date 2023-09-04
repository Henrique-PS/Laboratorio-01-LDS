package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

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

    public void carregarDisciplinas(String arquivo) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(arquivo));

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");

            String nome = dados[1];
            Integer codDisciplina = Integer.parseInt(dados[0]);
            Integer semestre = Integer.parseInt(dados[2]);
            ETipo tipo = ETipo.valueOf(dados[3]);
            Integer codCurso = Integer.parseInt(dados[4]);

            Disciplina disciplina = new Disciplina(nome, codDisciplina, tipo, codCurso);

            if(disciplina.getCodCurso() == this.codigoCurso) adicionarDisciplina(disciplina);
        }
        scanner.close();
    }

    public LinkedList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public static void main(String[] args) {

    }
}
