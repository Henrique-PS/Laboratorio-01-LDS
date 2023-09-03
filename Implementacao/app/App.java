package app;

import java.io.IOException;
import java.nio.channels.IllegalSelectorException;
import java.security.KeyException;
import java.util.Scanner;

public class App {

    static Scanner teclado = new Scanner(System.in);
    static Plataforma plataforma;
    public static void main(String[] args) {
        plataforma = new Plataforma();

        int opcao;
        do {
            opcao = menu();
            limparTela();
            switch (opcao) {
                case 1:
                    if (realizarLogin()) {
                        char tipoUsuario = plataforma.getTipoUsuarioAtual();
                        switch (tipoUsuario) {
                            case 'A':
                                menuAluno();
                                break;
                            case 'P':

                                break;
                            case 'S':

                                break;
                            default:
                                break;
                        }
                        
                    } else {
                        System.out.println("Login invalido. Favor tentar logar novamente ou realizar seu cadastro.");
                    }
                    break;
                case 2:
                    cadastrarAluno();
                    break;
                default:
                    break;
            }
            pausa();
        } while (opcao != 0);
        System.out.println("Obrigado por utilizar o sistema de matricula!");
    }

    public static int menu() {
        limparTela();
        int opcao=-1;
        do{
            System.out.println("Menu");
            System.out.println("=================================================");
            System.out.println("1 - Logar");
            System.out.println("2 - Cadastro aluno");
            System.out.println("0 - Sair");
            System.out.println("=================================================");
            System.out.print("\nDigite sua opção: ");
            try {
                opcao = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida.");
            }
        }while(!(opcao>=0  && opcao <=2));
        return opcao;
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pausa() {
        System.out.println("Enter para continuar.");
        teclado.nextLine();
    }

    public static boolean realizarLogin() {
        System.out.println("==========================");
        System.out.println("--Realizando login--");
        System.out.println("Digite seu email: ");
        String login = teclado.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = teclado.nextLine();
        return ((plataforma.login(login, senha) != null) ? true : false);
    }

    public static int opcoesAluno() {
        limparTela();
        int opcao = -1;
        do{
            System.out.println("Menu do usuario " + plataforma.getUsuarioAtual());
            System.out.println("==========================================================");
            System.out.println("1 - Realizar matricula");
            System.out.println("2 - Cancelar matricula");
            System.out.println("0 - Sair");
            System.out.println("==========================================================");
            System.out.print("\nDigite sua opção: ");
            try {
                opcao = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida.");
            }
        }while(!(opcao>=0  && opcao <=2));

        return opcao;
    }

    public static void menuAluno() {
        int op = -1;
        do {
            op = opcoesAluno();
            switch (op) {
                case 1:
                    realizarMatricula();
                case 2:
                    plataforma.cancelarMatricula();
                default:
                    break;
            }
        } while (op != 0);
        realizarLogoff();
    }

    private static void realizarMatricula() {
        System.out.println(plataforma.getDisciplinas());
        System.out.println("Escolha as disciplinas separando por virgula\n");
        String disciplinas = teclado.nextLine();
        try {
            plataforma.realizarMatricula(disciplinas.split(","));
            System.out.println("Matricula realizada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("materias incorretas, insuficiente ou excessiva");
        }
        
    }

    public static void realizarLogoff() {
        plataforma.logoff();
        System.out.println("==========================");
        System.out.println("--Realizado logoff--");
        pausa();
    }

     public static void cadastrarAluno() {
        String nome, email, senha, curso;
        System.out.println("==========================");
        System.out.println("--Cadastro de Aluno--");

        System.out.println("Nome: ");
        nome = teclado.nextLine();
        System.out.println("login: ");
        email = teclado.nextLine();
        System.out.println("Senha: ");
        senha = teclado.nextLine();
        System.out.println("Curso: ");
        curso = teclado.nextLine();

        try {
            plataforma.cadastrarAluno(nome, email, senha, curso);
            System.out.println("\nAluno adicionado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("\nLogin invalido, já existe aluno cadastrado com esse email\n" + e);
        } catch (IOException e) {
            System.out.println("Erro na criação do cliente no banco\n" + e);
        } catch (KeyException  e) {
            System.out.println("\nCurso não existente\n" + e);
        }

    }
}
