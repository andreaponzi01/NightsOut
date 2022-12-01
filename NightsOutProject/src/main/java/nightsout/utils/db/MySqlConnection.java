package nightsout.utils.db;

import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.DBConnectionFailedException;
import nightsout.utils.exception.myexception.SystemException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MySqlConnection {
    private static Connection connection;

    private MySqlConnection(){
        //ignore
    }

    public static Statement tryConnect() throws DBConnectionFailedException {
        Statement statement = null;
        try {
            connect();
            /*
            ** ResultSet.CONCUR_READ_ONLY --> ResultSet.CONCUR_UPDATABLE (capire quale sia più indicato!)
            */
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            Trigger.throwDBConnectionFailedException(e);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
        return statement;
    }

    public static Connection connect() throws SystemException, DBConnectionFailedException {

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
            /*
        } catch (SQLException | ClassNotFoundException | IOException e) {
            ExceptionHandler.handleException(e);
        }
             */
        } catch (SQLException | ClassNotFoundException | IOException e) {
            ExceptionHandler.handleException(e);
        }
        return connection;
    }


    public static void closeConnection() throws SQLException { connection.close(); }
}