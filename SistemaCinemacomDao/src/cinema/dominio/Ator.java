
package cinema.dominio;

import java.util.List;


public class Ator {
    private String nome;
    private String nacionalidade;
    private int idade;
    private List<Personagem> personagem;

    public Ator(String nome, String nacionalidade, int idade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(short idade) {
        this.idade = idade;
    }

    public List<Personagem> getPersonagem() {
        return personagem;
    }

    public void setPersonagem(List<Personagem> personagem) {
        this.personagem = personagem;
    }

    
    
    
}
