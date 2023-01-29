package test.junit;

import nightsout.utils.db.MySqlConnection;
import nightsout.utils.exception.myexception.SystemException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Testiamo l'avvenuta connessione con il Database.
    Il test ha successo se la connessione è stabilita.
    Il test fallisce altrimenti.

    @Andrea Galluzzi
 */

public class TestDBConnection {

    @Test
    public void testSearchEvent() throws SystemException {

        int value = 0;

        if (MySqlConnection.getInstance().connect() != null) {
            value = 1;
        }

        assertEquals(1, value);

    }

}
