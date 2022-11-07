package nightsout.utils;

import nightsout.control.appcontroller.SearchAppController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;

import java.util.ArrayList;

public class SearchEngineering {

    private SearchEngineering() {}

    public static void search(Observer observer, String input){
        /*
        Subject: è colui che viene osservato. Nel caso specifico si tratta della nostra lista GenericBeanList
        L'osservato deve mantenere il riferimento ai propri osservatori, così da poterli notificare ogni
        volta che viene aggiornato lo stato dell'osservato.

        Observer: è colui che osserva. Nel caso specifica si tratta del SearchPageGUIController1, che
        quando riceve una notifica (cioè, ogni volta che viene aggiunto un User/Event Bean alla lista),
        aggiunge un Item (fxml) alla pagina.
        */


        /*
        Creiamo l'oggetto Subject, aggiugendo sin da subito il riferimento all'observer chiamante, che ci
        passiamo alla chiamata della funzione search (cioè, SearchPageGUIController1).
        */
        GenericBeanList list = new GenericBeanList(observer);

        list.addUsersToList(searchUsers(input));

        //list.addEventsToList(searchEvents(input));

        //list.printItems();

    }

    private static ArrayList<UserBean> searchUsers(String input) {
        ArrayList<UserBean> listBean = new ArrayList<UserBean>();
        listBean = SearchAppController.searchUserByUsername(input);

        System.out.println("searchUsers");
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
