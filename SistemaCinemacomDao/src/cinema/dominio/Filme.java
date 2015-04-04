
package cinema.dominio;

import java.util.List;


public class Filme {
    private String titulo;
    private long duracao;
    private String classEtaria;
    private String diretor;
    private String distribuidora;
    private boolean status;
    private List<Personagem> personagem;
    private Genero genero;

    public Filme(String titulo, long duracao, String classEtaria, String diretor, String distribuidora, boolean status) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.classEtaria = classEtaria;
        this.diretor = diretor;
        this.distribuidora = distribuidora;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getDuracao() {
        return duracao;
    }

    public void setDuracao(long duracao) {
        this.duracao = duracao;
    }

    public String getClassEtaria() {
        return classEtaria;
    }

    public void setClassEtaria(String classEtaria) {
        this.classEtaria = classEtaria;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Personagem> getPersonagem() {
        return personagem;
    }

    public void setPersonagem(List<Personagem> personagem) {
        this.personagem = personagem;
    }

    

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    
}
