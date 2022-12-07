package nightsout.utils.bean;

import nightsout.model.ReviewModel;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.EmptyInputException;

public class ReviewBean {


    private int idReview;
    private int idUser;
    private int idEvent;
    private String comment;

    public ReviewBean() {
    }

    public ReviewBean(ReviewModel reviewModel) {
        this.idReview = reviewModel.getIdReview();
        this.idUser = reviewModel.getIdUser();
        this.idEvent = reviewModel.getIdEvent();
        this.comment = reviewModel.getComment();
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

    public void setComment(String comment) throws EmptyInputException {
        if (comment.isEmpty()) {
            Trigger.throwEmptyInputException("Comment");
        }
        this.comment = comment;
    }

}
