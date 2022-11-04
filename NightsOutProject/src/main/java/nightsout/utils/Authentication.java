package nightsout.utils;

import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authentication {

    private Authentication() {
        //ignored
    }

    public static int checkIsRegistered(String username, String password, String type) throws SQLException {
        Statement stm = null;
        try {
            stm = MySqlConnection.tryConnect();
            ResultSet rs = Query.searchUserInLogged(username, password, type, stm);
            if (rs.next()) {
                return 1;
            }
        } catch (SQLException e) {
            //Da gestire
            e.printStackTrace();
        }
        return 0;
    }

}
