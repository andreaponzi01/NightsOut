package nightsout.utils.observer;

import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.Subject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageRequestBeanList extends Subject {

    private List<ManageRequestBean> beans;

    public ManageRequestBeanList(Observer observer) {
        super(observer);
        beans = new ArrayList<>();
    }

    public void addRequestsToList(List<ManageRequestBean> listBean) throws SQLException, SystemException {
        if (listBean != null && !listBean.isEmpty()) {
            for (ManageRequestBean manageRequestBean : listBean) {
                beans.add(manageRequestBean);
                notify(manageRequestBean);
            }
        }
    }

}
