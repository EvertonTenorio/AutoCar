package repositorio.dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.entidade.Cliente;
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
            ps = con.prepareStatement("update into pessoa (nome,cpf,telefone) values (?,?,?)");

            ps.setString(1, f.getNome());
            ps.setString(2, f.getCpf());
            ps.setString(3, f.getTelefone());

            ps.executeUpdate();

            ps = con.prepareStatement("update into funcionario (cpf,salario) values (?,?)");

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

    public void remover(Funcionario f) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("delete into pessoa (nome,cpf,telefone) values (?,?,?)");

            ps.setString(1, f.getNome());
            ps.setString(2, f.getCpf());
            ps.setString(3, f.getTelefone());

            ps.executeUpdate();

            ps = con.prepareStatement("delete into funcionario (cpf,salario) values (?,?)");

            ps.setString(1, f.getCpf());
            ps.setDouble(2, f.getSalario());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

}
