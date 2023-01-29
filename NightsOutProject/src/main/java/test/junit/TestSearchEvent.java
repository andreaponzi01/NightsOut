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
 */

public class TestSearchEvent {

    @Test
    public void testSearchEvent() throws SystemException {

        JoinEventAppController controller = new JoinEventAppController();
        List<EventBean> list1 = controller.searchEventsByName(new SearchBean("Piper Night"));
        List<EventBean> list2 = controller.searchEventsByName(new SearchBean("NightsOut"));

        int ret1 = 0;
        int ret2 = 0;

        if (!list1.isEmpty()){
            ret1 = 1;
        }

        if (!list2.isEmpty()){
            ret2 = 1;
        }

        /*
            Commentare uno dei due assert in modo tale da effettuare il test.
            L'assert non è stato commentato per non avere code smell.
         */

        assertEquals(1, ret1, 0); // SUCCESS
        assertEquals(0, ret2, 0); // SUCCESS
    }

}
