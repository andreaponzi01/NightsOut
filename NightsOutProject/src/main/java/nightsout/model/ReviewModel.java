package nightsout.model;

import nightsout.utils.bean.ReviewBean;

public class ReviewModel {

    private int idEvent;
    private String comment;
    private int idReview;
    private int idUser;


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
    public String getComment() {
        return comment;
    }
    public int getIdUser() {
        return idUser;
    }
    public int getIdEvent() {
        return idEvent;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

}
