package nightsout.model;

import nightsout.utils.bean.ReviewBean;

public class ReviewModel {


    private int idReview;
    private int idUser;
    private int idEvent;
    private String comment;

    public ReviewModel() {

    }

    public ReviewModel(ReviewBean reviewBean) {
        this.idReview = reviewBean.getIdReview();
        this.idUser = reviewBean.getIdUser();
        this.idEvent = reviewBean.getIdEvent();
        this.comment = reviewBean.getComment();
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
