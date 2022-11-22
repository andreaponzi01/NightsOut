package nightsout.utils;

import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.DBConnectionFailedException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {

    private Authentication() {
        //ignored
    }

    public static boolean checkIsRegistered(String username, String password, String type) {
        PreparedStatement preparedStatement = null;
        try {
            MySqlConnection.tryConnect();
            preparedStatement = Query.searchUserInLogged(preparedStatement, username, password, type);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (DBConnectionFailedException e) {
            MyNotification.createNotification(e);
        } catch (SQLException e) {
            //
        }
        return false;
    }

}
