package nightsout.utils.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query {

    private Query() {
        //ignored
    }

    public static PreparedStatement searchUserInLogged(PreparedStatement preparedStatement, String username , String password, String type) throws SQLException {
        String query = "SELECT * FROM Credentials WHERE password = ? and username = ? and type = ?";
        try {
            preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, type);
        } catch (SQLException e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchUserByUsername(PreparedStatement preparedStatement, String username) throws SQLException{
        String query = "SELECT * FROM Users where username = ?;";
        try {
            preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
        } catch (SQLException e) {
            //
        }
        return  preparedStatement;
    }

    public static PreparedStatement searchClubOwnerByUsername(String username) throws SQLException {
        String query = "SELECT * FROM ClubOwners where username = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchUsersByUsername(String username) throws SQLException {
        String query = "SELECT * FROM Users where username like ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username + "%");
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchClubOwnersByUsername(String username) throws SQLException {
        String query = "SELECT * FROM ClubOwners where username like ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username + "%");
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchEventsByName(String name) throws SQLException {
        String query = "SELECT * FROM Events where name like ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.getConnection().prepareStatement(query) ;
            preparedStatement.setString(1, name + "%");
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchRequest(int idUser, int idEvent) throws SQLException {
        String query = "SELECT * FROM Requests where user = ? and event = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.getConnection().prepareStatement(query) ;
            preparedStatement.setInt(1, idUser);
            preparedStatement.setInt(2, idEvent);
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchRequestsByIdClubOwner(int idClubOwner) {
            String query = "SELECT R.idRequest, R.creationDateTime, U.name, U.surname, E.name FROM Requests as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.user = U.idUser WHERE E.clubOwner = ? and R.status='pending';";
            PreparedStatement preparedStatement = null;
            try {
            preparedStatement = MySqlConnection.getConnection().prepareStatement(query) ;
            preparedStatement.setInt(1, idClubOwner);
        } catch (Exception e) {
            //
        }
            return preparedStatement;
    }
}
