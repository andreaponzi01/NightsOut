package nightsout.utils.dao;

import nightsout.model.ClubOwnerModel;
import nightsout.model.CredentialsModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;

import java.util.List;

public class ClubOwnerDAO {

    private ClubOwnerDAO() {
        //ignored
    }

    public static ClubOwnerModel getClubOwnerByUsername(String username) throws SystemException {
            return Query.searchClubOwnerByUsername(username);
    }
    public static void insertClubOwner(CredentialsModel credentialsModel, ClubOwnerModel clubOwnerModel) throws SystemException {
            Query.insertCredentials(credentialsModel);
            Query.insertClubOwner(clubOwnerModel);
    }
    public static List<ClubOwnerModel> getClubOwnersByUsername(String input) throws SystemException {
        return Query.searchClubOwnersByUsername(input);
    }
    public static ClubOwnerModel getClubOwnerById(int idClubOwner) throws SystemException {
        return Query.searchClubOwnerById(idClubOwner);
    }
    public static ClubOwnerModel getClubAddressByIdEvent(int idEvent) throws SystemException {
        return Query.searchClubAddressByEventId(idEvent);
    }
}
