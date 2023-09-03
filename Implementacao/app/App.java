package app;

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
                        menuUsuario();
                    } else {
                        System.out.println("Login invalido. Favor tentar logar novamente ou realizar seu cadastro.");
                    }
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
            System.out.println("0 - Sair");
            System.out.println("=================================================");
            System.out.print("\nDigite sua opção: ");
            try {
                opcao = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida.");
            }
        }while(!(opcao>=0  && opcao <=1));
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

    public static int opcoesUsuario() {
        limparTela();
        int opcao = -1;
        do{
            System.out.println("Menu do usuario " + plataforma.getUsuarioAtual());
            System.out.println("==========================================================");

            System.out.println("0 - Sair");
            System.out.println("==========================================================");
            System.out.print("\nDigite sua opção: ");
            try {
                opcao = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida.");
            }
        }while(!(opcao>=0  && opcao <=1));

        return opcao;
    }

    public static void menuUsuario() {
        int op = opcoesUsuario();
        do {
            switch (op) {
                default:
                    break;
            }
            op = opcoesUsuario();
        } while (op != 0);
        realizarLogoff();
    }

    public static void realizarLogoff() {
        plataforma.logoff();
        System.out.println("==========================");
        System.out.println("--Realizado logoff--");
        pausa();
    }
}
