package test.junit;

import nightsout.utils.bean.EmailBean;
import nightsout.utils.engineering.CheckEmailEngineering;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    Test che permette di verificare se una email fornita rispetta il formato corretto.
 */

public class TestValidEmail {

    @Test
    public void testValidator(){

        String email1 = "testmail";
        String email2 = "test@gmail.com";

        int case1 = 0;
        int case2 = 0;
        EmailBean emailBean = new EmailBean();

        CheckEmailEngineering checkEmailEngineering = new CheckEmailEngineering();
        emailBean.setEmail(email2);
        if(checkEmailEngineering.validate(emailBean)){
            case2 = 1;
        }

        emailBean.setEmail(email1);
        if(checkEmailEngineering.validate(emailBean)){
            case1 = 1;
        }

        /*
            Commentare uno dei due assert in modo tale da effettuare il test.
            L'assert non è stato commentato per non avere code smell.
         */

        assertEquals(1, case2, 0); //Success
        assertEquals(0, case1, 0); //Fail
    }
}