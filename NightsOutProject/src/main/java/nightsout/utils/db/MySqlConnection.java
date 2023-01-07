package nightsout.utils.db;

import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.SystemException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlConnection {
    private static Connection connection;

    private MySqlConnection(){
        //ignore
    }

    public static Connection connect() throws SystemException {

        String user;
        String pass;
        String dbUrl;
        String driverClassName;

        try {
            if (connection == null || connection.isClosed()) {
                String resourceName = "config.properties";
                InputStream inputStream = MySqlConnection.class.getClassLoader().getResourceAsStream(resourceName);
                Properties props = new Properties();
                props.load(inputStream);
                pass = props.getProperty("PASS");
                user = props.getProperty("USER");
                dbUrl = props.getProperty("DB_URL");
                driverClassName = props.getProperty("DRIVER_CLASS_NAME");
                Class.forName(driverClassName);
                DriverManager.setLoginTimeout(5);
                connection = DriverManager.getConnection(dbUrl, user, pass);
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 0)
                Trigger.throwDBConnectionFailedException(e);
            else {
                SystemException ex = new SystemException();
                ex.initCause(e);
                throw ex;
            }
        } catch (ClassNotFoundException | IOException e) {
            SystemException ex = new SystemException();
            ex.initCause(e);
            throw ex;
        }
        return connection;
    }


    public static void closeConnection() throws SQLException { connection.close(); }
}