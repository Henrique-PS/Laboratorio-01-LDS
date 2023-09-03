package app;

import java.util.HashMap;

public class Plataforma {

    private HashMap<String, Usuario> usuarios;
    private Usuario usuarioAtual;

    Plataforma(){
        this.usuarios = new HashMap<String, Usuario>(250);
        this.usuarioAtual = null;
    }

    /**
     * Realiza o login na plataforma, retorna cliente atual caso login efetuado do sucesso e null caso contrário
     * 
     * @param login email do usuario
     * @param senha senha do usuario
     * 
     * @return usuario se sucesso, cliente nulo caso erro
     */
    public Usuario login(String login, String senha) {
        Usuario usuario = usuarios.get(login);

        if (usuario != null && usuario.logar(login, senha)) {
            this.usuarioAtual = usuario;
        } else {
            this.usuarioAtual = null;
        }

        return this.usuarioAtual;
    }

    /**
     * Realiza o logoff do cliente da plataforma, colocando o cliente atual como nulo
     * 
     */
    public void logoff() {
        this.usuarioAtual = null;
    }

    public String getUsuarioAtual() {
        return this.usuarioAtual.getNome();
    }
}
