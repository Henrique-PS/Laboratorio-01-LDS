package app;

public class Disciplina {
    private String nome;
    private ETipo tipo;
    private EStatus status;
    private Integer codigoDisciplina;
    private int semestre;

    public Disciplina(String nome, Integer codigoDisciplina, int semestre) {
        this.nome = nome;
        this.codigoDisciplina = codigoDisciplina;
        this.semestre = semestre;
    }
}