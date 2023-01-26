package nightsout.utils.engineering;

import nightsout.model.UserModel;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class EventParticipantsEngineering {

    public void eventParticipants(Observer observer, IdBean idBean) throws SystemException {

        GenericBeanList list= new GenericBeanList(observer);
        list.addUsersToList(searchUsersByIdEvent(idBean.getId()));
    }

    private List<UserBean> searchUsersByIdEvent(int idEvent) throws SystemException {

        UserDAO userDAO = new UserDAO();
        List<UserModel> list = userDAO.getUsersByIdEvent(idEvent);
        List<UserBean> listBean = new ArrayList<>();
        for(UserModel um : list){
            UserBean bean = new UserBean(um);
            listBean.add(bean);
        }
        return listBean;
    }
}
