package simuladoravioes;

public class Decolagem {
    Aviao aviao;
    int tempoDecolagem;
    private final String nome;

    public Decolagem(Aviao aviao) {
        this.aviao = aviao;
        this.nome = String.format("AV-D%d", aviao.getID());
    }

    public int getTempoDecolagem() {
        return tempoDecolagem;
    }

    public void setTempoDecolagem(int tempoDecolagem) {
        this.tempoDecolagem = tempoDecolagem;
    }

    public String getNome() {
        return nome;
    }
}
