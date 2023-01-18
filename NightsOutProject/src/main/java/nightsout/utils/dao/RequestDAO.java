package nightsout.utils.dao;

import nightsout.model.EventModel;
import nightsout.model.RequestModel;
import nightsout.model.UserModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;

import java.util.List;

public class RequestDAO {

    Query query = new Query();
    public void createRequest(UserModel userModel, EventModel eventModel) throws SystemException {
            query.insertRequest(userModel.getId(), eventModel.getIdEvent());
    }
    public RequestModel checkRequestStatus(UserModel userModel, EventModel eventModel) throws SystemException {
            return query.searchRequest(userModel.getId(), eventModel.getIdEvent());
    }
    public List<RequestModel> getRequestsByIdClubOwner(int idClubOwner) throws SystemException {
        return query.searchRequestsByIdClubOwner(idClubOwner);
    }
    public List<RequestModel> getRequestsByIdUser(int idUser) throws SystemException {
        return query.searchRequestsByIdUser(idUser);
    }
    public void updateRequestStatus(int idRequest,String status) throws SystemException {
            query.updateRequest(idRequest,status);
    }
}
