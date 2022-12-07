package nightsout.utils.observer;

import nightsout.utils.bean.RequestBean;

import java.util.ArrayList;
import java.util.List;

public class RequestBeanList extends Subject {

    private List<RequestBean> beans;

    public RequestBeanList(Observer observer) {
        super(observer);
        beans = new ArrayList<>();
    }

    public void addRequestsToList(List<RequestBean> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (RequestBean requestBean : listBean) {
                beans.add(requestBean);
                notify(requestBean);
            }
        }
    }
}
