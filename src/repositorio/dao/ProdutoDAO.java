package repositorio.dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import negocio.entidade.Produto;

public class ProdutoDAO {

    public void cadastrar(Produto p) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("insert into produto (codigo,valor,nome) values (?,?,?)");

            ps.setInt(1, p.getCodigo());
            ps.setDouble(2, p.getValor());
            ps.setString(3, p.getNome());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }

    }

    public void alterar(Produto p) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("update into produto (codigo,valor,nome) values (?,?,?)");

            ps.setInt(1, p.getCodigo());
            ps.setDouble(2, p.getValor());
            ps.setString(3, p.getNome());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }

    }
    public void remover(Produto p) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("delete into produto (codigo,valor,nome) values (?,?,?)");

            ps.setInt(1, p.getCodigo());
            ps.setDouble(2, p.getValor());
            ps.setString(3, p.getNome());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }

    }

}

