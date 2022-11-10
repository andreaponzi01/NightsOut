package nightsout.model;

import java.sql.Date;

public class ManageRequestModel {
    public ManageRequestModel() {}

    public ManageRequestModel(int idRequest) {
        this.idRequest = idRequest;
    }

    private String eventName;
    private String userName;
    private String userSurname;
    private Date requestDate;
    private int idRequest;

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
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
