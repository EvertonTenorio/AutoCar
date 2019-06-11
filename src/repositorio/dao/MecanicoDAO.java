package repositorio.dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import negocio.entidade.Mecanico;

public class MecanicoDAO {

    public void cadastrar(Mecanico m) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("insert into pessoa (nome,cpf,telefone) values (?,?,?)");

            ps.setString(1, m.getNome());
            ps.setString(2, m.getCpf());
            ps.setString(3, m.getTelefone());

            ps.executeUpdate();

            ps = con.prepareStatement("insert into mecanico (cpf,bonificacao) values (?,?)");

            ps.setString(1, m.getCpf());
            ps.setDouble(2, m.getBonificacao());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

    public void alterar(Mecanico m) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("update into pessoa (nome,cpf,telefone) values (?,?,?)");

            ps.setString(1, m.getNome());
            ps.setString(2, m.getCpf());
            ps.setString(3, m.getTelefone());

            ps.executeUpdate();

            ps = con.prepareStatement("update into mecanico (cpf,bonificacao) values (?,?)");

            ps.setString(1, m.getCpf());
            ps.setDouble(2, m.getBonificacao());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

    public void remover(Mecanico m) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("delete into pessoa (nome,cpf,telefone) values (?,?,?)");

            ps.setString(1, m.getNome());
            ps.setString(2, m.getCpf());
            ps.setString(3, m.getTelefone());

            ps.executeUpdate();

            ps = con.prepareStatement("delete into mecanico (cpf,bonificacao) values (?,?)");

            ps.setString(1, m.getCpf());
            ps.setDouble(2, m.getBonificacao());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

}
