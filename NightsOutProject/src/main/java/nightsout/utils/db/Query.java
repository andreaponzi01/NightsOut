package nightsout.utils.db;

import nightsout.model.*;
import nightsout.utils.engineering.ConverterToFile;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query {

    private static final String PATH_PROFILE_IMGS = "profileImgs/";
    private static final String PATH_EVENTS_IMGS = "eventImgs/";

    private Query() {
        //ignored
    }

    public static boolean searchUserInLogged(CredentialsModel credentialsModel) throws SystemException {
        String query = "SELECT * FROM Credentials WHERE password = ? and username = ? and type = ?";

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)){
            preparedStatement.setString(1, credentialsModel.getPassword());
            preparedStatement.setString(2, credentialsModel.getUsername());
            preparedStatement.setString(3, credentialsModel.getType());

            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }

        return false;
    }

    public static UserModel searchUserByUsername(String username) throws SystemException {
        String query = "SELECT * FROM Users where username = ?;";
        UserModel userModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)){
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            userModel = new UserModel();

            userModel.setUsername(rs.getString(2));
            userModel.setName(rs.getString(6));
            userModel.setSurname(rs.getString(8));
            userModel.setGender(rs.getString(7));
            userModel.setEmail(rs.getString(4));
            userModel.setId(rs.getInt(1));
            userModel.setVip(rs.getBoolean(9));
            userModel.setCreationDateVip((rs.getDate(10) == null) ? null : rs.getDate(10).toLocalDate());
            userModel.setBirthday(rs.getDate(5).toLocalDate());

            InputStream inputStream = (rs.getBinaryStream(3));
            String filePath = PATH_PROFILE_IMGS + username + "pic" + ".png";
            File file = new File(filePath);
            ConverterToFile.fromInputStreamToFile(inputStream, file);
            userModel.setProfileImg(file);

            return userModel;
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return  userModel;
    }

    public static ClubOwnerModel searchClubOwnerByUsername(String username) throws SystemException {
        String query = "SELECT * FROM ClubOwners where username = ?;";
        ClubOwnerModel clubOwnerModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            // username
            clubOwnerModel = new ClubOwnerModel();
            clubOwnerModel.setUsername(rs.getString(2));
            clubOwnerModel.setClubName(rs.getString(7));
            clubOwnerModel.setEmail(rs.getString(4));
            clubOwnerModel.setCity(rs.getString(5));
            clubOwnerModel.setAddress(rs.getString(6));
            clubOwnerModel.setId(rs.getInt(1));
            clubOwnerModel.setDiscountVIP(rs.getInt(8));

            InputStream inputStream = (rs.getBinaryStream(3));
            String filePath = PATH_PROFILE_IMGS + username + "pic" + ".png";
            File file = new File(filePath);
            ConverterToFile.fromInputStreamToFile(inputStream, file);
            clubOwnerModel.setProfileImg(file);

            return clubOwnerModel;

        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return clubOwnerModel;
    }

    public static List<UserModel> searchUsersByUsername(String username) throws SystemException {
        String query = "SELECT * FROM Users where username like ?;";
        List<UserModel> list = null;
        UserModel userModel;

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            list = new ArrayList<>();
            preparedStatement.setString(1, username + "%");
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }

            do {
                userModel = new UserModel();
                userModel.setUsername(rs.getString(2));
                userModel.setName(rs.getString(6));
                userModel.setSurname(rs.getString(8));
                userModel.setGender(rs.getString(7));
                userModel.setEmail(rs.getString(4));
                userModel.setId(rs.getInt(1));
                userModel.setVip(rs.getBoolean(9));
                userModel.setCreationDateVip((rs.getDate(10) == null) ? null : rs.getDate(10).toLocalDate());
                userModel.setBirthday(rs.getDate(5).toLocalDate());

                InputStream in = (rs.getBinaryStream(3));
                // Modificata
                String filePath = PATH_PROFILE_IMGS + userModel.getUsername() + "pic" + ".png";
                File file = new File(filePath);
                ConverterToFile.fromInputStreamToFile(in, file);
                userModel.setProfileImg(file);

                list.add(userModel);

            } while(rs.next());

            return list;

        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static UserModel searchUsersByIdUser(int idUser) throws SystemException {
        String query = "SELECT * FROM Users where idUser = ?;";
        UserModel userModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idUser);

            ResultSet rs = preparedStatement.executeQuery();
            rs.next();


            userModel = new UserModel();
            userModel.setUsername(rs.getString(2));
            userModel.setName(rs.getString(6));
            userModel.setSurname(rs.getString(8));
            userModel.setGender(rs.getString(7));
            userModel.setEmail(rs.getString(4));
            userModel.setId(rs.getInt(1));
            userModel.setVip(rs.getBoolean(9));
            userModel.setCreationDateVip((rs.getDate(10) == null) ? null : rs.getDate(10).toLocalDate());
            userModel.setBirthday(rs.getDate(5).toLocalDate());
            InputStream inputStream = (rs.getBinaryStream(3));
            String filePath = PATH_PROFILE_IMGS + userModel.getUsername() + "pic" + ".png";
            File file = new File(filePath);
            ConverterToFile.fromInputStreamToFile(inputStream, file);
            userModel.setProfileImg(file);

            return userModel;
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return userModel;
    }

    public static List<ClubOwnerModel> searchClubOwnersByUsername(String username) throws SystemException {
        String query = "SELECT * FROM ClubOwners where username like ?;";
        List<ClubOwnerModel> list = null;
        ClubOwnerModel clubOwnerModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            list = new ArrayList<>();
            preparedStatement.setString(1, username + "%");

            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }

            do {
                clubOwnerModel = new ClubOwnerModel();
                clubOwnerModel.setUsername(rs.getString(2));
                clubOwnerModel.setClubName(rs.getString(7));
                clubOwnerModel.setEmail(rs.getString(4));
                clubOwnerModel.setCity(rs.getString(5));
                clubOwnerModel.setAddress(rs.getString(6));
                clubOwnerModel.setId(rs.getInt(1));
                clubOwnerModel.setDiscountVIP(rs.getInt(8));
                InputStream inputStream = (rs.getBinaryStream(3));
                // Modificata
                String filePath = PATH_PROFILE_IMGS + clubOwnerModel.getUsername() + "pic" + ".png";
                File file = new File(filePath);
                ConverterToFile.fromInputStreamToFile(inputStream, file);
                clubOwnerModel.setProfileImg(file);

                list.add(clubOwnerModel);
            } while(rs.next());

            return list;

        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static List<EventModel> searchEventsByName(String name) throws SystemException {
        String query = "SELECT * FROM Events where name like ?;";
        List<EventModel> list = null;
        EventModel eventModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            list = new ArrayList<>();
            preparedStatement.setString(1, name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }


            do {
                eventModel = new EventModel();
                eventModel.setName(rs.getString(5));
                eventModel.setIdEvent(rs.getInt(1));
                eventModel.setIdClubOwner(rs.getInt(2));
                eventModel.setTime(rs.getTime(10).toLocalTime());
                eventModel.setPrice(rs.getDouble(4));
                eventModel.setDuration(rs.getInt(7));
                eventModel.setEventDate(rs.getDate(6).toLocalDate());
                eventModel.setDescription(rs.getString(11));

                InputStream inputStream = (rs.getBinaryStream(9));
                String filePath = PATH_EVENTS_IMGS + eventModel.getName() + "pic" + ".png";
                File file = new File(filePath);
                ConverterToFile.fromInputStreamToFile(inputStream, file);
                eventModel.setImg(file);

                list.add(eventModel);

            } while(rs.next());

            return list;
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static RequestModel searchRequest(int idUser, int idEvent) throws SystemException {

        String query = "SELECT * FROM Requests where user = ? and event = ?;";
        RequestModel requestModel = null;

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idUser);
            preparedStatement.setInt(2, idEvent);
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return null;
            }

            requestModel = new RequestModel();
            requestModel.setIdRequest(rs.getInt(1));
            requestModel.setIdUser(rs.getInt(2));
            requestModel.setIdEvent(rs.getInt(4));
            requestModel.setStatus(rs.getString(3));
            requestModel.setRequestDate(rs.getDate(5).toLocalDate());

            return requestModel;

        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return requestModel;
    }

    public static List<RequestModel> searchRequestsByIdClubOwner(int idClubOwner) throws SystemException {

        List<RequestModel> list = null;
        RequestModel requestModel = null;
        String query = "SELECT R.* FROM Requests as R JOIN Events as E ON R.event = E.idEvent WHERE E.clubOwner = ? and R.status='pending';";

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            list = new ArrayList<>();

            preparedStatement.setInt(1, idClubOwner);
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()) {
                return list;
            }

            do {
                requestModel = new RequestModel();
                requestModel.setIdRequest(rs.getInt(1));
                requestModel.setRequestDate(rs.getDate(5).toLocalDate());
                requestModel.setStatus(rs.getString(3));
                requestModel.setIdEvent(rs.getInt(4));
                requestModel.setIdUser(rs.getInt(2));

                list.add(requestModel);
            } while(rs.next());

            return list;
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return list;
    }


    public static List<RequestModel> searchRequestsByIdUser(int idUser) throws SystemException {

        List<RequestModel> list = null;
        RequestModel requestModel = null;
        String query = "SELECT * FROM Requests WHERE user = ?;";

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            list = new ArrayList<>();
            preparedStatement.setInt(1, idUser);

            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()) {
                return list;
            }

            do {
                requestModel = new RequestModel();
                requestModel.setIdRequest(rs.getInt(1));
                requestModel.setIdEvent(rs.getInt(4));
                requestModel.setIdUser(rs.getInt(2));
                requestModel.setStatus(rs.getString(3));
                requestModel.setRequestDate(rs.getDate(5).toLocalDate());

                list.add(requestModel);
            } while(rs.next());

            return list;
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static ClubOwnerModel searchClubOwnerById(int idClubOwner) throws SystemException {
        String query = "SELECT * FROM ClubOwners where idClubOwner = ?;";

        ClubOwnerModel clubOwnerModel = null;

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idClubOwner);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            clubOwnerModel = new ClubOwnerModel();
            clubOwnerModel.setUsername(rs.getString(2));
            clubOwnerModel.setClubName(rs.getString(7));
            clubOwnerModel.setEmail(rs.getString(4));
            clubOwnerModel.setCity(rs.getString(5));
            clubOwnerModel.setAddress(rs.getString(6));
            clubOwnerModel.setId(rs.getInt(1));
            clubOwnerModel.setDiscountVIP(rs.getInt(8));

            InputStream inputStream = (rs.getBinaryStream(3));
            String filePath = PATH_PROFILE_IMGS + clubOwnerModel.getUsername() + "pic" + ".png";
            File file = new File(filePath);
            ConverterToFile.fromInputStreamToFile(inputStream, file);
            clubOwnerModel.setProfileImg(file);

            return clubOwnerModel;

        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return clubOwnerModel;
    }

    public static void insertClubOwner(ClubOwnerModel clubOwnerModel) throws SystemException {

        String query = "INSERT INTO ClubOwners (username, email, city, address, clubName, VIPdiscount, `profileImg` ) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setString(1,clubOwnerModel.getUsername());
            preparedStatement.setString(2, clubOwnerModel.getEmail());
            preparedStatement.setString(3 , clubOwnerModel.getCity());
            preparedStatement.setString(4, clubOwnerModel.getAddress());
            preparedStatement.setString(5, clubOwnerModel.getClubName());
            preparedStatement.setInt(6, clubOwnerModel.getDiscountVIP());
            preparedStatement.setBlob(7, new FileInputStream(clubOwnerModel.getProfileImg()));

            preparedStatement.executeUpdate();

        } catch (SQLException | FileNotFoundException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public static void insertEvent(EventModel eventModel) throws SystemException {

        String query = "INSERT INTO `Events` (`clubOwner`, `price`, `name`, `date`, `duration`, `time`, `description`, `img`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setInt(1,eventModel.getIdClubOwner());
            preparedStatement.setDouble(2, eventModel.getPrice());
            preparedStatement.setString(3 , eventModel.getName());
            preparedStatement.setDate(4, Date.valueOf(eventModel.getEventDate()));
            preparedStatement.setInt(5, eventModel.getDuration());
            preparedStatement.setTime(6, Time.valueOf(eventModel.getTime()));
            preparedStatement.setString(7, eventModel.getDescription());
            preparedStatement.setBlob(8, new FileInputStream(eventModel.getImg()));

            preparedStatement.executeUpdate();

        } catch (SQLException | FileNotFoundException e) {
            ExceptionHandler.handleException(e);
        }
    }


    public static void insertUser(UserModel userModel) throws SystemException {

        String query = "INSERT INTO `Users`(`username`, `email`, `name`, `surname`, `birthday`, `gender`, `profileImg` ) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setString(1,userModel.getUsername());
            preparedStatement.setString(2, userModel.getEmail());
            preparedStatement.setString(3 , userModel.getName());
            preparedStatement.setString(4, userModel.getSurname());
            preparedStatement.setDate(5, Date.valueOf(userModel.getBirthday()));
            preparedStatement.setString(6, userModel.getGender());
            preparedStatement.setBlob(7, new FileInputStream(userModel.getImg()));

            preparedStatement.executeUpdate();

        } catch (SQLException | FileNotFoundException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public static List<EventModel> searchNextEventsByIdUser(int idUser) throws SystemException {

        String query = "SELECT E.* FROM Requests as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.user = U.idUser WHERE U.idUser = ? and R.status='accepted' and DATEDIFF(E.date, CURRENT_TIMESTAMP)>0 ORDER BY E.date;";

        List<EventModel> list = null;
        EventModel eventModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            list = new ArrayList<>();
            preparedStatement.setInt(1, idUser);
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }


            do {
                eventModel = new EventModel();
                eventModel.setName(rs.getString(5));
                eventModel.setIdEvent(rs.getInt(1));
                eventModel.setIdClubOwner(rs.getInt(2));
                eventModel.setTime(rs.getTime(10).toLocalTime());
                eventModel.setPrice(rs.getDouble(4));
                eventModel.setDuration(rs.getInt(7));
                eventModel.setEventDate(rs.getDate(6).toLocalDate());
                eventModel.setDescription(rs.getString(11));

                InputStream inputStream = (rs.getBinaryStream(9));
                String filePath = PATH_EVENTS_IMGS + eventModel.getName() + "pic" + ".png";
                File file = new File(filePath);
                ConverterToFile.fromInputStreamToFile(inputStream, file);
                eventModel.setImg(file);


                list.add(eventModel);

            } while(rs.next());

            return list;

        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static List<EventModel> searchCreatedEventsByIdClubOwner(int idClubOwner) throws SystemException {

        String query = "SELECT * FROM Events where clubOwner = ?;";
        List<EventModel> list = null;
        EventModel eventModel = null;

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            list = new ArrayList<>();
            preparedStatement.setInt(1, idClubOwner);

            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }


            do {
                eventModel = new EventModel();
                eventModel.setName(rs.getString(5));
                eventModel.setIdEvent(rs.getInt(1));
                eventModel.setIdClubOwner(rs.getInt(2));
                eventModel.setTime(rs.getTime(10).toLocalTime());
                eventModel.setPrice(rs.getDouble(4));
                eventModel.setDuration(rs.getInt(7));
                eventModel.setEventDate(rs.getDate(6).toLocalDate());
                eventModel.setDescription(rs.getString(11));

                InputStream inputStream = (rs.getBinaryStream(9));
                String filePath = PATH_EVENTS_IMGS + eventModel.getName() + "pic" + ".png";
                File file = new File(filePath);
                ConverterToFile.fromInputStreamToFile(inputStream, file);
                eventModel.setImg(file);

                list.add(eventModel);

            } while(rs.next());

            return list;

        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return list;
    }
//modificata
    public static List<UserModel> searchUsersByIdEvent(int idEvent) throws SystemException {

        String query = "SELECT U.* FROM Requests as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.user = U.idUser WHERE E.idEvent = ? and R.status = ?;"; //GIUSTA??
        List<UserModel> list = null;
        UserModel userModel = null;

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            list = new ArrayList<>();
            preparedStatement.setInt(1, idEvent);
            preparedStatement.setString(2, "accepted");
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }

            do {

                userModel = new UserModel();
                userModel.setUsername(rs.getString(2));
                userModel.setName(rs.getString(6));
                userModel.setSurname(rs.getString(8));
                userModel.setGender(rs.getString(7));
                userModel.setEmail(rs.getString(4));
                userModel.setId(rs.getInt(1));
                userModel.setVip(rs.getBoolean(9));
                userModel.setBirthday(rs.getDate(5).toLocalDate());
                userModel.setCreationDateVip((rs.getDate(10) == null) ? null : rs.getDate(10).toLocalDate());

                InputStream in = (rs.getBinaryStream(3));
                String filePath = PATH_PROFILE_IMGS+userModel.getUsername()+"pic"+".png";
                File file = new File(filePath);
                ConverterToFile.fromInputStreamToFile(in, file);
                userModel.setProfileImg(file);

                list.add(userModel);

            } while(rs.next());

            return list;

        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static List<EventModel>  searchEndedEventsByIdUser(int idUser) throws SystemException {

        String query = "SELECT E.* FROM Requests as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.user = U.idUser WHERE U.idUser = ? and R.status='accepted' and DATEDIFF(E.date, CURRENT_TIMESTAMP)<0 ;";
        List<EventModel> list = null;
        EventModel eventModel = null;

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            list = new ArrayList<>();
            preparedStatement.setInt(1, idUser);

            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }


            do {
                eventModel = new EventModel();
                eventModel.setName(rs.getString(5));
                eventModel.setIdEvent(rs.getInt(1));
                eventModel.setIdClubOwner(rs.getInt(2));
                eventModel.setTime(rs.getTime(10).toLocalTime());
                eventModel.setPrice(rs.getDouble(4));
                eventModel.setDuration(rs.getInt(7));
                eventModel.setEventDate(rs.getDate(6).toLocalDate());
                eventModel.setDescription(rs.getString(11));

                InputStream inputStream = (rs.getBinaryStream(9));
                String filePath = PATH_EVENTS_IMGS + eventModel.getName() + "pic" + ".png";
                File file = new File(filePath);
                ConverterToFile.fromInputStreamToFile(inputStream, file);
                eventModel.setImg(file);

                list.add(eventModel);

            } while(rs.next());

            return list;

        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static void insertEventReview(ReviewModel reviewModel) throws SystemException {
        String query = "INSERT INTO Reviews (sender, reviewText, event) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setInt(1,reviewModel.getIdUser());
            preparedStatement.setString(2 , reviewModel.getComment());
            preparedStatement.setInt(3, reviewModel.getIdEvent());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public static List<ReviewModel> searchReviewsByIdClubOwner(int idClubOwner) throws SystemException {
        String query = "SELECT R.* FROM Reviews as R JOIN Events as E ON R.event = E.idEvent JOIN ClubOwners as C ON E.clubOwner = C.idClubOwner WHERE C.idClubOwner = ? AND R.idReview NOT IN (SELECT Responses.review FROM Responses WHERE Responses.clubOwner = ?);";
        List<ReviewModel> list = null;
        ReviewModel reviewModel = null;

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            list = new ArrayList<>();
            preparedStatement.setInt(1, idClubOwner);
            preparedStatement.setInt(2, idClubOwner);

            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }


            do {
                reviewModel = new ReviewModel();
                reviewModel.setIdReview(rs.getInt(1));
                reviewModel.setIdEvent(rs.getInt(4));
                reviewModel.setIdUser(rs.getInt(2));
                reviewModel.setComment(rs.getString(3));

                list.add(reviewModel);

            } while(rs.next());

            return list;
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static List<ReviewModel> searchAllReviewsByIdClubOwner(int idClubOwner) throws SystemException {
        String query = "SELECT R.* FROM Reviews as R JOIN Events as E ON R.event = E.idEvent JOIN ClubOwners as C ON E.clubOwner = C.idClubOwner WHERE C.idClubOwner = ?;";
        List<ReviewModel> list = null;
        ReviewModel reviewModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            list = new ArrayList<>();
            preparedStatement.setInt(1, idClubOwner);

            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }


            do {
                reviewModel = new ReviewModel();
                reviewModel.setIdReview(rs.getInt(1));
                reviewModel.setIdEvent(rs.getInt(4));
                reviewModel.setIdUser(rs.getInt(2));
                reviewModel.setComment(rs.getString(3));

                list.add(reviewModel);

            } while(rs.next());

            return list;
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static void insertResponse(ResponseModel responseModel) throws SystemException {
        String query = "INSERT INTO Responses (clubOwner, review, responseText) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setInt(1,responseModel.getIdClubOwner());
            preparedStatement.setInt(2 , responseModel.getReview());
            preparedStatement.setString(3, responseModel.getResponse());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public static EventModel searchEventByIdEvent(int idEvent) throws SystemException {
        String query = "SELECT * FROM Events where idEvent = ?;";
        EventModel eventModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idEvent);

            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            eventModel = new EventModel();
            eventModel.setName(rs.getString(5));
            eventModel.setIdEvent(rs.getInt(1));
            eventModel.setIdClubOwner(rs.getInt(2));
            eventModel.setTime(rs.getTime(10).toLocalTime());
            eventModel.setPrice(rs.getDouble(4));
            eventModel.setDuration(rs.getInt(7));
            eventModel.setEventDate(rs.getDate(6).toLocalDate());
            eventModel.setDescription(rs.getString(11));

            InputStream inputStream = (rs.getBinaryStream(9));
            String filePath = PATH_EVENTS_IMGS + eventModel.getName() + "pic" + ".png";
            File file = new File(filePath);
            ConverterToFile.fromInputStreamToFile(inputStream, file);
            eventModel.setImg(file);


            return eventModel;
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return eventModel;

    }

    public static ResponseModel searchResponseByIdReview(int idReview) throws SystemException {

        String query = "SELECT * FROM Responses where review = ?;";
        ResponseModel responseModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idReview);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                responseModel = new ResponseModel();
                responseModel.setIdAnswer(rs.getInt(1));
                responseModel.setIdClubOwner(rs.getInt(2));
                responseModel.setReview(rs.getInt(3));
                responseModel.setResponse(rs.getString(4));
            }

            return responseModel;
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return responseModel;
    }

    public static ReviewModel searchReviewByIdEventAndByIdUser(int idUser, int idEvent) throws SystemException {
        String query = "SELECT R.* FROM Reviews as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.sender = U.idUser WHERE U.idUser = ? and E.idEvent= ?;";
        //DA FARE QUERY
        ReviewModel reviewModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idUser);
            preparedStatement.setInt(2, idEvent);

            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return null;
            }


            reviewModel = new ReviewModel();
            reviewModel.setIdReview(rs.getInt(1));
            reviewModel.setIdEvent(rs.getInt(4));
            reviewModel.setIdUser(rs.getInt(2));
            reviewModel.setComment(rs.getString(3));


            return reviewModel;
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return reviewModel;
    }

    public static void deleteEventById(int idEvent) throws SystemException {
        String query = "DELETE FROM `Events` WHERE `idEvent` = ?";

        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idEvent);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public static ClubOwnerModel searchClubAddressByEventId(int idEvent) throws SystemException {
        String query = "SELECT username, address, city FROM ClubOwners JOIN Events WHERE clubOwner = idClubOwner AND idEvent = ?;";
        ClubOwnerModel clubOwnerModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idEvent);

            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return null;
            }

            clubOwnerModel = new ClubOwnerModel();
            clubOwnerModel.setUsername(rs.getString(2));
            clubOwnerModel.setAddress(rs.getString(2));
            clubOwnerModel.setCity(rs.getString(3));

            return clubOwnerModel;
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return clubOwnerModel;
    }

    public static boolean checkUsernameAlreadyTaken(String username) throws SystemException {

        String query = "SELECT username FROM Credentials WHERE username = ?";
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)){
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return true;
    }

    public static void updateRequest(int id, String status) throws SystemException {

        String query = "UPDATE `Requests` SET `status` = ? WHERE `idRequest` = ?";
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public static void insertRequest(int id, int idEvent) throws SystemException {

        String query = "INSERT INTO `Requests` (`user`, `event`, `status`) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, idEvent);
            preparedStatement.setString(3, "pending");

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public static void subscriptionVipUser(String username) throws SystemException {
        String query = "UPDATE `Users` SET `VIP` = '1', creationDateVIP=CURRENT_DATE WHERE (`username` = ?)";
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public static void insertCredentials(CredentialsModel credentialsModel) throws SystemException {

        String query = "INSERT INTO `Credentials` (`Username`, `Password`, `Type`) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = MySqlConnection.connect().prepareStatement(query)) {
            preparedStatement.setString(1, credentialsModel.getUsername());
            preparedStatement.setString(2, credentialsModel.getPassword());
            preparedStatement.setString(3, credentialsModel.getType());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
