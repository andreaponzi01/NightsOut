package nightsout.utils.bean;

import nightsout.model.ResponseModel;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.Subject;

import java.sql.SQLException;

public class ResponseBean extends Subject {

    private int idAnswer;
    private int idClubOwner;
    private int review;
    private String response;

    public ResponseBean() {
        super();

    }

    public ResponseBean(Observer observer) {
        super(observer);

    }

    public ResponseBean(ResponseModel responseModel) {
        this.idAnswer = responseModel.getIdAnswer();
        this.idClubOwner = responseModel.getIdClubOwner();
        this.review = responseModel.getReview();
        this.response = responseModel.getResponse();
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

    public void addResponse(ResponseBean responseBean) throws SQLException, SystemException {
        notify(responseBean);
    }

}
