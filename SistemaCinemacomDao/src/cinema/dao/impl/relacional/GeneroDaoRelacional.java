/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.dao.impl.relacional;

import cinema.dao.api.GeneroDaoInterface;
import cinema.dominio.Genero;
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
public class GeneroDaoRelacional implements GeneroDaoInterface{

    private ConexaoInterface conexao;

    public GeneroDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
    }
    
    
    @Override
    public List<Genero> listarTudo() {
     List<Genero> generos;
     generos = new ArrayList();
     PreparedStatement st;
     String sql = "SELECT * FROM genero";
        try {
            st = conexao.getConnection().prepareStatement(sql);
            ResultSet resultados = st.executeQuery();
            while(resultados.next()){
                String nome = resultados.getString("nome");
                String desc = resultados.getString("descricao");
                Genero g = new Genero(nome,desc);
                generos.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generos;
     
    }

    @Override
    public void adicionar(Genero g) {
        PreparedStatement st;
        String sql="INSERT INTO genero(nome,descricao) VALUES(?,?)";
        try {
            st = conexao.getConnection().prepareStatement(sql);
            st.setString(1, g.getNome());
            st.setString(2, g.getDescricao());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void remover(Genero g) {
        PreparedStatement st;
        String sql ="DELETE FROM genero WHERE nome="+g.getNome()+"AND descricao="+g.getDescricao();
        try {
            st=conexao.getConnection().prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Genero buscarPeloNome(String nome) {
        PreparedStatement st;
        String sql="SELECT descricao WHERE nome="+nome;
        Genero g = new Genero("","");
        try {
            st= conexao.getConnection().prepareStatement(sql);
            ResultSet resultado = st.executeQuery();
            g = new Genero(nome,resultado.getString("descricao")); 
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }
    
}
