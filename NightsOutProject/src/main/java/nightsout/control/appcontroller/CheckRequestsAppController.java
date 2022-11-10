package nightsout.control.appcontroller;

import nightsout.model.RequestModel;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.dao.RequestDAO;

import java.util.ArrayList;
import java.util.List;

public class CheckRequestsAppController {

    private CheckRequestsAppController() {
        //ignored
    }
    public static List<RequestBean> searchRequestsByIdUser(int idUser) {
        List<RequestModel> list = null;
        List<RequestBean> listBean = null;
        try {
            list = RequestDAO.getRequestsByIdUser(idUser);
            listBean = new ArrayList<>();

            for(RequestModel rm : list){
                RequestBean bean = new RequestBean(rm);
                listBean.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBean;
    }
}
