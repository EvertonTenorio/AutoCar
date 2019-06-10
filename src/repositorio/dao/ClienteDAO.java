package repositorio.dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.entidade.Cliente;

public class ClienteDAO {
    
    public void cadastrar(Cliente c){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement("insert into pessoa (nome,cpf,telefone) values (?,?,?)");
            
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getTelefone());
            
            ps.executeUpdate();
            
            ps = con.prepareStatement("insert into cliente (cpf,frequencia) values (?,?)");
            
            ps.setString(1, c.getCpf());
            ps.setInt(2,c.getFrequencia());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectionFactory.closeConnection();
        }
    }
}