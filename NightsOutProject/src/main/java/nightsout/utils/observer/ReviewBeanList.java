package nightsout.utils.observer;

import nightsout.utils.bean.ReviewBean;

import java.util.ArrayList;
import java.util.List;

public class ReviewBeanList extends Subject {

    private List<ReviewBean> beans;

    public ReviewBeanList(Observer observer) {
        super(observer);
        beans = new ArrayList<>();
    }

    public void addReviewToList(List<ReviewBean> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (ReviewBean reviewBean : listBean) {
                beans.add(reviewBean);
                notify(reviewBean);
            }
        }
    }
}
