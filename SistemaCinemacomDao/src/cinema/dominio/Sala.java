
package cinema.dominio;

import java.util.List;


public class Sala {
    private int nroSala;
    private int nroCadeira;
    private int qtdCadeirEsp;
    private String status;
    private List<Sessao> sessao;

    public Sala(int nroSala, int nroCadeira, int qtdCadeirEsp, String status) {
        this.nroSala = nroSala;
        this.nroCadeira = nroCadeira;
        this.qtdCadeirEsp = qtdCadeirEsp;
        this.status = status;
    }

    public int getNroSala() {
        return nroSala;
    }

    public void setNroSala(short nroSala) {
        this.nroSala = nroSala;
    }

    public int getNroCadeira() {
        return nroCadeira;
    }

    public void setNroCadeira(short nroCadeira) {
        this.nroCadeira = nroCadeira;
    }

    public int getQtdCadeirEsp() {
        return qtdCadeirEsp;
    }

    public void setQtdCadeirEsp(short qtdCadeirEsp) {
        this.qtdCadeirEsp = qtdCadeirEsp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    public List<Sessao> getSessao() {
        return sessao;
    }

    public void setSessao(List<Sessao> sessao) {
        this.sessao = sessao;
    }
    
    
}
