package DAOItil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by rdsdo on 01/05/2017.
 */
public class ConnectDao {

    private Connection connection = null;

    public Connection abrirConeccao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/senhas", "root", "root");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return connection;
    }

    public void fecharConeccao () {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}