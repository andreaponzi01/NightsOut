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
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return statement;
    }

    private static void connect() throws SQLException, ClassNotFoundException {

        String user;
        String pass;
        String dbUrl;
        String driverClassName;

        if(connection==null){
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
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    // PreparedStatements
    public  static java.sql.PreparedStatement insertClubOwner() throws SQLException {
        return connection.prepareStatement( "INSERT INTO `ClubOwners`(`username`, `email`, `city`, `address`, `clubName`, `VIPdiscount` ) VALUES (?, ?, ?, ?, ?, ?)" );
    }

    public  static java.sql.PreparedStatement insertUser() throws SQLException {
        return connection.prepareStatement( "INSERT INTO `Users`(`username`, `email`, `name`, `surname`, `birthday`, `gender` ) VALUES (?, ?, ?, ?, ?, ?)" );
    }

}