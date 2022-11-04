package nightsout.utils.db;

import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

    private CRUD() {
        //ignored
    }

    public static void insertCredentials(String username, String password, String type, Statement stm) throws SQLException {
        String saveStm = String.format("INSERT INTO `Credentials` (`Username`, `Password`, `Type`) VALUES ('" + username + "', '%s', '%s');", password, type);
        stm.executeUpdate(saveStm);
    }

}
