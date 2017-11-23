package trabalho_ed;

public class NoLista {

    private NoLista proximo;

    private int valor;

    public NoLista(NoLista proximo, int valor) {
        this.proximo = proximo;
        this.valor = valor;
    }

    public NoLista(int valor) {
        this.valor = valor;
    }

    public void setProximo(NoLista proximo) {
        this.proximo = proximo;
    }

    public NoLista getProximo() {
        return proximo;
    }

    public int getValor() {
        return valor;
    }
}
