package nightsout.utils.bean;

import nightsout.model.RequestModel;

public class RequestBean {

    public RequestBean(RequestModel requestModel) {
        this.idRequest = requestModel.getIdRequest();
        this.idUser = requestModel.getIdUser();
        this.idEvent = requestModel.getIdEvent();
        this.status = requestModel.getStatus();
    }

    private int idRequest;
    private int idUser;
    private int idEvent;
    private String status;

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
