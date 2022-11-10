package nightsout.utils.bean;

import nightsout.model.ManageRequestModel;

import java.time.LocalDate;

public class ManageRequestBean {

    //R.idRequest, R.status, U.name, U.surname, E.name

    public ManageRequestBean(ManageRequestModel manageRequestModel) {
        this.idRequest = manageRequestModel.getIdRequest();
        this.eventName = manageRequestModel.getEventName();
        this.requestDate = manageRequestModel.getRequestDate().toLocalDate();
        this.userName = manageRequestModel.getUserName();
        this.userSurname = manageRequestModel.getUserSurname();
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
