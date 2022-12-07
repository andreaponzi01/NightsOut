package nightsout.utils.dao;

import nightsout.model.ResponseModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;

public class ResponseDAO {

    private ResponseDAO() {
        //ignore
    }

    public static void createResponse(ResponseModel responseModel) throws SystemException {
            Query.insertResponse(responseModel);
    }

    public static ResponseModel getResponseByIdReview(int idReview) throws SystemException {
            return Query.searchResponseByIdReview(idReview);
    }

}
