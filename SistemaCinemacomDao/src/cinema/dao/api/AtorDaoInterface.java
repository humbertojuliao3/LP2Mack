/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.dao.api;

import cinema.dominio.Ator;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface AtorDaoInterface {
    List<Ator> listarTudo();
    void adicionar(Ator a);
    void remover(Ator a);
    void atualizar(Ator a);
    Ator buscaPeloNome(String nome);
}
