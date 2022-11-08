package nightsout.utils;

import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.GenericBean;
import nightsout.utils.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

//ConcreteSubject
public class GenericBeanList extends Subject {

    private List<GenericBean> list;

    public GenericBeanList(Observer observer) {
        super(observer);
        list = new ArrayList<>();
    }

    public void addUsersToList(ArrayList<UserBean> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (UserBean userBean : listBean) {
                list.add(userBean);
                notify(userBean);
            }
        }
    }

    public void addEventsToList(ArrayList<EventBean> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (EventBean eventBean : listBean) {
                list.add(eventBean);
                notify(eventBean);
            }
        }
    }




/*
    public GenericBeanList() {
        list = new ArrayList<GenericBean>();
    }

 */

    /*
    public GenericList(ArrayList<GenericBean>) {
        list = new ArrayList<GenericBean>();
    }

    public GenericList(GenericBean model) {
        //List<GenericBean> list = new ArrayList<>();

        this(new ArrayList<GenericBean>());
        if(model!= null){
            this.attach(model);
        }
    }

    public void attach(GenericBean model){ this.list.add(model); }
     */
}
