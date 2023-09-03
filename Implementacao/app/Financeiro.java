package app;

public class Financeiro {
    private double custoMensal;
    private static final double MENSALIDADE_DEFAULT = 1500;

    public Financeiro() {
        this.custoMensal = MENSALIDADE_DEFAULT;
    }

    public double getCustoMensal(){
        return this.custoMensal;
    }

    public void setCustoMensal(double custo){
        this.custoMensal = custo;
    }
}
