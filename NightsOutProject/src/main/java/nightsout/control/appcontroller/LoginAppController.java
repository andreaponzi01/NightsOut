package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.UserModel;
import nightsout.utils.Authentication;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.LoginBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.Trigger;

public class LoginAppController {

    private LoginAppController() {
        //ignored
    }

    public static UserBean loginUser(LoginBean loginBean) throws Exception {

            UserModel userModel = null;
            UserBean userBean = null;

            if (Authentication.checkIsRegistered(loginBean.getUsername(), loginBean.getPassword(), loginBean.getType()) == 1) {
                System.out.println("Username (" + loginBean.getUsername() + ") e password corretti");
                userModel = UserDAO.getUserByUsername(loginBean.getUsername());
                userBean = new UserBean(userModel);
                userBean.setType("Free");
            } else {
                System.out.println("Username o password errati");
                Trigger.throwWrongPassword();
            }

            return userBean;
    }

    public static ClubOwnerBean loginClubOwner(LoginBean loginBean) throws Exception {

            ClubOwnerModel clubOwnerModel = null;
            ClubOwnerBean clubOwnerBean = null;

            if (Authentication.checkIsRegistered(loginBean.getUsername(), loginBean.getPassword(), loginBean.getType()) == 1) {
                System.out.println("Username (" + loginBean.getUsername() + ") e password corretti");
                clubOwnerModel = ClubOwnerDAO.getClubOwnerByUsername(loginBean.getUsername());
                clubOwnerBean = new ClubOwnerBean(clubOwnerModel);
                clubOwnerBean.setType("Club Owner");
            } else {
                System.out.println("Username o password errati");
                Trigger.throwWrongPassword();
            }

            return clubOwnerBean;
    }

    /*
    public static ProfileBean login(LoginBean loginBean) throws Exception {

        if (Objects.equals(loginBean.getType(), "ClubOwner")) {

            ClubOwnerModel clubOwnerModel = null;
            ClubOwnerBean clubOwnerBean = null;

            if (Authentication.checkIsRegistered(loginBean.getUsername(), loginBean.getPassword(), loginBean.getType()) == 1) {
                System.out.println("Username (" + loginBean.getUsername() + ") e password corretti");
                clubOwnerModel = ClubOwnerDAO.getClubOwnerByUsername(loginBean.getUsername());
                clubOwnerBean = new ClubOwnerBean(clubOwnerModel);
                System.out.println("\n\nBean: "+clubOwnerBean.getUsername());
            } else {
                System.out.println("Username o password errati");
                Trigger.throwWrongPassword();
            }

            return clubOwnerBean;
        } else {
            UserModel userModel = null;
            UserBean userBean = null;

            if (Authentication.checkIsRegistered(loginBean.getUsername(), loginBean.getPassword(), loginBean.getType()) == 1) {
                System.out.println("Username (" + loginBean.getUsername() + ") e password corretti");
                userModel = UserDAO.getUserByUsername(loginBean.getUsername());
                userBean = new UserBean(userModel);
            } else {
                System.out.println("Username o password errati");
                Trigger.throwWrongPassword();
            }

            return userBean;
        }
    }
    */
}
