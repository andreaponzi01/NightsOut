package nightsout.utils.dao;

import nightsout.model.ClubOwnerModel;
import nightsout.utils.db.CRUD;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClubOwnerDAO {

    private ClubOwnerDAO() {
        //ignored
    }

    public static ClubOwnerModel getClubOwnerByUsername(String username) throws SQLException {

        Statement stm = null;
        ClubOwnerModel clubOwnerModel = null ;

        try {
            stm = MySqlConnection.tryConnect();
            ResultSet rs = Query.searchClubOwnerByUsername(stm, username);
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
            PreparedStatement ps = MySqlConnection.insertClubOwner();

            ps.setString(1,clubOwnerModel.getUsername());
            ps.setString(2, clubOwnerModel.getEmail());
            ps.setString(3 , clubOwnerModel.getCity());
            ps.setString(4, clubOwnerModel.getAddress());
            ps.setString(5, clubOwnerModel.getClubName());
            ps.setInt(6, clubOwnerModel.getDiscountVIP());
            // Manca la set dell'immagine del profilo

            ps.executeUpdate();

        } catch (/*MysqlConnectionFailed |*/ SQLException /*| FileNotFoundException*/ m) {
           // ErrorHandler.getInstance().handleException(m);
            m.printStackTrace();
        }
    }
}
