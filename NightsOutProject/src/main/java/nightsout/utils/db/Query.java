package nightsout.utils.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {

    private Query() {
        //ignored
    }
    public static ResultSet searchUserInLogged(String username , String password, String type, Statement stm) throws SQLException {
        String sql = "SELECT * FROM Credentials where password = '" + password + "'and username = '" + username + "'and type= '" + type + "' ;";
        return stm.executeQuery(sql);
    }
/*
    public static ResultSet searchUserInLoggedPreparedStatement(String username , String password, String type, Statement stm) throws SQLException {
        String query = "SELECT * FROM Credentials WHERE password = ? and username = ? and type = ?";
        PreparedStatement pstmt = MySqlConnection.connection.prepareStatement( query );
        pstmt.setString( 1, password);
        pstmt.setString( 2, username);
        pstmt.setString( 3, type);

        return (pstmt.executeQuery());
    }
*/
    public static ResultSet searchUserByUsername(Statement stm, String username) throws SQLException{
        String sql = "SELECT * FROM Users where username = '" + username + "' ;";
        return stm.executeQuery(sql);
    }

    public static ResultSet searchClubOwnerByUsername(Statement stm, String username) throws SQLException {
        String sql = "SELECT * FROM ClubOwners where username = '" + username + "' ;";
        return stm.executeQuery(sql);
    }

    public static ResultSet searchUsersByUsername(Statement stm, String username) throws SQLException {
        String sql = "SELECT * FROM Users where username like '" + username + "%' ;";
        return stm.executeQuery(sql);
    }

    public static ResultSet searchEventsByName(Statement stm, String name) throws SQLException {
        String sql = "SELECT * FROM Events where name like '" + name + "%' ;";
        return stm.executeQuery(sql);
    }

    public static ResultSet searchRequest(Statement stm, int idUser, int idEvent) throws SQLException {
        String sql = "SELECT * FROM Requests where user = '" + idUser  + "' and event = '" + idEvent+"' ;";
        return stm.executeQuery(sql);
    }
}
