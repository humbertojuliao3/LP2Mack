
package cinema.dominio;


public class Sala {
    private short nroSala;
    private short nroCadeira;
    private short qtdCadeirEsp;
    private boolean status;

    public Sala(short nroSala, short nroCadeira, short qtdCadeirEsp, boolean status) {
        this.nroSala = nroSala;
        this.nroCadeira = nroCadeira;
        this.qtdCadeirEsp = qtdCadeirEsp;
        this.status = status;
    }

    public short getNroSala() {
        return nroSala;
    }

    public void setNroSala(short nroSala) {
        this.nroSala = nroSala;
    }

    public short getNroCadeira() {
        return nroCadeira;
    }

    public void setNroCadeira(short nroCadeira) {
        this.nroCadeira = nroCadeira;
    }

    public short getQtdCadeirEsp() {
        return qtdCadeirEsp;
    }

    public void setQtdCadeirEsp(short qtdCadeirEsp) {
        this.qtdCadeirEsp = qtdCadeirEsp;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
