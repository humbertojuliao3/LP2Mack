
package cinema.dao.api;

import cinema.dominio.Genero;
import java.util.List;


public interface GeneroDaoInterface {
    List<Genero> listarTudo();
    void adicionar(Genero g);
    void remover(Genero g);
    Genero buscarPeloNome(String nome);
}
