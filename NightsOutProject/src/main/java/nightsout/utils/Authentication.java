package nightsout.utils;

import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {

    private Authentication() {
        //ignored
    }

    public static int checkIsRegistered(String username, String password, String type) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            MySqlConnection.tryConnect();
            preparedStatement = Query.searchUserInLogged(preparedStatement, username, password, type);
            ResultSet rs = preparedStatement.executeQuery();
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
