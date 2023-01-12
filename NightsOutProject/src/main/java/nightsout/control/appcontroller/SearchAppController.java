package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.EventModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class SearchAppController {

    private SearchAppController() {
        //ignored
    }

    public static void search(Observer observer, String input) throws SystemException {

        GenericBeanList list = new GenericBeanList(observer);

        list.addEventsToList(SearchAppController.searchEventsByName(input));
        list.addUsersToList(SearchAppController.searchUsersByUsername(input));
        list.addClubOwnersToList(SearchAppController.searchClubOwnersByUsername(input));

    }

    public static List<UserBean> searchUsersByUsername(String input) throws SystemException {

        List<UserModel> list = null;
        List<UserBean> listBean = null;
        list = UserDAO.getUsersByUsername(input);
        listBean = new ArrayList<>();
        if (list != null) {
            for (UserModel um : list) {
                UserBean bean = new UserBean(um);
                listBean.add(bean);
            }
        }
        return listBean;
    }
    public static List<EventBean> searchEventsByName(String input) throws SystemException {

        List<EventModel> list = null;
        List<EventBean> listBean = null;
        list = EventDAO.getEventsByName(input);
        listBean = new ArrayList<>();
        if (list != null) {
            for (EventModel eventModel : list) {
                EventBean bean = new EventBean(eventModel);
                listBean.add(bean);
            }
        }
        return listBean;
    }
    public static List<ClubOwnerBean> searchClubOwnersByUsername(String input) throws SystemException {

        List<ClubOwnerModel> list = ClubOwnerDAO.getClubOwnersByUsername(input);
        List<ClubOwnerBean> listBean = new ArrayList<>();
        if (list != null) {
            for (ClubOwnerModel clubOwnerModel : list) {
                ClubOwnerBean bean = new ClubOwnerBean(clubOwnerModel);
                listBean.add(bean);
            }
        }
        return listBean;
    }
}
