package test.junit;

import nightsout.model.UserModel;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
        È necessario utilizzare il dump del Database fornito in fase di consegna affinché i test abbiano il risultato sperato.
*/

public class TestUserByUsernameQuery {

    @Test
    public void testUserByUsernameQuery() throws SystemException {

        UserDAO userDAO = new UserDAO();
        UserModel userModel1 = userDAO.getUserByUsername("andreagalluzzi20");
        int ret1 = userModel1.getId();

        UserModel userModel2 = userDAO.getUserByUsername("mariorossi");
        int ret2 = userModel2.getId();



        assertEquals(4, ret1, 0); // SUCCESS
        // assertEquals(4, ret2, 0); // FAILED
    }
}
