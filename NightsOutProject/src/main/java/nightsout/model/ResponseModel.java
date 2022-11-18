package nightsout.model;

import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;

public class ResponseModel {



    private int idAnswer;
    private int idClubOwner;
    private int review;
    private String response;

    public ResponseModel() {

    }

    public ResponseModel(ResponseBean responseBean) {
        this.idAnswer = responseBean.getIdAnswer();
        this.idClubOwner = responseBean.getIdClubOwner();
        this.review = responseBean.getReview();
        this.response = responseBean.getResponse();
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public int getIdClubOwner() {
        return idClubOwner;
    }

    public void setIdClubOwner(int idClubOwner) {
        this.idClubOwner = idClubOwner;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
