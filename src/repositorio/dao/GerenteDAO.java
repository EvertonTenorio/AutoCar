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
            ps = con.prepareStatement("call addGerente(?,?,?,?,?,?)");

            ps.setString(1, g.getCpf());
            ps.setString(2, g.getNome());
            ps.setString(3, g.getTelefone());
            ps.setDouble(2, g.getSalario());
            ps.setString(2, g.getLogin());
            ps.setString(3, g.getSenha());

            

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
            ps = con.prepareStatement("update pessoa set nome = ?, telefone = ? where cpf = ?");

            ps.setString(1, g.getNome());
            ps.setString(2, g.getTelefone());
            ps.setString(3, g.getCpf());;

            ps.executeUpdate();

            ps = con.prepareStatement("update funcionario set salario = ? where cpf = ?");

            ps.setDouble(1, g.getSalario());
            ps.setString(2, g.getCpf());

            ps.executeUpdate();

            ps = con.prepareStatement("update gerente set login = ?, senha = ? where cpf = ?");

            ps.setString(1, g.getLogin());
            ps.setString(2, g.getSenha());
            ps.setString(3, g.getCpf());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

    public void remover(Gerente g) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("delete from pessoa where cpf = ?");

            ps.setString(1, g.getCpf());

            ps.executeUpdate();

            ps = con.prepareStatement("delete from funcionario where cpf = ?");

            ps.setString(1, g.getCpf());

            ps.executeUpdate();

            ps = con.prepareStatement("delete from gerente where cpf = ?");
            
            ps.setString(1, g.getCpf());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Removido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }
}
