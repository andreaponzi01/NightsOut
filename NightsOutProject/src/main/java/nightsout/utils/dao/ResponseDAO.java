package nightsout.utils.dao;

import nightsout.model.ResponseModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;

public class ResponseDAO {

    Query query = new Query();

    public void createResponse(ResponseModel responseModel) throws SystemException {
            query.insertResponse(responseModel);
    }
    public ResponseModel getResponseByIdReview(int idReview) throws SystemException {
            return query.searchResponseByIdReview(idReview);
    }
}
