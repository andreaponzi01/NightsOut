package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.dao.UserDAO;

import java.util.ArrayList;
import java.util.List;

public class SearchAppController {

    private SearchAppController() {}

    public static List<UserBean> searchUserByUsername(String input) {
        List<UserModel> list = null;
        List<UserBean> listBean = null;
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

    public static List<EventBean> searchEventsByName(String input) {
        List<EventModel> list = null;
        List<EventBean> listBean = null;

        try {
            list = EventDAO.getEventByName(input);
            listBean = new ArrayList<>();

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
