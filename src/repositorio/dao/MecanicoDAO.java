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

            ps = con.prepareStatement("insert into funcionario (cpf,salario) values (?,?)");

            ps.setString(1, m.getCpf());
            ps.setDouble(2, m.getSalario());

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
            ps = con.prepareStatement("update pessoa set nome = ?, telefone = ? where cpf = ?");

            ps.setString(1, m.getNome());
            ps.setString(2, m.getTelefone());
            ps.setString(3, m.getCpf());

            ps.executeUpdate();

            ps = con.prepareStatement("update funcionario set salario = ? where cpf = ?");

            ps.setDouble(1, m.getSalario());
            ps.setString(2, m.getCpf());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

    public void remover(Mecanico m) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("delete from pessoa where cpf = ?");

            ps.setString(1, m.getCpf());

            ps.executeUpdate();

            ps = con.prepareStatement("delete from funcionario where cpf = ?");

            ps.setString(1, m.getCpf());

            ps.executeUpdate();
            
            ps = con.prepareStatement("dele from mecanico where cpf = ?");
            
            ps.setString(1, m.getCpf());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Removido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

}
