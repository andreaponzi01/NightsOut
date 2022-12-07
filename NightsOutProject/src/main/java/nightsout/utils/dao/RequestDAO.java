package nightsout.utils.dao;

import nightsout.model.EventModel;
import nightsout.model.RequestModel;
import nightsout.model.UserModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;

import java.util.List;

public class RequestDAO {

    private RequestDAO() {
        //ignored
    }

    public static void createRequest(UserModel userModel, EventModel eventModel) throws SystemException {
            Query.insertRequest(userModel.getId(), eventModel.getIdEvent());
    }

    public static RequestModel checkRequestStatus(UserModel userModel, EventModel eventModel) throws SystemException {
            return Query.searchRequest(userModel.getId(), eventModel.getIdEvent());
    }

    public static List<RequestModel> getRequestsByIdClubOwner(int idClubOwner) throws SystemException {
        return Query.searchRequestsByIdClubOwner(idClubOwner);
    }

    public static List<RequestModel> getRifiutedRequestsByIdUser(int idUser) throws SystemException {
        return Query.searchRifiutedRequestsByIdUser(idUser);
    }

    public static List<RequestModel> getPendingRequestsByIdUser(int idUser) throws SystemException {
        return Query.searchPendingRequestsByIdUser(idUser);
    }

    public static void updateRequestStatus(int idRequest,String status) throws SystemException {
            Query.updateRequest(idRequest,status);
    }
}
