package nightsout.model;

public class RequestModel {

    public RequestModel() {

    }

    public RequestModel(int idRequest) {
        this.idRequest = idRequest;
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
