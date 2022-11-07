package nightsout.utils.dao;

import nightsout.model.UserModel;
import nightsout.utils.db.CRUD;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

    private UserDAO() {
        //ignored
    }

    public static UserModel getUserByUsername(String username) throws SQLException {

        Statement stm = null;
        UserModel userModel = null ;

        try {
            stm = MySqlConnection.tryConnect();
            ResultSet rs = Query.searchUserByUsername(stm, username);
            rs.next();


            userModel = new UserModel(rs.getString(2));

            userModel.setName(rs.getString(6));
            userModel.setSurname(rs.getString(8));
            userModel.setGender(rs.getString(7));
            userModel.setEmail(rs.getString(4));
            userModel.setId(rs.getInt(1));
            userModel.setVip(rs.getBoolean(9));

            /* Capire come funziona la gestione delle immagini tramite file


                InputStream in = (rs.getBinaryStream(3));
                String filePath = username + "pic" + ".png";
                File file = new File(filePath);
                ImageConverter.copyInputStreamToFile(in, file);
                userModel.setProfileImg(file);
            */

            return userModel;

        } catch (/*MysqlConnectionFailed |*/ SQLException e){
           // ErrorHandler.getInstance().handleException(e);
            e.printStackTrace();
        }
        return userModel;
    }

    public static void insertUser(UserModel userModel) {
        Statement stm= null;
        try{
            stm=MySqlConnection.tryConnect();

            // Inserimento credenziali (tabella Credentials)
            CRUD.insertCredentials(userModel.getUsername(), userModel.getPassword(), "Free", stm);
            PreparedStatement ps = MySqlConnection.insertUser();
            // Inserimento dati personali (tabella ClubOwners)
            ps.setString(1,userModel.getUsername());
            ps.setString(2, userModel.getEmail());
            ps.setString(3 , userModel.getName());
            ps.setString(4, userModel.getSurname());
            ps.setDate(5, Date.valueOf(userModel.getBirthday()));
            ps.setString(6, userModel.getGender());

            // Manca la set dell'immagine del profilo

            ps.executeUpdate();

        }catch (/*MysqlConnectionFailed |*/ SQLException /*| FileNotFoundException*/ m) {
            // ErrorHandler.getInstance().handleException(m);
            m.printStackTrace();
        }
    }

    public static void subscriptionVip(UserModel userModel) {
        Statement stm= null;
        try{
            stm=MySqlConnection.tryConnect();

            // Inserimento credenziali (tabella Credentials)
            CRUD.subscriptionVipUser(userModel.getUsername(), stm);

            ResultSet rs = Query.searchUserByUsername(stm, userModel.getUsername());
            rs.next();

            userModel.setVip(rs.getBoolean(9));
            userModel.setCreationDateVip(rs.getDate(10).toLocalDate());


        }catch (/*MysqlConnectionFailed |*/ SQLException /*| FileNotFoundException*/ m) {
            // ErrorHandler.getInstance().handleException(m);
            m.printStackTrace();
        }
    }

    public static ArrayList<UserModel> getUsersByUsername(String username) throws SQLException {

        ArrayList<UserModel> list = null;
        Statement stm = null;
        UserModel userModel = null ;

        try {
            list = new ArrayList<UserModel>();
            stm = MySqlConnection.tryConnect();

            ResultSet rs = Query.searchUsersByUsername(stm, username);
            rs.next();

            do {
                userModel = new UserModel(rs.getString(2));
                userModel.setName(rs.getString(6));
                userModel.setSurname(rs.getString(8));
                userModel.setGender(rs.getString(7));
                userModel.setEmail(rs.getString(4));
                userModel.setId(rs.getInt(1));
                userModel.setVip(rs.getBoolean(9));


                list.add(userModel);

            } while(rs.next());

            return list;

        } catch (/*MysqlConnectionFailed |*/ SQLException e){
            // ErrorHandler.getInstance().handleException(e);
            e.printStackTrace();
        }
        return list;
    }
}
