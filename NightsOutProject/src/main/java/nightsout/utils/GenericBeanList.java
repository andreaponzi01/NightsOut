package nightsout.utils;

import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.GenericBean;
import nightsout.utils.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

//ConcreteSubject
public class GenericBeanList extends Subject {

    private List<GenericBean> beans;

    public GenericBeanList(Observer observer) {
        super(observer);
        beans = new ArrayList<>();
    }

    public void addUsersToList(ArrayList<UserBean> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (UserBean userBean : listBean) {
                beans.add(userBean);
                notify(userBean);
            }
        }
    }

    public void addEventsToList(ArrayList<EventBean> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (EventBean eventBean : listBean) {
                beans.add(eventBean);
                notify(eventBean);
            }
        }
    }

}
