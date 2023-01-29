package test.junit;

import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.SearchBean;
import nightsout.utils.exception.myexception.SystemException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/*
    Testiamo che ci siano risultati di ricerca corrispodenti ad eventi.
    Nel test controlliamo che la ricerca ritorna effettivamente una lista non vuota nel caso in cui cerchiamo un evento presente nel DB nel nostro caso "Piper Night"
    È necessario utilizzare il dump del Database fornito in fase di consegna affinché i test abbiano il risultato sperato.

    @Andrea Galluzzi
 */

public class TestSearchEvent {

    @Test
    public void testSearchEvent() throws SystemException {

        JoinEventAppController controller = new JoinEventAppController();
        List<EventBean> list1 = controller.searchEventsByName(new SearchBean("Piper Night"));

        int ret1 = 0;

        if (!list1.isEmpty()){
            ret1 = 1;
        }

        assertEquals(1, ret1, 0); // SUCCESS
    }

    @Test
    public void testSearchEventFail() throws SystemException {

        JoinEventAppController controller = new JoinEventAppController();
        List<EventBean> list2 = controller.searchEventsByName(new SearchBean("NightsOut"));

        int ret2 = 0;

        if (!list2.isEmpty()){
            ret2 = 1;
        }

        assertEquals(1, ret2, 0); // FAIL
    }

}
