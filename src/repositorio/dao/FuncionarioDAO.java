package repositorio.dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.entidade.Funcionario;

public class FuncionarioDAO {

    public void cadastrar(Funcionario f) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("insert into pessoa (nome,cpf,telefone) values (?,?,?)");

            ps.setString(1, f.getNome());
            ps.setString(2, f.getCpf());
            ps.setString(3, f.getTelefone());

            ps.executeUpdate();

            ps = con.prepareStatement("insert into funcionario (cpf,salario) values (?,?)");

            ps.setString(1, f.getCpf());
            ps.setDouble(2, f.getSalario());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

    public void alterar(Funcionario f) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("update pessoa set nome = ?, telefone = ? where cpf = ?");

            ps.setString(1, f.getNome());
            ps.setString(2, f.getTelefone());
            ps.setString(3, f.getCpf());

            ps.executeUpdate();

            ps = con.prepareStatement("update funcionario set salario = ? where cpf = ?");

            ps.setDouble(1, f.getSalario());
            ps.setString(2, f.getCpf());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

    public void remover(Funcionario f) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("delete from pessoa where cpf = ?");

            ps.setString(1, f.getCpf());

            ps.executeUpdate();

            ps = con.prepareStatement("delete from funcionario where cpf = ?");

            ps.setString(1, f.getCpf());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

}
