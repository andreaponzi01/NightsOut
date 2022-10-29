package nightsout.utils.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
    public static ResultSet searchUserInLogged(String username , String password, String type, Statement stm) throws SQLException {
        String sql = "SELECT * FROM Credentials where password = '" + password + "'and username = '" + username + "'and type= '" + type + "' ;";
        return stm.executeQuery(sql) ;
    }

}
