package nightsout.utils.dao;

import nightsout.model.UserModel;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    private UserDAO() {
        //ignored
    }

    public static UserModel getUserByUsername(String username) throws Exception {

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

}
