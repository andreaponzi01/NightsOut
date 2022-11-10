package nightsout.utils.dao;

import nightsout.model.ClubOwnerModel;
import nightsout.utils.db.CRUD;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;

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

    public static ClubOwnerModel getClubOwnerByUsername(String username) throws SQLException {

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

        try {
            stm= MySqlConnection.tryConnect();
            // Inserimento credenziali (tabella Credentials)
            CRUD.insertCredentials(clubOwnerModel.getUsername(), clubOwnerModel.getPassword(), "ClubOwner", stm);

            // Inserimento dati personali (tabella ClubOwners)
            PreparedStatement preparedStatement = MySqlConnection.insertClubOwner();

            preparedStatement.setString(1,clubOwnerModel.getUsername());
            preparedStatement.setString(2, clubOwnerModel.getEmail());
            preparedStatement.setString(3 , clubOwnerModel.getCity());
            preparedStatement.setString(4, clubOwnerModel.getAddress());
            preparedStatement.setString(5, clubOwnerModel.getClubName());
            preparedStatement.setInt(6, clubOwnerModel.getDiscountVIP());
            // Manca la set dell'immagine del profilo

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (/*MysqlConnectionFailed |*/ SQLException /*| FileNotFoundException*/ m) {
           // ErrorHandler.getInstance().handleException(m);
            m.printStackTrace();
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
            rs.next();
            do {
                clubOwnerModel = new ClubOwnerModel(rs.getString(2));
                clubOwnerModel.setClubName(rs.getString(7));
                clubOwnerModel.setEmail(rs.getString(4));
                clubOwnerModel.setCity(rs.getString(5));
                clubOwnerModel.setAddress(rs.getString(6));
                clubOwnerModel.setId(rs.getInt(1));
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
}
