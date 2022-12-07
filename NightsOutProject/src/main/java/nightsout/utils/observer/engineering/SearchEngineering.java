package nightsout.utils.observer.engineering;

import nightsout.control.appcontroller.SearchAppController;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

import java.util.List;

public class SearchEngineering {

    private SearchEngineering() {
        //ignored
    }

    public static void search(Observer observer, String input) throws SystemException {
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

        list.addEventsToList(searchEvents(input));
        list.addUsersToList(searchUsers(input));
        list.addClubOwnersToList(searchClubOwners(input));

    }

    private static List<UserBean> searchUsers(String input) throws SystemException { return SearchAppController.searchUsersByUsername(input); }

    private static List<EventBean> searchEvents(String input) throws SystemException { return SearchAppController.searchEventsByName(input); }

    private static List<ClubOwnerBean> searchClubOwners(String input) { return SearchAppController.searchClubOwnersByUsername(input); }

}
