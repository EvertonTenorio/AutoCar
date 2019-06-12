package repositorio.dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            stmt = con.prepareStatement("update into carro (quilometragem) values (?)");
            stmt.setInt(1, c.getKm());

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
            stmt = con.prepareStatement("delete from carro where placa = ?");

            stmt.setString(1, c.getPlaca());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConectionFactory.closeConnection();
        }
    }

    public Carro buscar(String placa) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Carro> carros = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("select * from carro where placa = ?");
            stmt.setString(1, placa);
            rs = stmt.executeQuery();
        
            while (rs.next()){
                
                Carro carro = new Carro();
                
                carro.setKm(rs.getInt("quilometragem"));
                carro.setPlaca(rs.getString("placa"));
                
                carros.add(carro);
                
            }
        
        
        
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConectionFactory.closeConnection();
        }
        return carros.get(0);
        
        }
        
        
}
