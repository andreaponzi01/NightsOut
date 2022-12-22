package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.EventModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class SearchAppController {

    private SearchAppController() {}

    public static List<UserBean1> searchUsersByUsername(String input) throws SystemException {

        List<UserModel> list = null;
        List<UserBean1> listBean = null;
        list = UserDAO.getUsersByUsername(input);
        listBean = new ArrayList<>();
        if (list != null) {
            for (UserModel um : list) {
                UserBean1 bean = new UserBean1(um);
                listBean.add(bean);
            }
        }
        return listBean;
    }

    public static List<EventBean1> searchEventsByName(String input) throws SystemException {

        List<EventModel> list = null;
        List<EventBean1> listBean = null;
        list = EventDAO.getEventsByName(input);
        listBean = new ArrayList<>();

        if (list != null) {
            for (EventModel eventModel : list) {
                EventBean1 bean = new EventBean1(eventModel);
                listBean.add(bean);
            }
        }
        return listBean;
    }

    public static List<ClubOwnerBean1> searchClubOwnersByUsername(String input) throws SystemException {

        List<ClubOwnerModel> list = ClubOwnerDAO.getClubOwnersByUsername(input);
        List<ClubOwnerBean1> listBean = new ArrayList<>();

        if (list != null) {
            for (ClubOwnerModel clubOwnerModel : list) {
                ClubOwnerBean1 bean = new ClubOwnerBean1(clubOwnerModel);
                listBean.add(bean);
            }
        }
        return listBean;
    }
}
