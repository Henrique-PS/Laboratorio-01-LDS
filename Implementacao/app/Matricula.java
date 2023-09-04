package app;

public class Matricula {
    private Usuario usuarioLogado;
    private Financeiro financeiro;

    public Matricula(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
        this.financeiro = new Financeiro();
    }

    public boolean logar(String login, String senha){
        return true;
    }

    public void notificarSistemaCobranca(){
        financeiro.cobrarAluno();
    }
}
