package trabalho_ed;

public class ListaNoAvl {

    private NoLista primeiro;

    public void inserir(int k) {
        NoLista n = new NoLista(k);
        inserir(this.primeiro, n);
    }

    private void inserir(NoLista aComparar, NoLista aInserir) {
        if (aComparar == null) {
            this.primeiro = aInserir;
        } else {
            while (aComparar.getProximo() != null) {
                aComparar = aComparar.getProximo();
            }
            aComparar.setProximo(aInserir);
        }
    }

    public boolean remover(int setorData) {
        NoLista anterior = this.primeiro;
        NoLista atual = anterior.getProximo();

        while (anterior != null) {
            if (this.primeiro.getValor() == setorData) {
                this.primeiro = this.primeiro.getProximo();
                return true;
            } else if (atual.getValor() == setorData) {
                anterior.setProximo(atual.getProximo());
                return true;
            }
            anterior = anterior.getProximo();
            atual = atual.getProximo();
        }
        return false;
    }

    public void imprimeLista(int fluxo) {
        NoLista aux = this.primeiro;
        if (aux == null) {
            System.out.println("nulo");
        }
        //{setor,dia,fluxo}
        while (aux != null) {
            System.out.println("{"+aux.getValor()%100 +","+aux.getValor()/100 +","+ fluxo + "}");
            aux = aux.getProximo();
        }
    }

    public NoLista getPrimeiro() {
        return this.primeiro;
    }
}