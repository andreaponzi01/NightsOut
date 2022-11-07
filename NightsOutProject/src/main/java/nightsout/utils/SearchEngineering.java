package nightsout.utils;

import nightsout.control.appcontroller.SearchAppController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;

import java.util.ArrayList;

public class SearchEngineering {

    private SearchEngineering() {}

    public static void search(Observer ob, String input){
        //GenericList list = new GenericList(ob);

        GenericBeanList list = new GenericBeanList();
        list.addUsersToList(searchUsers(input));
        list.addEventsToList(searchEvents(input));
        list.printItems();

        //ArrayList<UserBean> list1 = searchUsers(input);
        //ArrayList<EventBean> list = searchEvents(input);

        /*
        list.addAllUsersToList(Search.searchUserByUsername(input));
        list.addAllEventsToList(Search.searchByEventName(input));
        list.addAllPartyToList(Search.searchByPartyName(input));
         */
    }

    private static ArrayList<UserBean> searchUsers(String input) {
        ArrayList<UserBean> listBean = new ArrayList<UserBean>();
        listBean = SearchAppController.searchUserByUsername(input);

        for(UserBean bean : listBean) {
            System.out.println("Risultato: " + bean.getName());
        }

        return listBean;
    }

    private static ArrayList<EventBean> searchEvents(String input) {
        ArrayList<EventBean> listBean = new ArrayList<EventBean>();
        listBean = SearchAppController.searchEventsByName(input);

        for(EventBean bean : listBean) {
            System.out.println("Risultato: " + bean.getName());
        }

        return listBean;
    }

}
