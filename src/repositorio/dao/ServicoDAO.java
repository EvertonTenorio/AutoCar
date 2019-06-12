package repositorio.dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import negocio.entidade.Servico;


public class ServicoDAO {
    public void cadastrar(Servico s) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into produto (codigo, valor, nome) values (?,?,?)");
            stmt.setInt(1, s.getCodigo());
            stmt.setDouble(2, s.getValor());
            stmt.setString(3, s.getNome());

            stmt.executeUpdate();
            
            stmt = con.prepareStatement("insert into servico (codigo, mecanico) values (?,?)");
            stmt.setInt(1, s.getCodigo());
            stmt.setObject(2, s.getMecanico());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();

        }
    }
    
    public void alterar(Servico s) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("update produto set valor = ?, nome = ? where codigo = ?");

            ps.setDouble(1, s.getValor());
            ps.setString(2, s.getNome());
            ps.setInt(3, s.getCodigo());

            ps.executeUpdate();

            ps = con.prepareStatement("update servico set mecanico = ? where codigo = ?");

            ps.setObject(1, s.getMecanico());
            ps.setInt(2, s.getCodigo());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }
    
    public void remover(Servico s) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("delete from produto where codigo = ?");

            ps.setInt(1, s.getCodigo());

            ps.executeUpdate();

            ps = con.prepareStatement("delete from servico where codigo = ?");

            ps.setInt(1, s.getCodigo());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }
    
}
