package nightsout.utils;

import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.ReviewBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewBeanList extends Subject {

    private List<ReviewBean> beans; // da fare

    public ReviewBeanList(Observer observer) {
        super(observer);
        beans = new ArrayList<>();
    }

    public void addReviewToList(List<ReviewBean> listBean) throws SQLException {
        if (listBean != null && !listBean.isEmpty()) {
            for (ReviewBean reviewBean : listBean) {
                beans.add(reviewBean);
                notify(reviewBean);
            }
        }
    }
}
