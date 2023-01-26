package nightsout.control.appcontroller;

import nightsout.model.RequestModel;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.dao.RequestDAO;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.RequestBeanList;

import java.util.ArrayList;
import java.util.List;

public class CheckRequestAppController {


    public void checkRequests(Observer observer, IdBean idBean) throws SystemException {

        RequestBeanList list = new RequestBeanList(observer);
        list.addRequestsToList(searchRequestsByIdUser(idBean.getId()));
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
