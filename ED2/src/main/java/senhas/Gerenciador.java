package senhas;

import fila.Fila;

import java.util.Scanner;

public class Gerenciador {
    private final Fila fila = new Fila();
    private final Fila filaPreferencial = new Fila();
    Scanner scanner = new Scanner(System.in);

    private int senhaAtual = 0;
    int op;

    public void menu() {
        System.out.println(
                "---GERENCIADOR-DE-SENHAS---\n" +
                "1. Senha Normal\n" +
                "2. Senha Preferencial\n" +
                "3. Chamar Senha\n" +
                "4. Sair do Programa\n" +
                "\nDigite a opção desejada: "
        );
        op = scanner.nextInt();
        switch (op) {
            case 1:
                adicionarFila();
                System.out.printf("Sua senha é: %d\n", senhaAtual);
                break;
            case 2:
                adicionarFilaPreferencial();
                System.out.printf("Sua senha é: %d\n", senhaAtual);
                break;
            case 3:
                int senhaChamada = chamarSenha();
                if (senhaChamada == 0) {
                    System.out.println("Sem senhas para chamar");
                } else System.out.printf("Senha Chamada: %d\n", senhaChamada);
                break;
            case 4:
                System.out.println("Finalizando o Programa...");
                return;
        }
        menu();
    }

    private void adicionarFila() {
        senhaAtual++;
        fila.adicionar(senhaAtual);
    }

    private void adicionarFilaPreferencial() {
        senhaAtual++;
        filaPreferencial.adicionar(senhaAtual);
    }

    private int chamarSenha() {
        if (!filaPreferencial.ehVazia()) {
            return (int) filaPreferencial.poll();
        } else if (!fila.ehVazia()) {
            return (int) fila.poll();
        }
        return 0;
    }
}
