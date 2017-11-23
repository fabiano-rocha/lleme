package trabalho_ed;

//import java.util.ArrayList;
public class ArvoreAvl {

    protected NoAvl raiz;

    public void inserir(int chave, int valor) {
        NoAvl n = new NoAvl(chave);
        inserirAVL(this.raiz, n, valor);
    }

    private void inserirAVL(NoAvl aComparar, NoAvl aInserir, int valor) {

        if (aComparar == null) {
            this.raiz = aInserir;
            aInserir.inserirNaLista(valor);
        } else {

            if (aInserir.getChave() < aComparar.getChave()) {

                if (aComparar.getEsquerda() == null) {
                    aComparar.setEsquerda(aInserir);
                    aInserir.inserirNaLista(valor);
                    //System.out.println("testeEsq");
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);

                } else {
                    inserirAVL(aComparar.getEsquerda(), aInserir, valor);
                }

            } else if (aInserir.getChave() > aComparar.getChave()) {

                if (aComparar.getDireita() == null) {
                    aComparar.setDireita(aInserir);
                    aInserir.inserirNaLista(valor);
                    //System.out.println("testeDir");
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);

                } else {
                    inserirAVL(aComparar.getDireita(), aInserir, valor);
                }

            } else {
                //System.out.println("testeAVL");
                aComparar.inserirNaLista(valor);
                //aInserir.inserirNaLista(setorData);
                // O nó já existe insere na lista o valor setorData
            }
        }
    }

    private void verificarBalanceamento(NoAvl atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getBalanceamento();

        if (balanceamento == -2) {

            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
                atual = rotacaoDireita(atual);

            } else {
                atual = duplaRotacaoEsquerdaDireita(atual);
            }

        } else if (balanceamento == 2) {

            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
                atual = rotacaoEsquerda(atual);

            } else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
        }

        if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
        } else {
            this.raiz = atual;
        }
    }

    public void remover(int k, int setorData) {
        removerAVL(this.raiz, k, setorData);
    }

    private void removerAVL(NoAvl atual, int k, int setorData) {
        if (atual == null) {
            return;

        } else {

            if (atual.getChave() > k) {
                removerAVL(atual.getEsquerda(), k, setorData);

            } else if (atual.getChave() < k) {
                removerAVL(atual.getDireita(), k, setorData);

            } else if (atual.getChave() == k) {
                removerNoEncontrado(atual, setorData);
            }
        }
    }

    private void removerNoEncontrado(NoAvl aRemover, int setorData) {
        NoAvl r;

        if (aRemover.getLista().remover(setorData)) {
            if (aRemover.getLista().getPrimeiro() == null) {
                if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {
                    if (aRemover.getPai() == null) {
                        this.raiz = null;
                        aRemover = null;
                        return;
                    }
                    r = aRemover;

                } else {
                    r = sucessor(aRemover);
                    aRemover.setChave(r.getChave());
                }

                NoAvl p;
                if (r.getEsquerda() != null) {
                    p = r.getEsquerda();
                } else {
                    p = r.getDireita();
                }

                if (p != null) {
                    p.setPai(r.getPai());
                }

                if (r.getPai() == null) {
                    this.raiz = p;
                } else {
                    if (r == r.getPai().getEsquerda()) {
                        r.getPai().setEsquerda(p);
                    } else {
                        r.getPai().setDireita(p);
                    }
                    verificarBalanceamento(r.getPai());
                }
                r = null;
            }
        }
    }

    private NoAvl rotacaoEsquerda(NoAvl inicial) {

        NoAvl direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {

            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);

            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    private NoAvl rotacaoDireita(NoAvl inicial) {

        NoAvl esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);

            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    private NoAvl duplaRotacaoEsquerdaDireita(NoAvl inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }

    private NoAvl duplaRotacaoDireitaEsquerda(NoAvl inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }

    private NoAvl sucessor(NoAvl q) {
        if (q.getDireita() != null) {
            NoAvl r = q.getDireita();
            while (r.getEsquerda() != null) {
                r = r.getEsquerda();
            }
            return r;
        } else {
            NoAvl p = q.getPai();
            while (p != null && q == p.getDireita()) {
                q = p;
                p = q.getPai();
            }
            return p;
        }
    }

    private int altura(NoAvl atual) {
        if (atual == null) {
            return -1;
        }

        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 0;

        } else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());

        } else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());

        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    private void setBalanceamento(NoAvl no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    public int minFluxo() {
        return minFluxo(raiz, 0);
    }

    private int minFluxo(NoAvl no, int min) {
        NoAvl aux = no;
        while (aux != null) {
            min = aux.getChave();
            aux = aux.getEsquerda();
        }
        //System.out.println("Menor fluxo: "+min);
        return min;
    }

    public int maxFluxo() {
        return maxFluxo(raiz, 0);
    }

    private int maxFluxo(NoAvl no, int max) {
        NoAvl aux = no;
        while (aux != null) {
            max = aux.getChave();
            aux = aux.getDireita();
        }
        //System.out.println("Maior fluxo: "+max);
        return max;
    }

    public void emOrdem(double limiar) {
        ArvoreAvl.this.emOrdem(raiz, limiar);
    }

    private void emOrdem(NoAvl no, double limiar) {
        NoAvl aux = no;
        if (aux != null) {
            ArvoreAvl.this.emOrdem(aux.getEsquerda(), limiar);
            if (aux.getChave() > limiar) {
                aux.imprimeLista(aux.getChave());
            }
            ArvoreAvl.this.emOrdem(aux.getDireita(), limiar);
        }
    }

    //updateTree
    public void emOrdem(Hash hashTable, ArvoreAvl tree) {
        emOrdem(raiz, hashTable, tree);
    }

    private void emOrdem(NoAvl no, Hash hashTable, ArvoreAvl tree) {
        NoAvl aux = no;
        if (aux != null) {
            emOrdem(aux.getEsquerda(), hashTable, tree);
            tree.atualizaAVL(hashTable.busca(aux.getChave()), tree);
            emOrdem(aux.getDireita(), hashTable, tree);
        }
    }

    public void atualizaAVL(DadosHash aux, ArvoreAvl arvore) {
        arvore.remover(aux.getFluxoAntigo(), aux.getSetorData());
        arvore.inserir(aux.getFluxoAtual(), aux.getSetorData());
        aux.atualizarFluxoAntigo();
    }
}
