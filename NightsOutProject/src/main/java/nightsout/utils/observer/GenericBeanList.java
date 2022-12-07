package nightsout.utils.observer;

import nightsout.utils.bean.ClubOwnerBean;
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

    public void addUsersToList(List<UserBean> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (UserBean userBean : listBean) {
                beans.add(userBean);
                notify(userBean);
            }
        }
    }

    public void addEventsToList(List<EventBean> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (EventBean eventBean : listBean) {
                beans.add(eventBean);
                notify(eventBean);
            }
        }
    }

    public void addClubOwnersToList(List<ClubOwnerBean> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (ClubOwnerBean clubOwnerBean : listBean) {
                beans.add(clubOwnerBean);
                notify(clubOwnerBean);
            }
        }
    }

}
