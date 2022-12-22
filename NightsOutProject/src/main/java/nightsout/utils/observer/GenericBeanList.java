package nightsout.utils.observer;

import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.GenericBean;
import nightsout.utils.bean.interface1.UserBean1;

import java.util.ArrayList;
import java.util.List;

//ConcreteSubject
public class GenericBeanList extends Subject {

    private List<GenericBean> beans;

    public GenericBeanList(Observer observer) {
        super(observer);
        beans = new ArrayList<>();
    }

    public void addUsersToList(List<UserBean1> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (UserBean1 userBean : listBean) {
                beans.add(userBean);
                notify(userBean);
            }
        }
    }

    public void addEventsToList(List<EventBean1> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (EventBean1 eventBean : listBean) {
                beans.add(eventBean);
                notify(eventBean);
            }
        }
    }

    public void addClubOwnersToList(List<ClubOwnerBean1> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (ClubOwnerBean1 clubOwnerBean1 : listBean) {
                beans.add(clubOwnerBean1);
                notify(clubOwnerBean1);
            }
        }
    }

}
