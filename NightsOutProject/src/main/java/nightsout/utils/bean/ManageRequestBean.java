package nightsout.utils.bean;

import nightsout.model.RequestModel;

import java.time.LocalDate;

public class ManageRequestBean {

    public ManageRequestBean(RequestModel requestModel, UserBean userBean, EventBean eventBean) {
        this.idRequest = requestModel.getIdRequest();
        this.eventName = eventBean.getName();
        this.requestDate = requestModel.getRequestDate();
        this.userName = userBean.getName();
    }

    private int idRequest;
    private String eventName;
    private LocalDate requestDate;
    private String userName;
    private String userSurname;

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public String getEventName() {
        return eventName;
    }

    public void setRequestName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setEventDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

}
