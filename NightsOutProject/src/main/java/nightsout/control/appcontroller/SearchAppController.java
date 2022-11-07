package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.dao.UserDAO;

import java.util.ArrayList;

public class SearchAppController {

    private SearchAppController() {}

    public static ArrayList<UserBean> searchUserByUsername(String input) {
        try {
            ArrayList<UserModel> list = UserDAO.getUsersByUsername(input);
            ArrayList<UserBean> listBean = new ArrayList<UserBean>();

            for(UserModel um : list){
                UserBean bean = new UserBean(um);
                listBean.add(bean);
            }

            return listBean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<EventBean> searchEventsByName(String input) {
        try {
            ArrayList<EventModel> list = EventDAO.getEventByName(input);
            ArrayList<EventBean> listBean = new ArrayList<EventBean>();

            for(EventModel eventModel : list){
                EventBean bean = new EventBean(eventModel);
                listBean.add(bean);
            }

            return listBean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
