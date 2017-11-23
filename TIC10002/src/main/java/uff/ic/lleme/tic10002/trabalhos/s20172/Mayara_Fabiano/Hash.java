package trabalho_ed;

public class Hash {

    private final int numeroEsperadoDeElementos;
    private ListaHash[] listahash;
    private ArvoreAvl updateTree = new ArvoreAvl();

    public Hash(int numEsperado) {
        numeroEsperadoDeElementos = numEsperado;
        listahash = new ListaHash[numEsperado];
        for (int i = 0; i < numEsperado; i++) {
            listahash[i] = new ListaHash();
        }
    }

    public int hash(int setorData) {
        return (setorData % numeroEsperadoDeElementos);
    }

    public void insere(int setorData, int fluxo) {
        int indice = hash(setorData);
        listahash[indice].inserir(setorData, fluxo);
        updateTree.inserir(setorData, 0);
    }

    public DadosHash busca(int setorData) {
        int indice = hash(setorData);
        ListaHash temp = listahash[indice];
        return (temp.busca(setorData));
    }

    public boolean remove(int setorData) {
        DadosHash res = busca(setorData);
        if (res == null) {
            return false;
        }
        int indice = hash(setorData);
        listahash[indice].remove(setorData);
        return true;
    }

    public ListaHash[] getListaHash() {
        return this.listahash;
    }

    public ArvoreAvl getUpdateTree() {
        return this.updateTree;
    }
    
    public void removeUpdateTree(){
        updateTree.raiz = null;
    }
}
