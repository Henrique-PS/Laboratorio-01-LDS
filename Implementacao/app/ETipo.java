package app;

public enum ETipo {

    OBRIGATORIO("OBRIGATORIO"),
    OPTATIVO("OPTATIVO");

    private String nome;

    ETipo(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
}
