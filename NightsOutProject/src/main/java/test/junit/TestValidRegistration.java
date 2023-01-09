package test.junit;

import nightsout.model.CredentialsModel;
import nightsout.utils.dao.LoginDAO;
import nightsout.utils.exception.myexception.SystemException;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestValidRegistration {

    @Test
    public void testRegistration() throws SystemException {
        CredentialsModel credentialsModel1 = new CredentialsModel();
        CredentialsModel credentialsModel2 = new CredentialsModel();


        credentialsModel1.setUsername("king");
        credentialsModel1.setPassword("kingking");
        credentialsModel1.setType("ClubOwner");

        credentialsModel2.setUsername("mario");
        credentialsModel2.setPassword("mariorossi");
        credentialsModel2.setType("Free");

        boolean ret1 = LoginDAO.checkIsRegistered(credentialsModel1);    //SUCCESS
        boolean ret2 = LoginDAO.checkIsRegistered(credentialsModel2);   //FAILED

        assertTrue(ret1);
        assertFalse(ret2);
    }

}
