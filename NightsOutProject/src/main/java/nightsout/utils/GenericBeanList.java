package nightsout.utils;

import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.GenericBean;
import nightsout.utils.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class GenericBeanList {

    private List<GenericBean> list;

    public void printItems() {
        for(int i=0; i < list.size(); i++) {
            System.out.println("Risultato " + i + " "+list.get(i).getName());
        }
    }

    public void addUsersToList(ArrayList<UserBean> listBean) {
        for(GenericBean userBean : list){
            list.add(userBean);
        }
    }

    public void addEventsToList(ArrayList<EventBean> listBean) {
        for(GenericBean eventBean : list){
            list.add(eventBean);
        }
    }

    public GenericBeanList() {
        list = new ArrayList<GenericBean>();
    }

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
