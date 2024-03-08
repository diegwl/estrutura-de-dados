package senhas;

import fila.Fila;

import java.util.Scanner;

public class Gerenciador {
    private Fila fila = new Fila();
    private Fila filaPreferencial = new Fila();
    Scanner scanner = new Scanner(System.in);

    private int senhaAtual = 0;
    int op;

    public void menu() {
        System.out.println(
                "---GERENCIADOR-DE-SENHAS---" +
                "1. Senha Normal" +
                "2. Senha Preferencial" +
                "3. Chamar Senha" +
                "4. Sair do Programa"
        );
        scanner.nextInt(op);
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

    public int adicionarFila() {
        senhaAtual++;
        fila.adicionar(senhaAtual);
        return senhaAtual;
    }

    public int adicionarFilaPreferencial() {
        senhaAtual++;
        filaPreferencial.adicionar(senhaAtual);
        return senhaAtual;
    }

    public int chamarSenha() {
        if (!filaPreferencial.ehVazia()) {
            return (int) filaPreferencial.poll();
        } else if (!fila.ehVazia()) {
            return (int) filaPreferencial.poll();
        }
        throw new IllegalArgumentException("Sem Senhas para Chamar");
    }
}
