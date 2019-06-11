package repositorio.dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import negocio.entidade.Gerente;

public class GerenteDAO {

    public void cadastrar(Gerente g) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("insert into pessoa (nome,cpf,telefone) values (?,?,?)");

            ps.setString(1, g.getNome());
            ps.setString(2, g.getCpf());
            ps.setString(3, g.getTelefone());

            ps.executeUpdate();

            ps = con.prepareStatement("insert into gerente (cpf,login,senha) values (?,?,?)");

            ps.setString(1, g.getCpf());
            ps.setString(2, g.getLogin());
            ps.setString(3, g.getSenha());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

    public void alterar(Gerente g) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("update into pessoa (nome,cpf,telefone) values (?,?,?)");

            ps.setString(1, g.getNome());
            ps.setString(2, g.getCpf());
            ps.setString(3, g.getTelefone());

            ps.executeUpdate();

            ps = con.prepareStatement("update into gerente (cpf,login,senha) values (?,?,?)");

            ps.setString(1, g.getCpf());
            ps.setString(2, g.getLogin());
            ps.setString(3, g.getSenha());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

    public void remover(Gerente g) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("delete into pessoa (nome,cpf,telefone) values (?,?,?)");

            ps.setString(1, g.getNome());
            ps.setString(2, g.getCpf());
            ps.setString(3, g.getTelefone());

            ps.executeUpdate();

            ps = con.prepareStatement("delete into gerente (cpf,login,senha) values (?,?,?)");

            ps.setString(1, g.getCpf());
            ps.setString(2, g.getLogin());
            ps.setString(3, g.getSenha());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }
}
