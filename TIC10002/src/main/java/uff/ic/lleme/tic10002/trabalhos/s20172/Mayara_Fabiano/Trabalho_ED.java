package trabalho_ed;

public class Trabalho_ED {

    public static void main(String[] args) {
        ArvoreAvl noAvl = new ArvoreAvl();

        Hash hashTable = new Hash(1000);

        double limiar = 0;

        System.out.println("Primeiro bloco de atualizações");
        hashTable.insere(17101001, 151);
        hashTable.insere(17081525, 181);
        hashTable.insere(17041216, 530);
        hashTable.insere(17041516, 201);
        hashTable.insere(17081510, 152);
        hashTable.insere(17101003, 541);
        hashTable.insere(17070507, 541);
        hashTable.insere(17032704, 182);
        hashTable.insere(17081408, 81);
        hashTable.insere(17031525, 201);
        hashTable.insere(17101101, 151);
        hashTable.insere(17081325, 181);
        hashTable.insere(17041116, 530);
        hashTable.insere(17041716, 201);
        hashTable.insere(17080710, 152);
        hashTable.insere(17100803, 541);
        hashTable.insere(17070307, 541);
        hashTable.insere(17032304, 182);
        hashTable.insere(17081808, 210);
        hashTable.insere(17031125, 201);

        hashTable.getUpdateTree().emOrdem(hashTable, noAvl);
        hashTable.removeUpdateTree();

        System.out.println("Fluxo Minimo: " + noAvl.minFluxo());
        System.out.println("Fluxo Maximo: " + noAvl.maxFluxo());

        //min(fluxo) + 0.8Δ, onde Δ = max(fluxo) − min(fluxo).
        limiar = noAvl.minFluxo() + 0.8 * (noAvl.maxFluxo() - noAvl.minFluxo());
        System.out.println("Limiar: " + limiar);
        System.out.println("Saída: {setor,dia,fluxo}");
        
        noAvl.emOrdem(limiar);

        System.out.println("\nSegundo bloco de atualizações");

        hashTable.insere(17101011, 530);
        hashTable.insere(17101011, 1);
        hashTable.insere(17081515, 521);
        hashTable.insere(17041206, 495);
        hashTable.insere(17041506, 500);
        hashTable.insere(17081511, 652);
        hashTable.insere(17101004, 341);
        hashTable.insere(17070509, 641);
        hashTable.insere(17032711, 382);
        hashTable.insere(17081418, 381);
        hashTable.insere(17031505, 401);
        hashTable.insere(17101111, 351);
        hashTable.insere(17081313, 10);
        hashTable.insere(17041118, 30);
        hashTable.insere(17041712, 501);
        hashTable.insere(17080711, 352);
        hashTable.insere(17100824, 241);
        hashTable.insere(17070317, 341);
        hashTable.insere(17032302, 582);
        hashTable.insere(17081801, 410);
        hashTable.insere(17031121, 73);

        hashTable.getUpdateTree().emOrdem(hashTable, noAvl);
        hashTable.removeUpdateTree();

        System.out.println("Fluxo Minimo: " + noAvl.minFluxo());
        System.out.println("Fluxo Maximo: " + noAvl.maxFluxo());

        //min(fluxo) + 0.8Δ, onde Δ = max(fluxo) − min(fluxo).
        limiar = noAvl.minFluxo() + 0.8 * (noAvl.maxFluxo() - noAvl.minFluxo());
        System.out.println("Limiar: " + limiar);
        System.out.println("Saída: {setor,dia,fluxo}");

        noAvl.emOrdem(limiar);
    }
}
