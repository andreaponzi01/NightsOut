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
            statement = connection.createStatement();
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
        /*
        String query = "select * from Credentials";
        ResultSet resultSet = statement.executeQuery(query);

        int i = 1;
        while(resultSet.next()) {
            System.out.print("Row "+i+":\n");
            System.out.print("Username: " + resultSet.getString(1) + " ");
            System.out.print("Password: " + resultSet.getString(2) + " ");
            System.out.print("Type: " + resultSet.getString(3) + " ");
            ++i;

        }
         */
    }
}