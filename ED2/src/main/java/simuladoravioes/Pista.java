package simuladoravioes;

import fila.Fila;

import java.security.InvalidParameterException;

public class Pista {
    private final Fila filaAterrissagem1 = new Fila();
    private final Fila filaAterrissagem2 = new Fila();
    private final Fila filaDecolagem = new Fila();

    private Fila validacaoInserirAterrissagem() {
        if (filaAterrissagem1.pegarTamanho() > filaAterrissagem2.pegarTamanho()) {
            return filaAterrissagem2;
        } else {
            return filaAterrissagem1;
        }
    }

    private Fila validacaoRemoverAterrissagem() {
        if (filaAterrissagem1.pegarTamanho() > filaAterrissagem2.pegarTamanho()) {
            return filaAterrissagem2;
        } else if (filaAterrissagem1.pegarTamanho() < filaAterrissagem2.pegarTamanho()) {
            return filaAterrissagem1;
        }
        Aterrissagem at1 = (Aterrissagem) filaAterrissagem1.pegaPrimeiro();
        Aterrissagem at2 = (Aterrissagem) filaAterrissagem2.pegaPrimeiro();
        if (at1.getCombustivelAtual() > at2.getCombustivelAtual()) {
            return filaAterrissagem2;
        }
        return filaAterrissagem1;
    }

    // precisa retornar qual a fila e a posicao -> se tiver só 1 passar para a pista 3,
    // porém isso precisa ser validado junto das outras pistas (responsabilidade do aeroporto)
    private boolean validarEmergencias() {
        for (int i = 0; i < filaAterrissagem1.pegarTamanho(); i++) {
            Aterrissagem aterrissagem = (Aterrissagem) filaAterrissagem1.pegaPosicao(i);
            if (aterrissagem.getCombustivelAtual() >= 1) {
                return true;
            }
            // terminar
        }
        return false;
    }

    public void inserirDecolagem(Decolagem decolagem) {
        filaDecolagem.adicionar(decolagem);
    }

    public void inserirAterissagem(Aterrissagem aterrissagem) {
        Fila fila = validacaoInserirAterrissagem();
        fila.adicionar(aterrissagem);
    }

    public Aviao aterrissarAviao() {
        // fazer validação de qual avião aterissar
        return null;
    }

    public Aviao decolarAviao() {
        return (Aviao) filaDecolagem.poll();
    }

}
