/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.dao.impl.relacional.javadb;

import cinema.dao.impl.relacional.ConexaoInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DANIEL
 */
public class ConexaoJavaDb implements ConexaoInterface{
    private String usuario;
    private String senha;
    private String hostName;
    private String nomeDb;
    private int porta;
    private Connection conexao;

    public ConexaoJavaDb(String usuario, String senha, String hostName, String nomeDb, int porta, Connection conexao) {
        this.usuario = usuario;
        this.senha = senha;
        this.hostName = hostName;
        this.nomeDb = nomeDb;
        this.porta = porta;
        this.conexao = conexao;
    }

    @Override
    public Connection getConnection() {
        if (conexao == null){
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String url="jdbc:derby://"+hostName+":"+porta+"/"+nomeDb;
                conexao = DriverManager.getConnection(url,usuario,senha);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexaoJavaDb.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoJavaDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexao;
    }

    @Override
    public void close() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoJavaDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao=null;
    }
    
    
}
