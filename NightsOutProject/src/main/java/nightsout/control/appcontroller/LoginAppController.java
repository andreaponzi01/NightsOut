package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.utils.Authentication;
import nightsout.utils.bean.LoginBean;
import nightsout.utils.exception.Trigger;

public class LoginAppController {

    private LoginAppController() {
        //ignored
    }

    public static void login(LoginBean loginBean) throws Exception {

        if (loginBean.getType() == "ClubOwner") {
            if (Authentication.checkIsRegistered(loginBean.getUsername(), loginBean.getPassword(), loginBean.getType()) == 1){
                System.out.println("Username e password corretti");
            } else {
                System.out.println("Username o password errati");
                Trigger.throwWrongPassword();
            }
        }
        else{
            if (Authentication.checkIsRegistered(loginBean.getUsername(), loginBean.getPassword(), loginBean.getType()) == 1){
                System.out.println("Username e password corretti");
            } else {
                System.out.println("Username o password errati");
                Trigger.throwWrongPassword();
            }
        }
    }

}
