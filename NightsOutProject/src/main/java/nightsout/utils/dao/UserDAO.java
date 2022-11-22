package nightsout.utils.dao;

import nightsout.control.guicontroller.MyNotification;
import nightsout.model.UserModel;
import nightsout.utils.db.CRUD;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.DBConnectionFailedException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private UserDAO() {
        //ignored
    }

    public static UserModel getUserByUsername(String username) {

        PreparedStatement preparedStatement = null;
        UserModel userModel = null ;

        try {
            preparedStatement = Query.searchUserByUsername(preparedStatement, username);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();


            userModel = new UserModel(rs.getString(2));

            userModel.setName(rs.getString(6));
            userModel.setSurname(rs.getString(8));
            userModel.setGender(rs.getString(7));
            userModel.setEmail(rs.getString(4));
            userModel.setId(rs.getInt(1));
            userModel.setVip(rs.getBoolean(9));
            userModel.setCreationDateVip((rs.getDate(10) == null) ? null : rs.getDate(10).toLocalDate());
            userModel.setType("Free");

            /* Capire come funziona la gestione delle immagini tramite file


                InputStream in = (rs.getBinaryStream(3));
                String filePath = username + "pic" + ".png";
                File file = new File(filePath);
                ImageConverter.copyInputStreamToFile(in, file);
                userModel.setProfileImg(file);
            */

            preparedStatement.close();
            return userModel;

        } catch (/*MysqlConnectionFailed |*/ SQLException e){
            // ErrorHandler.getInstance().handleException(e);
            e.printStackTrace();
        }
        return userModel;
    }

    public static void insertUser(UserModel userModel) {
        Statement stm = null;
        PreparedStatement preparedStatement = null;

        try {
            stm= MySqlConnection.tryConnect();
            // Inserimento credenziali (tabella Credentials)
            CRUD.insertCredentials(userModel.getUsername(), userModel.getPassword(), "Free", stm);

            preparedStatement = Query.insertUser(userModel);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (DBConnectionFailedException e) {
            // ErrorHandler.getInstance().handleException(m);
            MyNotification.createNotification(e);
        } catch (SQLException /*| FileNotFoundException*/ m) {
            //
        }
    }


    public static void subscriptionVip(UserModel userModel) throws SQLException {
        Statement stm= null;
        PreparedStatement preparedStatement = null;
        try{

            // Inserimento credenziali (tabella Credentials)
            stm = MySqlConnection.tryConnect();
            CRUD.subscriptionVipUser(userModel.getUsername(), stm);
            preparedStatement = Query.searchUserByUsername(preparedStatement, userModel.getUsername());
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            userModel.setVip(rs.getBoolean(9));
            userModel.setCreationDateVip(rs.getDate(10).toLocalDate());
            preparedStatement.close();

        }catch (/*MysqlConnectionFailed |*/ SQLException /*| FileNotFoundException*/ m) {
            // ErrorHandler.getInstance().handleException(m);
            m.printStackTrace();
        } catch (DBConnectionFailedException e) {
            MyNotification.createNotification(e);
         }
    }

    public static List<UserModel> getUsersByUsername(String username) throws SQLException {

        List<UserModel> list = null;
        PreparedStatement preparedStatement = null;
        UserModel userModel = null ;

        try {
            list = new ArrayList<>();
            preparedStatement = Query.searchUsersByUsername(username);
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }

            do {

                userModel = new UserModel(rs.getString(2));
                userModel.setName(rs.getString(6));
                userModel.setSurname(rs.getString(8));
                userModel.setGender(rs.getString(7));
                userModel.setEmail(rs.getString(4));
                userModel.setId(rs.getInt(1));
                userModel.setVip(rs.getBoolean(9));
                userModel.setCreationDateVip((rs.getDate(10) == null) ? null : rs.getDate(10).toLocalDate());

                list.add(userModel);

            } while(rs.next());

            preparedStatement.close();
            return list;

        } catch (/*MysqlConnectionFailed |*/ SQLException e){
            // ErrorHandler.getInstance().handleException(e);
        e.printStackTrace();
        }
        return list;
    }

    public static List<UserModel> getUsersByIdEvent(int idEvent) throws SQLException {

        List<UserModel> list = null;
        PreparedStatement preparedStatement = null;
        UserModel userModel = null ;

        try {
            list = new ArrayList<>();
            preparedStatement = Query.searchUsersByIdEvent(idEvent);
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }

            do {

                userModel = new UserModel(rs.getString(2));
                userModel.setName(rs.getString(6));
                userModel.setSurname(rs.getString(8));
                userModel.setGender(rs.getString(7));
                userModel.setEmail(rs.getString(4));
                userModel.setId(rs.getInt(1));
                userModel.setVip(rs.getBoolean(9));
                userModel.setCreationDateVip((rs.getDate(10) == null) ? null : rs.getDate(10).toLocalDate());

                list.add(userModel);

            } while(rs.next());

            preparedStatement.close();
            return list;

        } catch (/*MysqlConnectionFailed |*/ SQLException e){
            // ErrorHandler.getInstance().handleException(e);
            e.printStackTrace();
        }
        return list;
    }

    public static UserModel getUserByidUser(int idUser) throws SQLException {

        PreparedStatement preparedStatement = null;
        UserModel userModel = null ;

        try {
            preparedStatement = Query.searchUsersByIdUser(idUser);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();


            userModel = new UserModel(rs.getString(2));

            userModel.setName(rs.getString(6));
            userModel.setSurname(rs.getString(8));
            userModel.setGender(rs.getString(7));
            userModel.setEmail(rs.getString(4));
            userModel.setId(rs.getInt(1));
            userModel.setVip(rs.getBoolean(9));
            userModel.setCreationDateVip((rs.getDate(10) == null) ? null : rs.getDate(10).toLocalDate());

            /* Capire come funziona la gestione delle immagini tramite file


                InputStream in = (rs.getBinaryStream(3));
                String filePath = username + "pic" + ".png";
                File file = new File(filePath);
                ImageConverter.copyInputStreamToFile(in, file);
                userModel.setProfileImg(file);
            */

            preparedStatement.close();
            return userModel;

        } catch (/*MysqlConnectionFailed |*/ SQLException e){
            // ErrorHandler.getInstance().handleException(e);
            e.printStackTrace();
        }
        return userModel;
    }
}
