/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.dao.impl.relacional;

import cinema.dao.api.ElencoDaoInterface;
import cinema.dominio.Ator;
import cinema.dominio.Filme;
import cinema.dominio.Personagem;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author DANIEL
 */
public class ElencoDaoRelacional implements ElencoDaoInterface {
    private ConexaoInterface conexao;

    public ElencoDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
    }
    
    

    @Override
    public List<Personagem> listarPapel() {
          List<Personagem> personagem = new ArrayList();
        PreparedStatement st;
        String sql="SELECT * FROM personagem";
        try {
            st= conexao.getConnection().prepareStatement(sql);
            ResultSet resultado = st.executeQuery();
            while(resultado.next()){
                String papel = resultado.getString("papel");
                Ator ator =(Ator) resultado.getObject("ator");
                Filme filme =(Filme) resultado.getObject("filme");                               
                Personagem p = new Personagem(papel,ator,filme);
                personagem.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElencoDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personagem;
    }
    }
    

