package nightsout.model;

import java.time.LocalDate;

public class RequestModel {
    private int idUser;
    private int idRequest;
    private LocalDate requestDate;
    private int idEvent;
    private String status;


    public LocalDate getRequestDate() {
        return requestDate;
    }
    public int getIdRequest() {
        return idRequest;
    }
    public int getIdUser() {
        return idUser;
    }
    public int getIdEvent() {
        return idEvent;
    }

    public String getStatus() {
        return status;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }
    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }
}
