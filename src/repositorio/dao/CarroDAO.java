package repositorio.dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;
import negocio.entidade.Carro;

public class CarroDAO {

    public void cadastrar(Carro c) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into carro (placa, quilometragem) values (?,?)");
            stmt.setString(1, c.getPlaca());
            stmt.setInt(2, c.getKm());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();

        }
    }

    public void alterar(Carro c) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update into carro (placa, quilometragem) values (?,?)");
            stmt.setString(1, c.getPlaca());
            stmt.setInt(2, c.getKm());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }

    }

    public void remover(Carro c) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("delete into carro (placa, quilometragem) values (?,?)");
            stmt.setString(1, c.getPlaca());
            stmt.setInt(2, c.getKm());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

    public void buscar(Carro c) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
    }
}
