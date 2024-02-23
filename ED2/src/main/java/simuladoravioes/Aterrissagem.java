package simuladoravioes;

public class Aterrissagem {
    Aviao aviao;
    int tempoAterrisagem;
    private final int combustivelAtribuido;
    private int combustivelAtual;
    private final String nome;
    public Aterrissagem(Aviao aviao, int combustivelAtribuido, int combustivelAtual) {
        this.aviao = aviao;
        this.combustivelAtribuido = combustivelAtribuido;
        this.combustivelAtual = combustivelAtual;
        this.nome = String.format("AV-A%d", aviao.getID());
    }

    public int getCombustivelAtribuido() {
        return combustivelAtribuido;
    }

    public int getCombustivelAtual() {
        return combustivelAtual;
    }

    public void setCombustivelAtual(int combustivelAtual) {
        this.combustivelAtual = combustivelAtual;
    }

    public int getTempoAterrisagem() {
        return tempoAterrisagem;
    }

    public void setTempoAterrisagem(int tempoAterrisagem) {
        this.tempoAterrisagem = tempoAterrisagem;
    }

    public String getNome() {
        return nome;
    }
}
