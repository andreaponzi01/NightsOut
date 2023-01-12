package nightsout.utils.engineering;

import nightsout.control.appcontroller.SearchAppController;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

public class SearchEngineering {

    private SearchEngineering() {
        //ignored
    }

    public static void search(Observer observer, String input) throws SystemException {

        GenericBeanList list = new GenericBeanList(observer);

        list.addEventsToList(SearchAppController.searchEventsByName(input));
        list.addUsersToList(SearchAppController.searchUsersByUsername(input));
        list.addClubOwnersToList(SearchAppController.searchClubOwnersByUsername(input));

    }
}
