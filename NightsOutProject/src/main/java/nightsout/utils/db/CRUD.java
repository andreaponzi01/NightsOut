package nightsout.utils.db;

import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

    private CRUD() {
        //ignored
    }

    public static void insertCredentials(String username, String password, String type, Statement stm) throws SQLException {
        String saveStm = String.format("INSERT INTO `Credentials` (`Username`, `Password`, `Type`) VALUES ('%s', '%s', '%s');", username, password, type);
        stm.executeUpdate(saveStm);
    }

    public static void insertEvent(int idClubOwner, String name, String date, String time, int duration, double price, Statement stm) throws SQLException {
        String saveStm = String.format("INSERT INTO `Events` (`clubOwner`, `price`, `name`, `date`, `duration`, `time`) VALUES ('%d', '%s', '%s', '%s', '%d', '%s');", idClubOwner, String.valueOf(price), name, date, duration, time);
        stm.executeUpdate(saveStm);
    }
    public static void subscriptionVipUser( String username, Statement stm) throws SQLException {
        String saveStm = String.format("UPDATE `Users` SET `VIP` = '1', creationDateVIP=CURRENT_DATE WHERE (`username` = '%s');", username);
        stm.executeUpdate(saveStm);

    }

    public static void insertRequest(int id, int idEvent, Statement stm) throws SQLException {
        String saveStm = String.format("INSERT INTO `Requests` (`user`, `event`, `status`) VALUES ('%d', '%d', '%s')", id, idEvent, "pending");
        stm.executeUpdate(saveStm);
    }

    public static void updateRequest(int id, int idEvent, Statement stm, String status) throws SQLException {
        String saveStm = String.format("UPDATE `Requests` SET `status` = '%s' WHERE (`user` = '%d' AND `event` = '%d')", status, id, idEvent);
        stm.executeUpdate(saveStm);
    }
}
