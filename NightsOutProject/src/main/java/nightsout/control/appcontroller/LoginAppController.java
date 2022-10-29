package nightsout.control.appcontroller;

import nightsout.utils.Authentication;
import nightsout.utils.bean.LoginBean;

public class LoginAppController {

    private LoginAppController() {
        //ignored
    }

    public static void login(LoginBean loginBean) throws Exception {

        if (Authentication.checkIsRegistered(loginBean.getUsername(), loginBean.getPassword(), loginBean.getType()) == 1){
            System.out.println("Username e password corretti");
        } else {
            System.out.println("Username o password errati");
        }

        //ClubModel clubModel = null;
        if (loginBean.getType() == "ClubOwner") {
            /*
            // login MANAGER
           if (Authentication.checkIsRegistered(1, loginBean.getPassword(), loginBean.getUsername()) == 1) {
                clubModel = ClubDao.getClubByUserName(loginBean.getUsername());
                ClubBean clubBean = new ClubBean(clubModel);
                ThreadLocalSession.getUserSession().set(new Session(clubBean));
                ThreadLocalSession.getUserSession().get().getClubBean().setId(ClubDao.clubIdbyClub(clubModel));
            }
            else{
                Trigger.throwWrongPassword();
            }
            return clubModel;
            */
        }
        else{
            // login USER
            /*
            UserModel userModel = null;
            if (Authentication.checkIsRegistered(0, loginBean.getPassword(), loginBean.getUsername()) ==1){
                ThreadLocalSession.setUsername(loginBean.getUsername());
                userModel = UserDao.getUserByUsername(loginBean.getUsername());
                UserBean userBean = new UserBean(userModel);
                ThreadLocalSession.getUserSession().set(new Session(userBean));
            }

            else{
                Trigger.throwWrongPassword();
            }
            return userModel;
            */

        }
    }

}
