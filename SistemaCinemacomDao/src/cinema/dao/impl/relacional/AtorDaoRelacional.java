
package cinema.dao.impl.relacional;

import cinema.dao.api.AtorDaoInterface;
import cinema.dominio.Ator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AtorDaoRelacional implements AtorDaoInterface {
    private ConexaoInterface conexao;

    public AtorDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
    }
    
    
    @Override
    public List<Ator> listarTudo() {
        List<Ator> atores;
        atores = new ArrayList();
        PreparedStatement st;
        String sql="SELECT * FROM ator";
        try {
            st= conexao.getConnection().prepareStatement(sql);
            ResultSet resultados = st.executeQuery();
            while(resultados.next()){
                String nome = resultados.getString("nome");
                String nac = resultados.getString("nacionalidade");
                int idade  = resultados.getInt("idade");
                Ator ator = new Ator(nome,nac,idade);
                atores.add(ator);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AtorDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atores;
    }

    @Override
    public void adicionar(Ator a) {
        PreparedStatement st;
        String sql="INSERT INTO ator(nome,nacionalidade,idade) VALUES(?,?,?)";
        try {
            st = conexao.getConnection().prepareStatement(sql);
            String nome = a.getNome();
            String nac = a.getNacionalidade();
            int idade = a.getIdade();
            st.setString(1, nome);
            st.setString(2, nac);
            st.setInt(3, idade);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AtorDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void remover(Ator a) {
        Statement st;
        String sql = "DELETE FROM ator where nome=" + a.getNome()+"AND nacionalidade="+a.getNacionalidade()+"AND idade ="+a.getIdade();
        try {
            st = conexao.getConnection().createStatement();
            st.executeUpdate(sql);            
        } catch (SQLException ex) {
            Logger.getLogger(AtorDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Ator a) {
        
    }

    @Override
    public Ator buscaPeloNome(String nome) {
        PreparedStatement st;
        String sql="SELECT nacionalidade,idade FROM ator WHERE nome="+nome;
        Ator ator = new Ator(nome,"",Integer.valueOf(0));
        try {
            st = conexao.getConnection().prepareStatement(sql);
            ResultSet resultado = st.executeQuery();
            ator = new Ator(nome,resultado.getString("nacionalidade"),resultado.getInt("idade"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ator;
    }
    
}
