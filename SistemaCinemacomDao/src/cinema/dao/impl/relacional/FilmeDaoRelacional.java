/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.dao.impl.relacional;
import cinema.dao.api.FilmeDaoInterface;
import cinema.dominio.Filme;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DANIEL
 */
public class FilmeDaoRelacional implements FilmeDaoInterface {
    private ConexaoInterface conexao;
    
    public FilmeDaoRelacional(ConexaoInterface conexao){
            this.conexao = conexao;
        
    }

    @Override
    public List<Filme> listarTudo() {
        List<Filme> filmes;
        filmes = new ArrayList();
        PreparedStatement st;
        String sql="SELECT * FROM filme";
        try {
            st= conexao.getConnection().prepareStatement(sql);
            ResultSet resultados = st.executeQuery();
            while(resultados.next()){
                String titulo = resultados.getString("titulo");
                long duracao = resultados.getLong("duracao");
                String classEtaria  = resultados.getString("classEtaria");
                String diretor = resultados.getString("diretor");
                String distribuidora = resultados.getString("distribuidora");
                boolean status = resultados.getBoolean("status");
                Filme filme = new Filme(titulo,duracao,classEtaria,diretor,distribuidora,status);
                filmes.add(filme);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filmes;
    }
    

    @Override
    public void adicionar(Filme f){
        PreparedStatement st;
        String sql="INSERT INTO filme(titulo,duracao,classEtaria,diretor,distribuidora,status) VALUES(?,?,?,?,?,?,?)";
        try {
            st = conexao.getConnection().prepareStatement(sql);
            String titulo = f.getTitulo();
            long duracao = f.getDuracao();
            String classEtaria = f.getClassEtaria();
            String diretor = f.getDiretor();
            String distribuidora = f.getDistribuidora();
            boolean status = f.isStatus();
            st.setString(1, titulo);
            st.setLong(2, duracao);
            st.setString(3, classEtaria);
            st.setString(4,diretor);
            st.setString(5,distribuidora);
            st.setBoolean(6,status);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void remover(Filme f) {
        Statement st;
        String sql = "DELETE FROM filme where titulo=" + f.getTitulo()+"AND duracao="+f.getDuracao()+"AND classEtaria ="+f.getClassEtaria()+"AND diretor ="+f.getDiretor()+"AND distribuidora ="+f.getDistribuidora()+"AND status ="+f.isStatus();
        try {
            st = conexao.getConnection().createStatement();
            st.executeUpdate(sql);            
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void atualizar(Filme f) {
        PreparedStatement st;
       String sql="UPDATE filme SET titulo,duracao,classEtaria,diretor,distribuidora,status VALUES (?,?,?,?,?,?)";
        try {
            st = conexao.getConnection().prepareStatement(sql);
            String titulo = f.getTitulo();
            long duracao = f.getDuracao();
            String classEtaria = f.getClassEtaria();
            String diretor = f.getDiretor();
            String distribuidora = f.getDistribuidora();
            boolean status = f.isStatus();
            st.setString(1, titulo);
            st.setLong(2, duracao);
            st.setString(3, classEtaria);
            st.setString(4,diretor);
            st.setString(5,distribuidora);
            st.setBoolean(6,status);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Filme buscarPeloNome(String titulo) {
       PreparedStatement st;
        String sql="SELECT titulo,duracao,classEtaria,diretor,distribuidora,status FROM filme WHERE filme="+titulo;
        Filme filme = new Filme(titulo,0,"","","",true);
        try {
            st = conexao.getConnection().prepareStatement(sql);
            ResultSet resultado = st.executeQuery();
            filme = new Filme(resultado.getString("titulo"),resultado.getLong("duracao"),resultado.getString("classEtaria"),resultado.getString("diretor"),resultado.getString("distribuidora"),resultado.getBoolean("status"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return filme;
    }
    }
    

