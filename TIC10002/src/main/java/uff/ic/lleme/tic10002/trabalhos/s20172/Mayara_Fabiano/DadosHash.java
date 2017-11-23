package trabalho_ed;

public class DadosHash {

    private DadosHash proximo;

    private int setorData;
    private int fluxoAtual;
    private int fluxoAntigo;

    public DadosHash(int setorData, int fluxoAtual) {
        this.setorData = setorData;
        this.fluxoAtual = fluxoAtual;
        this.fluxoAntigo = -1;
    }

    public void setProximo(DadosHash proximo) {
        this.proximo = proximo;
    }

    public DadosHash getProximo() {
        return proximo;
    }

    public int getFluxoAtual() {
        return fluxoAtual;
    }

    public void atualizarFluxoAtual(int valor) {
        fluxoAtual += valor;
    }

    public int getFluxoAntigo() {
        return fluxoAntigo;
    }

    public void atualizarFluxoAntigo() {
        fluxoAntigo = fluxoAtual;
    }

    public int getSetorData() {
        return setorData;
    }
}
