package contatos;

import java.util.Scanner;

public class Main {
    static Gerenciador gerenciadorDeContatos = new Gerenciador();
    static Scanner scanner = new Scanner(System.in);
    static int op;
    static boolean on = true;
    public static void main(String[] args) {
        try {
            while (on) {
                System.out.println(
                        """
                        
                        ---GERENCIADOR-DE-CONTATOS---
                        1. Adicionar Contato
                        2. Pesquisar Contato por Código
                        3. Pesquisar Contato por Nome
                        4. Remover Contato
                        5. Listar Contatos
                        6. Sair do Programa
    
                        Digite a opção desejada:\s
                        """
                );
                op = scanner.nextInt();
                scanner.nextLine();

                int cod;
                String nome;
                String telefone;
                Contato contato;

                switch (op) {
                    case 1:
                        System.out.println("Adicionando Contato");
                        System.out.print("Código: ");
                        cod = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        nome  = scanner.nextLine();
                        System.out.print("Telefone: ");
                        telefone = scanner.nextLine();

                        boolean adicionado = gerenciadorDeContatos.novoContato(cod, nome, telefone);
                        if (adicionado) {
                            System.out.println("Contato Adicionado");
                        } else {
                            System.out.println("Código já existente");
                        }
                        break;
                    case 2:
                        System.out.println("Pesquisando Contato");
                        System.out.print("Código: ");
                        cod = scanner.nextInt();
                        scanner.nextLine();

                        contato = gerenciadorDeContatos.pesquisar(cod);
                        if (contato != null) {
                            System.out.printf("Contato Encontrado\nCódigo: %d\nNome: %s\nTelefone: %s\n", contato.getCodigo(), contato.getNome(), contato.getTelefone());
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                        break;
                    case 3:
                        System.out.println("Pesquisando Contato");
                        System.out.print("Nome: ");
                        nome = scanner.nextLine();

                        contato = gerenciadorDeContatos.pesquisar(nome);
                        if (contato != null) {
                            System.out.printf("Contato Encontrado\nCódigo: %d\nNome: %s\nTelefone: %s\n", contato.getCodigo(), contato.getNome(), contato.getTelefone());
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                        break;
                    case 4:
                        System.out.println("Removendo Contato");
                        System.out.print("Código: ");
                        cod = scanner.nextInt();
                        scanner.nextLine();

                        gerenciadorDeContatos.removerContato(cod);
                        break;
                    case 5:
                        System.out.println("Listando Contatos");
                        gerenciadorDeContatos.listarContatos();
                        break;
                    case 6:
                        System.out.println("Finalizando o Programa...");
                        on = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
