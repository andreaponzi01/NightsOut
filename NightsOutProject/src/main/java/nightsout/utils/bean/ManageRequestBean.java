package nightsout.utils.bean;

import nightsout.model.RequestModel;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;

import java.io.File;
import java.time.LocalDate;

public class ManageRequestBean {

    public ManageRequestBean(RequestModel requestModel, UserBean1 userBean1, EventBean1 eventBean) {
        this.idRequest = requestModel.getIdRequest();
        this.eventName = eventBean.getName();
        this.requestDate = requestModel.getRequestDate();
        this.username = userBean1.getUsername();
        this.img= userBean1.getImg();
    }

    private int idRequest;
    private String eventName;
    private LocalDate requestDate;
    private String username;
    private File img;



    public File getImg() {
        return img;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public void setImg(File img) {
        this.img = img;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public String getEventName() {
        return eventName;
    }
    public LocalDate getRequestDate() {
        return requestDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
