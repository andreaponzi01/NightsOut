package nightsout.model;

import nightsout.utils.bean.ResponseBean;

public class ResponseModel {

    private int review;
    private String response;
    private int idAnswer;
    private int idClubOwner;

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
    public String getResponse() {
        return response;
    }
    public int getIdClubOwner() {
        return idClubOwner;
    }
    public int getReview() {
        return review;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }
    public void setReview(int review) {
        this.review = review;
    }
    public void setIdClubOwner(int idClubOwner) {
        this.idClubOwner = idClubOwner;
    }
}
