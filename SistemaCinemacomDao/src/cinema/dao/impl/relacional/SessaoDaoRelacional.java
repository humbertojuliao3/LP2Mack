/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.dao.impl.relacional;

import cinema.dao.api.SessaoDaoInterface;
import cinema.dominio.Filme;
import cinema.dominio.Ingresso;
import cinema.dominio.Sala;
import cinema.dominio.Sessao;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author DANIEL
 */
public class SessaoDaoRelacional implements SessaoDaoInterface {
    private ConexaoInterface conexao;

    public SessaoDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
    }
    
    

    @Override
    public List<Sessao> listarTudo() {
       List<Sessao> sessao;
        sessao = new ArrayList();
        PreparedStatement st;
        String sql="SELECT * FROM sessao";
        try {
            st= conexao.getConnection().prepareStatement(sql);
            ResultSet resultados = st.executeQuery();
            while(resultados.next()){
                Date horario = resultados.getDate("horario");
                Filme filme =(Filme) resultados.getObject("filme");
                List ingresso  =(List) resultados.getObject("ingresso");
                Sala sala =(Sala) resultados.getObject("sala");
                Sessao s = new Sessao(horario,filme,sala,ingresso);
                sessao.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessao;
    }

    @Override
    public void adicionar(Sessao s) {
        PreparedStatement st;
        String sql="INSERT INTO sessao(horario,filme,ingresso,sala) VALUES(?,?,?,?,?,?,?)";
        try {
            st = conexao.getConnection().prepareStatement(sql);
            Date horario = s.getHorario();
            Filme filme = s.getFilme();
            List ingresso = s.getIngressos();
            Sala sala = s.getSala();
            st.setObject(1, horario);
            st.setObject(2, filme);
            st.setObject(3, ingresso);
            st.setObject(4,sala);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(Sessao s) {
      Statement st;
        String sql = "DELETE FROM sessao where horario=" + s.getHorario()+"AND filme="+s.getFilme()+"AND ingresso ="+s.getIngressos()+"AND sala ="+s.getSala();
        try {
            st = conexao.getConnection().createStatement();
            st.executeUpdate(sql);            
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Sessao s) {
      PreparedStatement st;
       String sql="UPDATE sessao SET horario,filme,ingresso,sala VALUES (?,?,?,?)";
        try {
            st = conexao.getConnection().prepareStatement(sql);
            Date horario = s.getHorario();
            Filme filme = s.getFilme();
            List ingresso = s.getIngressos();
            Sala sala = s.getSala();           
            st.setObject(1, horario);
            st.setObject(2, filme);
            st.setObject(3, ingresso);
            st.setObject(4,sala);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Sessao buscarpeloNro(String nro) {
     PreparedStatement st;
        String sql="SELECT horario,filme,ingresso,sala FROM sessao WHERE sala="+nro;
        Sessao sessao=null;
        try {
            st = conexao.getConnection().prepareStatement(sql);
            ResultSet resultado = st.executeQuery();
          sessao = new Sessao(resultado.getDate("horario"),(Filme)resultado.getObject("filme"),(Sala)resultado.getObject("sala"),(List<Ingresso>)resultado.getObject("ingresso"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return sessao;
    }
    
}
