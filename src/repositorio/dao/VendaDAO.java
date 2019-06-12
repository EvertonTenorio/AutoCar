package repositorio.dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.entidade.Produto;
import negocio.entidade.Servico;
import negocio.entidade.Venda;

/**
 *
 * @author Everton
 */
public class VendaDAO {

    public void cadastrar(Venda v) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("insert into venda(codigo,valor,cpfPessoa) values (?,?,?)");

            ps.setInt(1, v.getCodigo());
            ps.setDouble(2, v.getValorTotal());
            ps.setString(3, v.getCliente().getCpf());

            ps.executeUpdate();

            for (Produto p : v.getProdutos()) {
                if (p instanceof Produto) {
                    ps = con.prepareStatement("insert into venda_produto(codVenda,codProd) values (?,?)");

                    ps.setInt(1, v.getCodigo());
                    ps.setInt(2, p.getCodigo());

                    ps.executeUpdate();
                } else if (p instanceof Servico) {
                    ps = con.prepareStatement("insert into venda_servico(codVenda,codServico) values (?,?)");

                    ps.setInt(1, v.getCodigo());
                    ps.setInt(2, p.getCodigo());

                    ps.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

    public void alterar(Venda v) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("update venda set valor = ?, cpfPessoa = ? where codigo = ?");

            ps.setDouble(1, v.getValorTotal());
            ps.setString(2, v.getCliente().getCpf());
            ps.setInt(3, v.getCodigo());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

    public void remover(Venda v) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("delete from venda where codigo = ?");

            ps.setInt(1, v.getCodigo());
            ps.executeUpdate();

            ps = con.prepareStatement("delete from venda_produto where codVenda = ?");

            ps.setInt(1, v.getCodigo());
            ps.executeUpdate();

            ps = con.prepareStatement("delete from venda_Servico where codVenda = ?");

            ps.setInt(1, v.getCodigo());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

    public List<Venda> recuperarTodos() {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;
        ArrayList<Venda> lista = null;
        try {
            ps = con.prepareStatement("select * from venda");

            lista = (ArrayList<Venda>) ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}