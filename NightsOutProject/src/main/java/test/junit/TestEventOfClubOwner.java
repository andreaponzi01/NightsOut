package test.junit;

import nightsout.model.EventModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/*
    Testiamo che  un evento è effettivamente di un ClubOwner.
    Nel test controlliamo che l' evento nel db "Piper Night" con id "95" abbia come proprietario "PiperClub"
    È necessario utilizzare il dump del Database fornito in fase di consegna affinché i test abbiano il risultato sperato.

    @Andrea Ponzi
 */

public class TestEventOfClubOwner {

    @Test
    public void testSearchEvent() throws SystemException {

        Query query = new Query();
        EventModel eventModel = query.searchEventByIdEvent(95);
        String name = query.searchClubOwnerById(eventModel.getIdClubOwner()).getClubName();

        assertTrue(name.equalsIgnoreCase("Piper Club"));
    }

    @Test
    public void testSearchEventFail() throws SystemException {

        Query query = new Query();
        EventModel eventModel = query.searchEventByIdEvent(98);
        String name = query.searchClubOwnerById(eventModel.getIdClubOwner()).getClubName();

        assertTrue(name.equalsIgnoreCase("Piper Club"));
    }

}
