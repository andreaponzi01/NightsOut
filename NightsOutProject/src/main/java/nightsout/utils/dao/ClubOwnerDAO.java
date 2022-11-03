package nightsout.utils.dao;

import nightsout.model.ClubOwnerModel;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClubOwnerDAO {

    public static ClubOwnerModel getClubOwnerByUsername(String username) throws Exception {

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
}
