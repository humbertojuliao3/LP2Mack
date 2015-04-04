/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.dao.impl.relacional;

import cinema.dao.api.SalaDaoInterface;
import cinema.dominio.Sala;
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
public class SalaDaoRelacional implements SalaDaoInterface{

    private ConexaoInterface conexao;

    public SalaDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
    }  
    
    @Override
    public List<Sala> listarSalas() {
        List<Sala> salas = new ArrayList();
        PreparedStatement st;
        String sql="SELECT * FROM sala";
        try {
            st= conexao.getConnection().prepareStatement(sql);
            ResultSet resultado = st.executeQuery();
            while(resultado.next()){
                int ns = resultado.getInt("numSala");
                int qct = resultado.getInt("qtdCadeirasTotal");
                int qce = resultado.getInt("qtdCadeirasESP");                
                String stt = resultado.getString("status");                
                Sala s = new Sala(ns,qct,qce,stt);
                salas.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salas;
    }

    @Override
    public void adicionar(Sala s) {
        PreparedStatement st;
        String sql="INSERT INTO sala(numSala,qtdCadeirasTotal,qtdCadeirasESP,status) VALUES(?,?,?,?)";
        try {
            st = conexao.getConnection().prepareStatement(sql);
            st.setInt(1, s.getNroSala());
            st.setInt(2, s.getNroCadeira());
            st.setInt(3, s.getQtdCadeirEsp());
            st.setString(4, s.getStatus());
        } catch (SQLException ex) {
            Logger.getLogger(SalaDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Sala s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Sala s) {
        PreparedStatement st;
        String sql="DELETE FROM sala WHERE numSala="+s.getNroSala();
        try {
            st = conexao.getConnection().prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SalaDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public Sala buscarPeloNro(short nroSala) {
        PreparedStatement st;
        String sql="SELECT qtdCadeirasTotal,qtdCadeirasESP,status WHERE numSala="+nroSala;
        Sala s = new Sala(Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"");
        try {
            st = conexao.getConnection().prepareStatement(sql);
            ResultSet r = st.executeQuery();
            s = new Sala(nroSala,r.getInt("qtdCadeirasTotal"),r.getInt("qtdCadeirasESP"),r.getString("status"));
            
        } catch (SQLException ex) {
            Logger.getLogger(SalaDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    
    
}
