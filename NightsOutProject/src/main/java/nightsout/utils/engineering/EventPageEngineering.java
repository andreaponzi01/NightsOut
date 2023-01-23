package nightsout.utils.engineering;

import nightsout.model.ClubOwnerModel;
import nightsout.model.EventModel;
import nightsout.model.RequestModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.RequestDAO;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class EventPageEngineering {

    public String getClubAddress(int idEvent) throws SystemException {

        ClubOwnerDAO clubOwnerDAO = new ClubOwnerDAO();
        ClubOwnerModel clubOwnerModel = clubOwnerDAO.getClubAddressByIdEvent(idEvent);
        return (clubOwnerModel.getAddress() + ", " + clubOwnerModel.getCity());
    }

    public ClubOwnerBean getClubOwner(int idClubOwner) throws SystemException {

        ClubOwnerDAO clubOwnerDAO = new ClubOwnerDAO();
        ClubOwnerModel clubOwnerModel = clubOwnerDAO.getClubOwnerById(idClubOwner);
        return new ClubOwnerBean1(clubOwnerModel);
    }

    public RequestBean checkRequestStatus(UserBean userBean, EventBean eventBean) throws SystemException {

        UserModel userModel = new UserModel(userBean);
        EventModel eventModel = new EventModel(eventBean);
        RequestDAO requestDAO = new RequestDAO();
        RequestModel requestModel = requestDAO.checkRequestStatus(userModel, eventModel);
        if(requestModel==null)
            return null;
        return (new RequestBean(requestModel));
    }

    public void deleteEvent(EventBean eventBean) throws SystemException {
        try {
            Query query = new Query();
            query.deleteEventById(eventBean.getIdEvent());
            FileUtils.delete(new File("eventImgs/" + eventBean.getName() + "pic.png"));
        } catch (IOException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }
}
