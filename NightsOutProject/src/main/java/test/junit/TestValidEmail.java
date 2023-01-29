package test.junit;

import nightsout.utils.bean.EmailBean;
import nightsout.utils.engineering.CheckEmailEngineering;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    Test che permette di verificare se una email fornita rispetta il formato corretto.

    @Andrea Galluzzi
 */

public class TestValidEmail {

    @Test
    public void testValidatorEmail(){

        String email2 = "test@gmail.com";
        int case2 = 0;
        EmailBean emailBean = new EmailBean();
        CheckEmailEngineering checkEmailEngineering = new CheckEmailEngineering();

        emailBean.setEmail(email2);
        if(checkEmailEngineering.validate(emailBean)){
            case2 = 1;
        }

        assertEquals(1, case2, 0); //Success
    }

    @Test
    public void testValidatoEmailFail(){

        String email1 = "testmail";
        int case1 = 0;
        EmailBean emailBean = new EmailBean();
        CheckEmailEngineering checkEmailEngineering = new CheckEmailEngineering();

        emailBean.setEmail(email1);
        if(checkEmailEngineering.validate(emailBean)){
            case1 = 1;
        }

        assertEquals(0, case1, 0); //Fail
    }
}