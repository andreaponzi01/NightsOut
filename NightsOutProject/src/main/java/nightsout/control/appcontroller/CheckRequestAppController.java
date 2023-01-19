package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.model.RequestModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.RequestDAO;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.RequestBeanList;

import java.util.ArrayList;
import java.util.List;

public class CheckRequestAppController {


    public void checkRequests(Observer observer, int idUser) throws SystemException {

        RequestBeanList list = new RequestBeanList(observer);
        list.addRequestsToList(searchRequestsByIdUser(idUser));
    }

    private List<RequestBean> searchRequestsByIdUser(int idUser) throws SystemException {

        RequestDAO requestDAO = new RequestDAO();
        List<RequestModel> list = requestDAO.getRequestsByIdUser(idUser);
        List<RequestBean> listBean = new ArrayList<>();
        for(RequestModel rm : list){
            RequestBean bean = new RequestBean(rm);
            listBean.add(bean);
        }
        return listBean;
    }
}
