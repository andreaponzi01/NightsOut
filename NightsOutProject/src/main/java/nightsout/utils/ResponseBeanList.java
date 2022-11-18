package nightsout.utils;

import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponseBeanList extends Subject {

    private List<ResponseBean> beans;

    public ResponseBeanList(Observer observer) {
        super(observer);
        beans = new ArrayList<>();
    }


    /*
    public void addResponseToListProva(List<ResponseBean> listBean) throws SQLException {
        if (listBean != null && !listBean.isEmpty()) {
            for (ResponseBean responseBean : listBean) {
                beans.add(responseBean);
                notify(responseBean);
            }
        }
    }

     */

    public void addResponseToList(ResponseBean responseBean) throws SQLException {
        beans.add(responseBean);
        notify(responseBean);
    }
}
