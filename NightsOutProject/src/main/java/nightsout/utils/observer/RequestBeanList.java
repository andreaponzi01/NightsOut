package nightsout.utils.observer;

import nightsout.utils.bean.RequestBean;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.Subject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestBeanList extends Subject {

    private List<RequestBean> beans;

    public RequestBeanList(Observer observer) {
        super(observer);
        beans = new ArrayList<>();
    }

    public void addRequestsToList(List<RequestBean> listBean) throws SQLException {
        if (listBean != null && !listBean.isEmpty()) {
            for (RequestBean requestBean : listBean) {
                beans.add(requestBean);
                notify(requestBean);
            }
        }
    }
}
