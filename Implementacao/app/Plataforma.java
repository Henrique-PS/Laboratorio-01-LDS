package app;

import java.io.IOException;
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

        /**
     * Método que cadastra um cliente, recebe todos os dados do cliente, cria o objeto e adiciona a lista de clientes da plataforma
     * Caso já exista cliente com o login informado lança IllegalArgumentException
     * Caso ocorra erro ao adicionar cliente a plataforma lança IOException
     * @param nome
     * @param nomeUsuario
     * @param senha
     * @throws IOException
     * @throws IllegalArgumentException
     */
    public void cadastrarAluno(String nome, String nomeUsuario, String senha) throws IOException, IllegalArgumentException{
        Usuario novoAluno = new Aluno(nome, nomeUsuario, senha, 1);

        adicionarUsuario(novoAluno);
    }

        /**
     * adicionar usuario na plataforma, retorna IllegalArgumentException caso usuario já exista
     * 
     * @param usuario usuario a ser adicionado
     * @throws IOException
     * @throws IllegalArgumentException cliente ja existe
     * 
     */
    public void adicionarUsuario(Usuario usuario) throws IOException, IllegalArgumentException {
        if (validarLoginUsuario(usuario)) {
            this.usuarios.put(usuario.getEmail(), usuario);
        } else {
            throw new IllegalArgumentException();
        }
    }

        /**
     * valida se o login do usuario existe, true caso não exista e false caso exista
     * 
     * @param usuario cliente a ser validado
     * @return true caso não exista e false caso exista
     * 
     */
    private boolean validarLoginUsuario(Usuario usuario) {
        Usuario a = usuarios.get(usuario.getEmail());
        return a == null ? true : false;
    }

    public String getUsuarioAtual() {
        return this.usuarioAtual.getNome();
    }
}
