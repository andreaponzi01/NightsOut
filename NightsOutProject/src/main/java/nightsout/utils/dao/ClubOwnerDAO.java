package nightsout.utils.dao;

import nightsout.control.guicontroller.MyNotification;
import nightsout.model.ClubOwnerModel;
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

public class ClubOwnerDAO {

    private ClubOwnerDAO() {
        //ignored
    }

    public static ClubOwnerModel getClubOwnerByUsername(String username) {

        PreparedStatement preparedStatement = null;
        ClubOwnerModel clubOwnerModel = null ;

        try {
            preparedStatement = Query.searchClubOwnerByUsername(username);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            // username
            clubOwnerModel = new ClubOwnerModel(rs.getString(2));
            clubOwnerModel.setClubName(rs.getString(7));
            clubOwnerModel.setEmail(rs.getString(4));
            clubOwnerModel.setCity(rs.getString(5));
            clubOwnerModel.setAddress(rs.getString(6));
            clubOwnerModel.setId(rs.getInt(1));
            clubOwnerModel.setDiscountVIP(rs.getInt(8));
            clubOwnerModel.setType("Club Owner");

            /* Capire come funziona la gestione delle immagini tramite file


                InputStream in = (rs.getBinaryStream(3));
                String filePath = username + "pic" + ".png";
                File file = new File(filePath);
                ImageConverter.copyInputStreamToFile(in, file);
                clubOwnerModel.setProfileImg(file);
            */

            preparedStatement.close();
            return clubOwnerModel;

        } catch (/*MysqlConnectionFailed |*/ SQLException e){
            // ErrorHandler.getInstance().handleException(e);
            e.printStackTrace();
        }
        return clubOwnerModel;
    }

    public static void insertClubOwner(ClubOwnerModel clubOwnerModel) {
        Statement stm = null;
        PreparedStatement preparedStatement = null;

        try {
            stm= MySqlConnection.tryConnect();
            // Inserimento credenziali (tabella Credentials)
            CRUD.insertCredentials(clubOwnerModel.getUsername(), clubOwnerModel.getPassword(), "ClubOwner", stm);

            preparedStatement = Query.insertClubOwner(clubOwnerModel);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (/*MysqlConnectionFailed |*/ SQLException /*| FileNotFoundException*/ m) {
            // ErrorHandler.getInstance().handleException(m);
            m.printStackTrace();
        } catch (DBConnectionFailedException e) {
            MyNotification.createNotification(e);
        }
    }

    public static List<ClubOwnerModel> getClubOwnersByUsername(String input) {
        List<ClubOwnerModel> list = null;
        PreparedStatement preparedStatement = null;
        ClubOwnerModel clubOwnerModel = null ;

        try {
            list = new ArrayList<>();
            preparedStatement = Query.searchClubOwnersByUsername(input);
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }
            //rs.next();
            do {
                clubOwnerModel = new ClubOwnerModel(rs.getString(2));
                clubOwnerModel.setClubName(rs.getString(7));
                clubOwnerModel.setEmail(rs.getString(4));
                clubOwnerModel.setCity(rs.getString(5));
                clubOwnerModel.setAddress(rs.getString(6));
                clubOwnerModel.setId(rs.getInt(1));
                clubOwnerModel.setDiscountVIP(rs.getInt(8));
                list.add(clubOwnerModel);
            } while(rs.next());

            preparedStatement.close();
            return list;

        } catch (/*MysqlConnectionFailed |*/ SQLException e){
            // ErrorHandler.getInstance().handleException(e);
            e.printStackTrace();

        }
        return list;
    }

    public static ClubOwnerModel getClubOwnerById(int idClubOwner) {

        PreparedStatement preparedStatement = null;
        ClubOwnerModel clubOwnerModel = null ;

        try {
            preparedStatement = Query.searchClubOwnerById(idClubOwner);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            // username
            clubOwnerModel = new ClubOwnerModel(rs.getString(2));
            clubOwnerModel.setClubName(rs.getString(7));
            clubOwnerModel.setEmail(rs.getString(4));
            clubOwnerModel.setCity(rs.getString(5));
            clubOwnerModel.setAddress(rs.getString(6));
            clubOwnerModel.setId(rs.getInt(1));
            clubOwnerModel.setDiscountVIP(rs.getInt(8));

            /* Capire come funziona la gestione delle immagini tramite file


                InputStream in = (rs.getBinaryStream(3));
                String filePath = username + "pic" + ".png";
                File file = new File(filePath);
                ImageConverter.copyInputStreamToFile(in, file);
                clubOwnerModel.setProfileImg(file);
            */

            preparedStatement.close();
            return clubOwnerModel;

        } catch (/*MysqlConnectionFailed |*/ SQLException e){
            // ErrorHandler.getInstance().handleException(e);
            e.printStackTrace();
        }
        return clubOwnerModel;
    }


}
