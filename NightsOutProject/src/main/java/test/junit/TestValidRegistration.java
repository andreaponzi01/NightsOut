package test.junit;

import nightsout.model.CredentialsModel;
import nightsout.utils.dao.LoginDAO;
import nightsout.utils.exception.myexception.SystemException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/*
    Testiamo l'effettiva registrazione degli utenti tramite credenziali.
    È necessario utilizzare il dump del Database fornito in fase di consegna affinché i test abbiano il risultato sperato.
 */

public class TestValidRegistration {

    @Test
    public void testRegistration() throws SystemException {

        LoginDAO loginDAO = new LoginDAO();

        CredentialsModel credentialsModel1 = new CredentialsModel();
        CredentialsModel credentialsModel2 = new CredentialsModel();


        credentialsModel1.setUsername("piperclub65");
        credentialsModel1.setPassword("piperclub65");
        credentialsModel1.setType("ClubOwner");

        credentialsModel2.setUsername("mario");
        credentialsModel2.setPassword("mariorossi");
        credentialsModel2.setType("Free");

        boolean ret1 = loginDAO.checkIsRegistered(credentialsModel1);    // SUCCESS
        boolean ret2 = loginDAO.checkIsRegistered(credentialsModel2);   // FAILED

        /*
            Commentare uno dei due assert in modo tale da effettuare il test.
            L'assert non è stato commentato per non avere code smell.
         */

        assertTrue(ret1);
        assertTrue(ret2);
    }

}
