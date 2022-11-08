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
        ArrayList<UserModel> list = null;
        ArrayList<UserBean> listBean = null;
        try {
            list = UserDAO.getUsersByUsername(input);
            listBean = new ArrayList<>();

            for(UserModel um : list){
                UserBean bean = new UserBean(um);
                listBean.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBean;
    }

    public static ArrayList<EventBean> searchEventsByName(String input) {
        ArrayList<EventModel> list = null;
        ArrayList<EventBean> listBean = null;

        try {
            list = EventDAO.getEventByName(input);
            listBean = new ArrayList<EventBean>();

            for(EventModel eventModel : list){
                EventBean bean = new EventBean(eventModel);
                listBean.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBean;
    }
}
