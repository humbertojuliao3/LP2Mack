
package cinema.dao.api;

import cinema.dominio.Sala;
import java.util.List;


public interface SalaDaoInterface {
    List<Sala> listarSalas();
    void adicionar(Sala s);
    void atualizar(Sala s);
    void remover (Sala s);
    Sala buscarPeloNro(short nroSala);
}
