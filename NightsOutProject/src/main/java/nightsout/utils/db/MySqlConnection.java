package nightsout.utils.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MySqlConnection {
    private static Connection connection;

    private MySqlConnection(){
        //ignore
    }

    public static Statement tryConnect() {
        Statement statement = null;
        try {
            connect();
            /*
            ** ResultSet.CONCUR_READ_ONLY --> ResultSet.CONCUR_UPDATABLE (capire quale sia più indicato!)
            */
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static Connection connect() throws SQLException{

        String user;
        String pass;
        String dbUrl;
        String driverClassName;

        if(connection==null || connection.isClosed()){
            try {
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
            } catch ( IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


    public static void closeConnection() throws SQLException {
        connection.close();
        //connection=null;

    }
}