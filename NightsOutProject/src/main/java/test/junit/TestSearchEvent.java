package test.junit;

import nightsout.control.appcontroller.SearchAppController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.exception.myexception.SystemException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSearchEvent {

    @Test
    public void testSearchEvent() throws SystemException {

        List<EventBean> list1 = SearchAppController.searchEventsByName("king");
        List<EventBean> list2 = SearchAppController.searchEventsByName("miaomiaomiao");

        int ret1 = 0;
        int ret2 = 0;

        if (!list1.isEmpty()){
            ret1 = 1;
        }

        if (!list2.isEmpty()){
            ret2 = 1;
        }

        assertEquals(1, ret1, 0);
        assertEquals(0, ret2, 0);
    }

}
