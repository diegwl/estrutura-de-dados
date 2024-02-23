package simuladoravioes;

public class Aviao {
    private final int ID;

    private final int tempoEntrada;

    public Aviao(int ID, int tempoEntrada) {
        this.ID = ID;
        this.tempoEntrada = tempoEntrada;
    }

    public int getID() {
        return ID;
    }

    public int getTempoEntrada() {
        return tempoEntrada;
    }
}
