package test.junit;

import nightsout.model.UserModel;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUserByUsernameQuery {
    @Test
    public void testUserByUsernameQuery() throws SystemException {

        UserDAO userDAO = new UserDAO();
        UserModel userModel1 = userDAO.getUserByUsername("duce");
        int ret1 = userModel1.getId();

        UserModel userModel2 = userDAO.getUserByUsername("ciao");
        int ret2 = userModel2.getId();

        assertEquals(3, ret1, 0); // SUCCESS
        //assertEquals(3, ret2, 0); // FAILED
        assertEquals(4, ret2, 0); // SUCCESS
    }
}
