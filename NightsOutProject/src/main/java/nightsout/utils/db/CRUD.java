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

    public static void insertEvent(int idClubOwner, String name, String date, String time, int duration, double price, Statement stm) throws SQLException {
        String saveStm = String.format("INSERT INTO `Events` (`clubOwner`, `price`, `name`, `date`, `duration`, `time`) VALUES ('%d', '%s', '%s', '%s', '%d', '%s');", idClubOwner, String.valueOf(price), name, date, duration, time);
        stm.executeUpdate(saveStm);
    }

}
