package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.CreateEventAppController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.scenes.ReplaceScene;

public class CreateEventGUIController1 {

    private int idClubOwner;

    private EventBean eventBean;

    @FXML
    Button buttonBack, buttonCreateEvent;

    @FXML
    Slider sliderTime;

    @FXML
    DatePicker dateEvent;

    @FXML
    TextField textFieldName, textFieldPrice, textFieldHours, textFieldMinutes;

    public void setIdClubOwner(int id) {
        this.idClubOwner = id;
    }

    @FXML
    private void backToWelcomePage(ActionEvent actionEvent) {
        ReplaceScene.replaceScene(actionEvent, "/ClubOwnerPage1.fxml");
    }


    @FXML
    private void goToCreateEvent(ActionEvent actionEvent) {
        eventBean = new EventBean();
        eventBean.setEventDate(dateEvent.getValue());
        eventBean.setDuration((int) sliderTime.getValue());
        eventBean.setHours(Integer.parseInt(textFieldHours.getText()));
        eventBean.setMinutes(Integer.parseInt(textFieldMinutes.getText()));
        eventBean.setName(textFieldName.getText());
        eventBean.setIdClubOwner(idClubOwner);
        eventBean.setPrice(Double.valueOf(textFieldPrice.getText()));
        CreateEventAppController.createEvent(eventBean);
    }
}
