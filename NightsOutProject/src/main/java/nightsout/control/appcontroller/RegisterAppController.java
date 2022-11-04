package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.Credentials;
import nightsout.utils.dao.ClubOwnerDAO;

public class RegisterAppController {

    public static void registerClubOwner(ClubOwnerBean clubOwnerBean) {
        Credentials myCred = new Credentials(clubOwnerBean.getUsername(), clubOwnerBean.getPassword(), "ClubOwner");
        ClubOwnerModel clubOwnerModel = new ClubOwnerModel(clubOwnerBean, myCred);
        ClubOwnerDAO.insertClubOwner(clubOwnerModel);
    }

}
