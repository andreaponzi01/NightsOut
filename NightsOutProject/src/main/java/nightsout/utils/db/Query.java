package nightsout.utils.db;

import nightsout.model.*;
import nightsout.utils.engineering.ConverterToFileEngineering;
import nightsout.utils.exception.myexception.SystemException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query {

    private static final String PATHPROFILEIMGS = "profileImgs/";
    private static final String PATHEVENTSIMGS = "eventImgs/";
    ConverterToFileEngineering converterToFile = new ConverterToFileEngineering();

    public boolean searchUserInLogged(CredentialsModel credentialsModel) throws SystemException {
        String query = "SELECT * FROM Credentials WHERE password = ? and username = ? and type = ?";

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1, credentialsModel.getPassword());
            preparedStatement.setString(2, credentialsModel.getUsername());
            preparedStatement.setString(3, credentialsModel.getType());

            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }


    }

    public UserModel searchUserByUsername(String username) throws SystemException {
        String query = "SELECT * FROM Users where username = ?;";
        UserModel userModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
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
            String filePath = PATHPROFILEIMGS + username + "pic" + ".png";
            File file = new File(filePath);
            converterToFile.fromInputStreamToFile(inputStream, file);
            userModel.setProfileImg(file);

            return userModel;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public ClubOwnerModel searchClubOwnerByUsername(String username) throws SystemException {
        String query = "SELECT * FROM ClubOwners where username = ?;";
        ClubOwnerModel clubOwnerModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            // username
            clubOwnerModel = new ClubOwnerModel();
            clubOwnerModel.setAddress(rs.getString(6));
            clubOwnerModel.setId(rs.getInt(1));
            clubOwnerModel.setEmail(rs.getString(4));
            clubOwnerModel.setUsername(rs.getString(2));
            clubOwnerModel.setCity(rs.getString(5));
            clubOwnerModel.setDiscountVIP(rs.getInt(8));
            clubOwnerModel.setClubName(rs.getString(7));

            InputStream inputStream = (rs.getBinaryStream(3));
            String filePath = PATHPROFILEIMGS + username + "pic" + ".png";
            File file = new File(filePath);
            converterToFile.fromInputStreamToFile(inputStream, file);
            clubOwnerModel.setProfileImg(file);

            return clubOwnerModel;

        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public List<UserModel> searchUsersByUsername(String username) throws SystemException {
        String query = "SELECT * FROM Users where username like ?;";
        List<UserModel> list = null;
        UserModel userModel;

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            list = new ArrayList<>();
            preparedStatement.setString(1, username + "%");
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }

            do {
                userModel = new UserModel();

                userModel.setGender(rs.getString(7));
                InputStream in = (rs.getBinaryStream(3));
                userModel.setUsername(rs.getString(2));
                userModel.setSurname(rs.getString(8));
                userModel.setCreationDateVip((rs.getDate(10) == null) ? null : rs.getDate(10).toLocalDate());
                userModel.setBirthday(rs.getDate(5).toLocalDate());
                userModel.setName(rs.getString(6));
                userModel.setEmail(rs.getString(4));
                userModel.setId(rs.getInt(1));

                String filePath = PATHPROFILEIMGS + userModel.getUsername() + "pic" + ".png";
                File file = new File(filePath);
                converterToFile.fromInputStreamToFile(in, file);
                userModel.setProfileImg(file);
                userModel.setVip(rs.getBoolean(9));
                list.add(userModel);

            } while(rs.next());

            return list;

        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public UserModel searchUsersByIdUser(int idUser) throws SystemException {
        String query = "SELECT * FROM Users where idUser = ?;";
        UserModel userModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {

            userModel = new UserModel();

            preparedStatement.setInt(1, idUser);
            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            userModel.setVip(rs.getBoolean(9));
            userModel.setBirthday(rs.getDate(5).toLocalDate());
            userModel.setEmail(rs.getString(4));
            userModel.setGender(rs.getString(7));
            userModel.setUsername(rs.getString(2));
            userModel.setName(rs.getString(6));
            userModel.setCreationDateVip((rs.getDate(10) == null) ? null : rs.getDate(10).toLocalDate());
            userModel.setSurname(rs.getString(8));

            InputStream inputStream = (rs.getBinaryStream(3));
            String filePath = PATHPROFILEIMGS + userModel.getUsername() + "pic" + ".png";
            File file = new File(filePath);
            converterToFile.fromInputStreamToFile(inputStream, file);
            userModel.setProfileImg(file);

            return userModel;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public List<ClubOwnerModel> searchClubOwnersByUsername(String username) throws SystemException {
        String query = "SELECT * FROM ClubOwners where username like ?;";
        List<ClubOwnerModel> list = null;
        ClubOwnerModel clubOwnerModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
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
                String filePath = PATHPROFILEIMGS + clubOwnerModel.getUsername() + "pic" + ".png";
                File file = new File(filePath);
                converterToFile.fromInputStreamToFile(inputStream, file);
                clubOwnerModel.setProfileImg(file);

                list.add(clubOwnerModel);
            } while(rs.next());

            return list;

        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public List<EventModel> searchEventsByName(String name) throws SystemException {
        String query = "SELECT * FROM Events where name like ?;";
        List<EventModel> list = null;
        EventModel eventModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            list = new ArrayList<>();
            preparedStatement.setString(1, name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }
            do {

                eventModel = new EventModel();
                eventModel.setTime(rs.getTime(10).toLocalTime());
                eventModel.setIdEvent(rs.getInt(1));
                eventModel.setName(rs.getString(5));
                InputStream inputStream = (rs.getBinaryStream(9));
                eventModel.setDescription(rs.getString(11));
                eventModel.setPrice(rs.getDouble(4));
                eventModel.setIdClubOwner(rs.getInt(2));
                eventModel.setEventDate(rs.getDate(6).toLocalDate());
                eventModel.setDuration(rs.getInt(7));

                String filePath = PATHEVENTSIMGS + eventModel.getName() + "pic" + ".png";
                File file = new File(filePath);
                converterToFile.fromInputStreamToFile(inputStream, file);

                eventModel.setImg(file);
                list.add(eventModel);

            } while(rs.next());

            return list;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public RequestModel searchRequest(int idUser, int idEvent) throws SystemException {

        String query = "SELECT * FROM Requests where user = ? and event = ?;";
        RequestModel requestModel = null;

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
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
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public List<RequestModel> searchRequestsByIdClubOwner(int idClubOwner) throws SystemException {

        List<RequestModel> list = null;
        RequestModel requestModel = null;
        String query = "SELECT R.* FROM Requests as R JOIN Events as E ON R.event = E.idEvent WHERE E.clubOwner = ? and R.status='pending';";

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
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
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }


    public List<RequestModel> searchRequestsByIdUser(int idUser) throws SystemException {

        List<RequestModel> list = null;
        RequestModel requestModel = null;
        String query = "SELECT * FROM Requests WHERE user = ?;";

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
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
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public ClubOwnerModel searchClubOwnerById(int idClubOwner) throws SystemException {
        String query = "SELECT * FROM ClubOwners where idClubOwner = ?;";

        ClubOwnerModel clubOwnerModel = null;

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idClubOwner);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            clubOwnerModel = new ClubOwnerModel();

            clubOwnerModel.setEmail(rs.getString(4));
            InputStream inputStream = (rs.getBinaryStream(3));
            clubOwnerModel.setId(rs.getInt(1));
            clubOwnerModel.setCity(rs.getString(5));
            clubOwnerModel.setClubName(rs.getString(7));
            clubOwnerModel.setAddress(rs.getString(6));
            clubOwnerModel.setUsername(rs.getString(2));
            clubOwnerModel.setDiscountVIP(rs.getInt(8));

            String filePath = PATHPROFILEIMGS + clubOwnerModel.getUsername() + "pic" + ".png";
            File file = new File(filePath);
            converterToFile.fromInputStreamToFile(inputStream, file);
            clubOwnerModel.setProfileImg(file);

            return clubOwnerModel;

        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public void insertClubOwner(ClubOwnerModel clubOwnerModel) throws SystemException {

        String query = "INSERT INTO ClubOwners (username, email, city, address, clubName, VIPdiscount, `profileImg` ) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1,clubOwnerModel.getUsername());
            preparedStatement.setString(2, clubOwnerModel.getEmail());
            preparedStatement.setString(3 , clubOwnerModel.getCity());
            preparedStatement.setString(4, clubOwnerModel.getAddress());
            preparedStatement.setString(5, clubOwnerModel.getClubName());
            preparedStatement.setInt(6, clubOwnerModel.getDiscountVIP());
            preparedStatement.setBlob(7, new FileInputStream(clubOwnerModel.getProfileImg()));

            preparedStatement.executeUpdate();

        } catch (SQLException | FileNotFoundException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public void insertEvent(EventModel eventModel) throws SystemException {

        String query = "INSERT INTO `Events` (`clubOwner`, `price`, `name`, `date`, `duration`, `time`, `description`, `img`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
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
            SystemException exception = new SystemException();
            
            exception.initCause(e);
            throw exception;
        }
    }


    public void insertUser(UserModel userModel) throws SystemException {

        String query = "INSERT INTO `Users`(`username`, `email`, `name`, `surname`, `birthday`, `gender`, `profileImg` ) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1,userModel.getUsername());
            preparedStatement.setString(2, userModel.getEmail());
            preparedStatement.setString(3 , userModel.getName());
            preparedStatement.setString(4, userModel.getSurname());
            preparedStatement.setDate(5, Date.valueOf(userModel.getBirthday()));
            preparedStatement.setString(6, userModel.getGender());
            preparedStatement.setBlob(7, new FileInputStream(userModel.getImg()));

            preparedStatement.executeUpdate();

        } catch (SQLException | FileNotFoundException e) {
            SystemException exception = new SystemException();
            
            exception.initCause(e);
            throw exception;
        }
    }

    public List<EventModel> searchNextEventsByIdUser(int idUser) throws SystemException {

        List<EventModel> list = null;
        String query = "SELECT E.* FROM Requests as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.user = U.idUser WHERE U.idUser = ? and R.status='accepted' and DATEDIFF(E.date, CURRENT_TIMESTAMP)>0 ORDER BY E.date;";
        list = new ArrayList<>();
        EventModel eventModel = null;

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {

            preparedStatement.setInt(1, idUser);

            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }


            do {
                eventModel = new EventModel();

                eventModel.setIdEvent(rs.getInt(1));
                eventModel.setName(rs.getString(5));
                eventModel.setIdClubOwner(rs.getInt(2));
                eventModel.setDescription(rs.getString(11));
                InputStream inputStream = (rs.getBinaryStream(9));
                String filePath = PATHEVENTSIMGS + eventModel.getName() + "pic" + ".png";
                File file = new File(filePath);
                eventModel.setDuration(rs.getInt(7));
                eventModel.setTime(rs.getTime(10).toLocalTime());
                eventModel.setPrice(rs.getDouble(4));
                eventModel.setEventDate(rs.getDate(6).toLocalDate());
                converterToFile.fromInputStreamToFile(inputStream, file);
                eventModel.setImg(file);
                list.add(eventModel);

            } while(rs.next());

            return list;

        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public List<EventModel> searchCreatedEventsByIdClubOwner(int idClubOwner) throws SystemException {

        List<EventModel> list = null;
        String query = "SELECT * FROM Events where clubOwner = ?;";
        list = new ArrayList<>();

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            EventModel eventModel = null;


            preparedStatement.setInt(1, idClubOwner);

            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }

            do {
                eventModel = new EventModel();
                eventModel.setName(rs.getString(5));
                InputStream inputStream = (rs.getBinaryStream(9));
                String filePath = PATHEVENTSIMGS + eventModel.getName() + "pic" + ".png";
                eventModel.setDuration(rs.getInt(7));
                File file = new File(filePath);
                eventModel.setEventDate(rs.getDate(6).toLocalDate());
                converterToFile.fromInputStreamToFile(inputStream, file);
                eventModel.setIdClubOwner(rs.getInt(2));
                eventModel.setTime(rs.getTime(10).toLocalTime());
                eventModel.setIdEvent(rs.getInt(1));
                eventModel.setPrice(rs.getDouble(4));
                eventModel.setDescription(rs.getString(11));
                eventModel.setImg(file);
                list.add(eventModel);

            } while(rs.next());

            return list;

        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }
    public List<UserModel> searchUsersByIdEvent(int idEvent) throws SystemException {


        String query = "SELECT U.* FROM Requests as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.user = U.idUser WHERE E.idEvent = ? and R.status = ?;"; //GIUSTA??
        List<UserModel> list = null;
        list = new ArrayList<>();

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(2, "accepted");
            UserModel userModel = null;
            preparedStatement.setInt(1, idEvent);
            ResultSet rs = preparedStatement.executeQuery();

            assert rs != null;
            if (!rs.next()) {
                return list;
            }

            do {

                userModel = new UserModel();
                userModel.setUsername(rs.getString(2));
                userModel.setCreationDateVip((rs.getDate(10) == null) ? null : rs.getDate(10).toLocalDate());
                InputStream in = (rs.getBinaryStream(3));
                String filePath = PATHPROFILEIMGS +userModel.getUsername()+"pic"+".png";
                File file = new File(filePath);
                converterToFile.fromInputStreamToFile(in, file);
                userModel.setProfileImg(file);
                userModel.setBirthday(rs.getDate(5).toLocalDate());
                userModel.setId(rs.getInt(1));
                userModel.setName(rs.getString(6));
                userModel.setGender(rs.getString(7));
                userModel.setVip(rs.getBoolean(9));
                userModel.setEmail(rs.getString(4));
                userModel.setSurname(rs.getString(8));

                list.add(userModel);

            } while(rs.next());

            return list;

        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public List<EventModel>  searchEndedEventsByIdUser(int idUser) throws SystemException {

        EventModel eventModel = null;

        String query = "SELECT E.* FROM Requests as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.user = U.idUser WHERE U.idUser = ? and R.status='accepted' and DATEDIFF(E.date, CURRENT_TIMESTAMP)<0 ;";
        List<EventModel> list = null;


        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {

            list = new ArrayList<>();
            preparedStatement.setInt(1, idUser);
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }


            do {
                eventModel = new EventModel();
                eventModel.setEventDate(rs.getDate(6).toLocalDate());
                InputStream inputStream = (rs.getBinaryStream(9));
                eventModel.setIdClubOwner(rs.getInt(2));
                eventModel.setDuration(rs.getInt(7));
                eventModel.setTime(rs.getTime(10).toLocalTime());
                eventModel.setPrice(rs.getDouble(4));
                eventModel.setName(rs.getString(5));
                String filePath = PATHEVENTSIMGS + eventModel.getName() + "pic" + ".png";
                File file = new File(filePath);
                eventModel.setIdEvent(rs.getInt(1));
                eventModel.setDescription(rs.getString(11));
                converterToFile.fromInputStreamToFile(inputStream, file);
                eventModel.setImg(file);

                list.add(eventModel);

            } while(rs.next());

            return list;

        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public void insertEventReview(ReviewModel reviewModel) throws SystemException {
        String query = "INSERT INTO Reviews (sender, reviewText, event) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1,reviewModel.getIdUser());
            preparedStatement.setString(2 , reviewModel.getComment());
            preparedStatement.setInt(3, reviewModel.getIdEvent());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public List<ReviewModel> searchReviewsByIdClubOwner(int idClubOwner) throws SystemException {
        String query = "SELECT R.* FROM Reviews as R JOIN Events as E ON R.event = E.idEvent JOIN ClubOwners as C ON E.clubOwner = C.idClubOwner WHERE C.idClubOwner = ? AND R.idReview NOT IN (SELECT Responses.review FROM Responses WHERE Responses.clubOwner = ?);";
        List<ReviewModel> list = null;


        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(2, idClubOwner);
            list = new ArrayList<>();
            preparedStatement.setInt(1, idClubOwner);
            ReviewModel reviewModel = null;

            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }


            do {
                reviewModel = new ReviewModel();
                reviewModel.setIdUser(rs.getInt(2));
                reviewModel.setComment(rs.getString(3));
                reviewModel.setIdReview(rs.getInt(1));
                reviewModel.setIdEvent(rs.getInt(4));

                list.add(reviewModel);

            } while(rs.next());

            return list;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public List<ReviewModel> searchAllReviewsByIdClubOwner(int idClubOwner) throws SystemException {

        String query = "SELECT R.* FROM Reviews as R JOIN Events as E ON R.event = E.idEvent JOIN ClubOwners as C ON E.clubOwner = C.idClubOwner WHERE C.idClubOwner = ?;";
        ReviewModel reviewModel = null;

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            List<ReviewModel> list = null;
            list = new ArrayList<>();
            preparedStatement.setInt(1, idClubOwner);

            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }


            do {
                reviewModel = new ReviewModel();
                reviewModel.setIdUser(rs.getInt(2));
                reviewModel.setIdReview(rs.getInt(1));
                reviewModel.setComment(rs.getString(3));
                reviewModel.setIdEvent(rs.getInt(4));

                list.add(reviewModel);

            } while(rs.next());

            return list;
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public void insertResponse(ResponseModel responseModel) throws SystemException {
        String query = "INSERT INTO Responses (clubOwner, review, responseText) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1,responseModel.getIdClubOwner());
            preparedStatement.setInt(2 , responseModel.getReview());
            preparedStatement.setString(3, responseModel.getResponse());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public EventModel searchEventByIdEvent(int idEvent) throws SystemException {
        String query = "SELECT * FROM Events where idEvent = ?;";
        EventModel eventModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idEvent);

            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            eventModel = new EventModel();

            eventModel.setName(rs.getString(5));
            eventModel.setIdClubOwner(rs.getInt(2));
            eventModel.setTime(rs.getTime(10).toLocalTime());
            InputStream inputStream = (rs.getBinaryStream(9));
            eventModel.setDuration(rs.getInt(7));
            String filePath = PATHEVENTSIMGS + eventModel.getName() + "pic" + ".png";
            eventModel.setIdEvent(rs.getInt(1));
            eventModel.setEventDate(rs.getDate(6).toLocalDate());
            File file = new File(filePath);
            eventModel.setPrice(rs.getDouble(4));
            eventModel.setDescription(rs.getString(11));
            converterToFile.fromInputStreamToFile(inputStream, file);
            eventModel.setImg(file);
            return eventModel;

        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public ResponseModel searchResponseByIdReview(int idReview) throws SystemException {

        String query = "SELECT * FROM Responses where review = ?;";
        ResponseModel responseModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
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
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public ReviewModel searchReviewByIdEventAndByIdUser(int idUser, int idEvent) throws SystemException {
        String query = "SELECT R.* FROM Reviews as R JOIN Events as E ON R.event = E.idEvent JOIN Users as U ON R.sender = U.idUser WHERE U.idUser = ? and E.idEvent= ?;";
        //DA FARE QUERY
        ReviewModel reviewModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
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
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public void deleteEventById(int idEvent) throws SystemException {
        String query = "DELETE FROM `Events` WHERE `idEvent` = ?";

        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, idEvent);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public ClubOwnerModel searchClubAddressByEventId(int idEvent) throws SystemException {
        String query = "SELECT username, address, city FROM ClubOwners JOIN Events WHERE clubOwner = idClubOwner AND idEvent = ?;";
        ClubOwnerModel clubOwnerModel = null;
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
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
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public boolean checkUsernameAlreadyTaken(String username) throws SystemException {

        String query = "SELECT username FROM Credentials WHERE username = ?";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)){
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public void updateRequest(int id, String status) throws SystemException {

        String query = "UPDATE `Requests` SET `status` = ? WHERE `idRequest` = ?";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public void insertRequest(int id, int idEvent) throws SystemException {

        String query = "INSERT INTO `Requests` (`user`, `event`, `status`) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, idEvent);
            preparedStatement.setString(3, "pending");

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public void subscriptionVipUser(String username) throws SystemException {
        String query = "UPDATE `Users` SET `VIP` = '1', creationDateVIP=CURRENT_DATE WHERE (`username` = ?)";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

    public void insertCredentials(CredentialsModel credentialsModel) throws SystemException {

        String query = "INSERT INTO `Credentials` (`Username`, `Password`, `Type`) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = MySqlConnection.getInstance().connect().prepareStatement(query)) {
            preparedStatement.setString(1, credentialsModel.getUsername());
            preparedStatement.setString(2, credentialsModel.getPassword());
            preparedStatement.setString(3, credentialsModel.getType());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }
}
