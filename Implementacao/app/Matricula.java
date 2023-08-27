package app;

public class Matricula {
    private Usuario usuarioLogado;

    public Matricula(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public boolean logar(String login, String senha){
        return true;
    }
}
