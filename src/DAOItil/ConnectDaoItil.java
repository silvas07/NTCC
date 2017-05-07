package DAOItil;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by rdsdo on 01/05/2017.
 */
public class ConnectDaoItil {

    private Connection connection = null;

    public Connection abrirCanneccao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntcc", "root", "root");
            return connection;
        } catch (Exception e) {
            System.out.println("Erro na conex‹o: " + e.getMessage());
        }
        return connection;
    }

    public void facharConneccao() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }


}