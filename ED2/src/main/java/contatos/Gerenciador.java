package contatos;

import contatos.ABB.ArvoreCodigo;
import contatos.ABB.ArvoreNome;

public class Gerenciador {
    private final ArvoreCodigo arvoreCodigo = new ArvoreCodigo();
    private final ArvoreNome arvoreNome = new ArvoreNome();

    private Contato criaContato(int codigo, String nome, String telefone) {
        return new Contato(codigo, nome, telefone);
    }

    public boolean novoContato(int codigo, String nome, String telefone) {
        Contato contato = criaContato(codigo, nome, telefone);
        boolean adicionado = arvoreCodigo.adicionaNo(contato);
        if (adicionado) {
            arvoreNome.adicionaNo(contato);
            return true;
        }
        return false;
    }

    public Contato pesquisar(int codigo) {
        return arvoreCodigo.pegarNoArvorePorValor(codigo).getValor();
    }

    public Contato pesquisar(String nome) {
        return arvoreNome.pegarNoArvorePorValor(nome).getValor();
    }

    public void listarContatos() {
        arvoreNome.imprimirInOrder();
    }

    public void removerContato(int codigo) {
        Contato contato = pegarContato(codigo);
        arvoreNome.removeNoPorValor(contato.getNome(), contato.getCodigo());
        arvoreCodigo.removeNoPorValor(codigo);
    }

    private Contato pegarContato(int codigo) {
        return arvoreCodigo.pegarNoArvorePorValor(codigo).getValor();
    }
}
