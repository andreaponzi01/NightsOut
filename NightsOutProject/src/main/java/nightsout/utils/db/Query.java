package nightsout.utils.db;

import nightsout.model.ClubOwnerModel;
import nightsout.model.ResponseModel;
import nightsout.model.ReviewModel;
import nightsout.model.UserModel;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query {

    private Query() {
        //ignored
    }

    public static PreparedStatement searchUserInLogged(PreparedStatement preparedStatement, String username , String password, String type) throws SQLException {
        String query = "SELECT * FROM Credentials WHERE password = ? and username = ? and type = ?";
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query);
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
            preparedStatement = MySqlConnection.connect().prepareStatement(query);
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
            preparedStatement = MySqlConnection.connect().prepareStatement(query);
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
            preparedStatement = MySqlConnection.connect().prepareStatement(query);
            preparedStatement.setString(1, username + "%");
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchUsersByIdUser(int idUser) throws SQLException {
        String query = "SELECT * FROM Users where idUser = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query);
            preparedStatement.setInt(1, idUser);
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchClubOwnersByUsername(String username) throws SQLException {
        String query = "SELECT * FROM ClubOwners where username like ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query);
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
            preparedStatement = MySqlConnection.connect().prepareStatement(query) ;
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
            preparedStatement = MySqlConnection.connect().prepareStatement(query) ;
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
            preparedStatement = MySqlConnection.connect().prepareStatement(query) ;
            preparedStatement.setInt(1, idClubOwner);
        } catch (Exception e) {
            //
        }
            return preparedStatement;
    }

    public static PreparedStatement searchRequestsByIdUser(int idUser) {
        String query = "SELECT * FROM Requests WHERE user = ? and Requests.status <> ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query) ;
            preparedStatement.setInt(1, idUser);
            preparedStatement.setString(2, "accepted");
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchClubOwnerById(int idClubOwner) {
        String query = "SELECT * FROM ClubOwners where idClubOwner = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query);
            preparedStatement.setInt(1, idClubOwner);
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement insertClubOwner(ClubOwnerModel clubOwnerModel) throws SQLException {
        String query = "INSERT INTO ClubOwners (username, email, city, address, clubName, VIPdiscount ) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query);
            preparedStatement.setString(1,clubOwnerModel.getUsername());
            preparedStatement.setString(2, clubOwnerModel.getEmail());
            preparedStatement.setString(3 , clubOwnerModel.getCity());
            preparedStatement.setString(4, clubOwnerModel.getAddress());
            preparedStatement.setString(5, clubOwnerModel.getClubName());
            preparedStatement.setInt(6, clubOwnerModel.getDiscountVIP());

        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement insertUser(UserModel userModel) {
        String query = "INSERT INTO `Users`(`username`, `email`, `name`, `surname`, `birthday`, `gender` ) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = MySqlConnection.connect().prepareStatement(query);
            ps.setString(1,userModel.getUsername());
            ps.setString(2, userModel.getEmail());
            ps.setString(3 , userModel.getName());
            ps.setString(4, userModel.getSurname());
            ps.setDate(5, Date.valueOf(userModel.getBirthday()));
            ps.setString(6, userModel.getGender());

        } catch (Exception e) {
            //
        }
        return ps;
    }

    public static PreparedStatement searchNextEventsByIdUser(int idUser) {
        String query = "SELECT E.* FROM Requests as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.user = U.idUser WHERE U.idUser = ? and R.status='accepted' and DATEDIFF(E.date, CURRENT_TIMESTAMP)>0 ORDER BY E.date;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query) ;
            preparedStatement.setInt(1, idUser);
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchCreatedEventsByIdClubOwner(int idClubOwner) {
        String query = "SELECT * FROM Events where clubOwner = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query) ;
            preparedStatement.setInt(1, idClubOwner);
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }
//modificata
    public static PreparedStatement searchUsersByIdEvent(int idEvent) throws SQLException {
        String query = "SELECT U.* FROM Requests as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.user = U.idUser WHERE E.idEvent = ? and R.status = ?;"; //GIUSTA??
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query);
            preparedStatement.setInt(1, idEvent);
            preparedStatement.setString(2, "accepted");
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchEndedEventsByIdUser(int idUser) {
        //String query = "SELECT E.* FROM Requests as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.user = U.idUser WHERE U.idUser = ? and R.status='accepted' and DATEDIFF(E.date, CURRENT_TIMESTAMP)<0 and E.idEvent NOT IN (SELECT Events.idEvent FROM Events JOIN Reviews ON Reviews.event=Events.idEvent WHERE Reviews.sender = ? );";
        //DA FARE
        String query = "SELECT E.* FROM Requests as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.user = U.idUser WHERE U.idUser = ? and R.status='accepted' and DATEDIFF(E.date, CURRENT_TIMESTAMP)<0 ;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query) ;
            preparedStatement.setInt(1, idUser);
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement insertEventReview(ReviewModel reviewModel) throws SQLException {
        String query = "INSERT INTO Reviews (sender, reviewText, event) VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query);
            preparedStatement.setInt(1,reviewModel.getIdUser());
            preparedStatement.setString(2 , reviewModel.getComment());
            preparedStatement.setInt(3, reviewModel.getIdEvent());

        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchReviewsByIdClubOwner(int idClubOwner) {
        String query = "SELECT R.* FROM Reviews as R JOIN Events as E ON R.event = E.idEvent JOIN ClubOwners as C ON E.clubOwner = C.idClubOwner WHERE C.idClubOwner = ? AND R.idReview NOT IN (SELECT Responses.review FROM Responses WHERE Responses.clubOwner = ?);";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query) ;
            preparedStatement.setInt(1, idClubOwner);
            preparedStatement.setInt(2, idClubOwner);
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchAllReviewsByIdClubOwner(int idClubOwner) {
        String query = "SELECT R.* FROM Reviews as R JOIN Events as E ON R.event = E.idEvent JOIN ClubOwners as C ON E.clubOwner = C.idClubOwner WHERE C.idClubOwner = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query) ;
            preparedStatement.setInt(1, idClubOwner);
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement insertResponse(ResponseModel responseModel) throws SQLException {
        String query = "INSERT INTO Responses (clubOwner, review, responseText) VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query);
            preparedStatement.setInt(1,responseModel.getIdClubOwner());
            preparedStatement.setInt(2 , responseModel.getReview());
            preparedStatement.setString(3, responseModel.getResponse());

        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchEventByIdEvent(int idEvent) {
        String query = "SELECT * FROM Events where idEvent = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query) ;
            preparedStatement.setInt(1, idEvent);
        } catch (Exception e) {
            //
        }
        return preparedStatement;

    }

    public static PreparedStatement searchResponseByIdReview(int idReview) {
        String query = "SELECT * FROM Responses where review = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query) ;
            preparedStatement.setInt(1, idReview);
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement searchReviewByIdEventAndByIdUser(int idUser, int idEvent) {
        String query = "SELECT R.* FROM Reviews as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.sender = U.idUser WHERE U.idUser = ? and E.idEvent= ?;";
        //DA FARE QUERY
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query) ;
            preparedStatement.setInt(1, idUser);
            preparedStatement.setInt(2, idEvent);
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }

    public static PreparedStatement deleteEventById(int idEvent) {
        String query = "DELETE FROM `Events` WHERE `idEvent` = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = MySqlConnection.connect().prepareStatement(query) ;
            preparedStatement.setInt(1, idEvent);
        } catch (Exception e) {
            //
        }
        return preparedStatement;
    }
}
