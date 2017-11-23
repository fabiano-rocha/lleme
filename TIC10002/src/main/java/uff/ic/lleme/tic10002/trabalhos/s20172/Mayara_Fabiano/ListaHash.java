package trabalho_ed;

public class ListaHash {

    private DadosHash primeiro;
    private int tamanho = 0;

    public void inserir(int setorData, int fluxoAtual) {
        DadosHash n = new DadosHash(setorData, fluxoAtual);

        inserir(this.primeiro, n);
    }

    private void inserir(DadosHash aComparar, DadosHash aInserir) {
        if (aComparar == null) {
            this.primeiro = aInserir;
            tamanho++;
        } else {
            while (aComparar.getSetorData() != aInserir.getSetorData()) {
                if (aComparar.getProximo() != null) {
                    aComparar = aComparar.getProximo();
                } else if (aComparar.getSetorData() != aInserir.getSetorData()) {
                    aComparar.setProximo(aInserir);
                    tamanho++;
                    return;
                }
            }
            if (aComparar.getSetorData() == aInserir.getSetorData()) {
                aComparar.atualizarFluxoAtual(aInserir.getFluxoAtual());
            }
        }
    }

    public boolean contem(int setorData) {
        DadosHash anterior = this.primeiro;
        DadosHash atual = anterior.getProximo();

        while (anterior != null) {
            if (this.primeiro.getSetorData() == setorData) {
                this.primeiro = this.primeiro.getProximo();
                return true;
            } else if (atual.getSetorData() == setorData) {
                anterior.setProximo(atual.getProximo());
                return true;
            }
            anterior = anterior.getProximo();
            atual = atual.getProximo();
        }
        return false;
    }

    public void imprimeLista() {
        DadosHash aux = this.primeiro;
        if (aux == null) {
            System.out.println("nulo");
        }
        while (aux != null) {
            System.out.println("Anterior" + aux.getFluxoAntigo() + " Atual:" + aux.getFluxoAtual());
            aux = aux.getProximo();
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public DadosHash busca(int setorData) {
        DadosHash temp = primeiro;
        while (temp != null) {
            if (temp.getSetorData() == setorData) {
                return temp;
            } else {
                temp = temp.getProximo();
            }
        }
        return null;
    }

    public boolean remove(int setorData) {
        DadosHash temp = primeiro;
        if (primeiro.getSetorData() == setorData) {
            primeiro = primeiro.getProximo();
            return true;
        } else {
            while (temp.getProximo() != null) {
                if (temp.getProximo().getSetorData() == setorData) {
                    temp.getProximo().setProximo(temp.getProximo().getProximo());
                    return true;
                }
                temp = temp.getProximo();
            }
            return false;
        }
    }

    public DadosHash getPrimeiro() {
        return this.primeiro;
    }
}
