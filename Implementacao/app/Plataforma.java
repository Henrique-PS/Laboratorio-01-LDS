package app;

import java.io.IOException;
import java.nio.channels.IllegalSelectorException;
import java.security.KeyException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Plataforma {

    private HashMap<String, Usuario> usuarios;
    private HashMap<String, Curso> cursos;
    private Usuario usuarioAtual;

    Plataforma(){
        this.usuarios = new HashMap<String, Usuario>(250);
        this.cursos = new HashMap<String, Curso>(250);
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
     * @param email
     * @param senha
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws KeyException
     */
    public void cadastrarAluno(String nome, String email, String senha, String curso) throws IOException, IllegalArgumentException, KeyException{
        Curso cursoObj = cursos.get(curso.toLowerCase());
        if(cursoObj != null){
            Usuario novoAluno = new Aluno(nome, email, senha, cursoObj, 1);
            adicionarUsuario(novoAluno);
        } else {
            throw new KeyException();
        }
    }

        /**
     * adicionar usuario na plataforma, retorna IllegalArgumentException caso usuario já exista
     * 
     * @param usuario usuario a ser adicionado
     * @throws IOException
     * @throws IllegalArgumentException usuario ja existe
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
     * @param usuario usuario a ser validado
     * @return true caso não exista e false caso exista
     * 
     */
    private boolean validarLoginUsuario(Usuario usuario) {
        return usuarios.get(usuario.getEmail()) == null ? true : false;
    }

    public void adicionarCurso(Curso curso) {
        this.cursos.put(curso.getNome(), curso);
    }

    public String getUsuarioAtual() {
        return this.usuarioAtual.getNome();
    }

    public char getTipoUsuarioAtual() {
        if(this.usuarioAtual instanceof Aluno){
            return 'A';
        }
        if(this.usuarioAtual instanceof Professor){
            return 'P';
        }
        if(this.usuarioAtual instanceof Secretaria){
            return 'S';
        }
        return 'E';
    }

    /**
     * realizar matricula
     * 
     * @throws IllegalArgumentException materias incorretas, insuficiente ou excessiva
     * 
     */
    public void realizarMatricula(String[] opcoes) throws IllegalArgumentException{
        Aluno aluno = (Aluno) usuarioAtual;
        Integer semestre = aluno.getSemestreAtual();
        Curso cursoAluno = aluno.getCurso();
        LinkedList<Disciplina> listDisciplinas = cursoAluno.getDisciplinas();
        LinkedList<Disciplina> listDisciplinasMatricular = new LinkedList<Disciplina>();

        for (Disciplina x : listDisciplinas) {
            if(x.getSemestre() == semestre){
                for(String y : opcoes){
                    if(x.getNome().equals(y)){
                        listDisciplinasMatricular.add(x);
                    }
                }
            }
        }
        long qtdObg = listDisciplinasMatricular.stream().filter( x -> x.getTipo().equals("OBRIGATORIO")).count();
        long qtdOpt = listDisciplinasMatricular.stream().filter( x -> x.getTipo().equals("OPTATIVO")).count();
        if(qtdObg > 0 && qtdObg <= 4 && qtdOpt <= 2){
            aluno.realizarMatricula(listDisciplinasMatricular);
        } else{
            throw new IllegalArgumentException();
        }
    }

    public void cancelarMatricula() {
    }

    public String getDisciplinas() {
        StringBuilder str = new StringBuilder("Disciplinas: \n");
        Aluno aluno = (Aluno) usuarioAtual;
        Integer semestre = aluno.getSemestreAtual();
        Curso cursoAluno = aluno.getCurso();
        LinkedList<Disciplina> listDisciplinas = cursoAluno.getDisciplinas();

        for (Disciplina x : listDisciplinas) {
            if(x.getSemestre() == semestre){
                str.append(x.getNome() + " - " + x.getTipo() + "\n");
            }
        }
        return str.toString();
    }

    public void salvarUsuarios(String caminho){
        for (Map.Entry<String, Usuario> entrada : usuarios.entrySet()) {
            Usuario usuario  = entrada.getValue();
            usuario.salvar(caminho);
        }
    }

    public void salvarCursos(String caminho){
        for (Map.Entry<String, Curso> entrada : cursos.entrySet()) {
            Curso curso = entrada.getValue();
            curso.salvar(caminho);
        }
    }
}
