package nightsout.control.appcontroller;

import nightsout.model.ManageRequestModel;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.dao.RequestDAO;

import java.util.ArrayList;
import java.util.List;

public class ManageRequestAppController {
    public static List<ManageRequestBean> searchRequestsByIdClubOwner(int idClubOwner) {
        List<ManageRequestModel> list = null;
        List<ManageRequestBean> listBean = null;
        try {
            list = RequestDAO.getRequestsByIdClubOwner(idClubOwner);
            listBean = new ArrayList<>();

            for(ManageRequestModel mrm : list){
                ManageRequestBean bean = new ManageRequestBean(mrm);
                listBean.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBean;
    }
}
