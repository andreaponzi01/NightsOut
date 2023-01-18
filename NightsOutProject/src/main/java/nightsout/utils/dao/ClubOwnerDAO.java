package nightsout.utils.dao;

import nightsout.model.ClubOwnerModel;
import nightsout.model.CredentialsModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;

import java.util.List;

public class ClubOwnerDAO {

    Query query = new Query();
    public ClubOwnerModel getClubOwnerByUsername(String username) throws SystemException {
            return query.searchClubOwnerByUsername(username);
    }
    public void insertClubOwner(CredentialsModel credentialsModel, ClubOwnerModel clubOwnerModel) throws SystemException {
            query.insertCredentials(credentialsModel);
            query.insertClubOwner(clubOwnerModel);
    }
    public List<ClubOwnerModel> getClubOwnersByUsername(String input) throws SystemException {
        return query.searchClubOwnersByUsername(input);
    }
    public ClubOwnerModel getClubOwnerById(int idClubOwner) throws SystemException {
        return query.searchClubOwnerById(idClubOwner);
    }
    public ClubOwnerModel getClubAddressByIdEvent(int idEvent) throws SystemException {
        return query.searchClubAddressByEventId(idEvent);
    }
}
