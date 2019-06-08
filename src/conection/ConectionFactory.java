package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectionFactory {

    public static Connection con = null;

    public static void Conectar() {
        System.out.println("Conectando ao banco...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/autocar", "root", "96147789");
            System.out.println("Conectado.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        if (con == null) {
            Conectar();
        }

        return con;
    }

    public static Connection closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
}
