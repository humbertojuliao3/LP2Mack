
package cinema.dominio;


public class Personagem {
    private String papel;
    private Ator ator;
    private Filme filme;

    public Personagem(String papel, Ator ator, Filme filme) {
        this.papel = papel;
        this.ator = ator;
        this.filme = filme;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    
}
