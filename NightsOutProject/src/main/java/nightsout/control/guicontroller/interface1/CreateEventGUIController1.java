package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.CreateEventAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.exception.myexception.WrongInputTypeException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class CreateEventGUIController1 {

    private ClubOwnerBean clubOwnerBean;
    private EventBean eventBean;

    @FXML
    Button buttonBack;
    @FXML
    Button buttonCreateEvent;
    @FXML
    Slider sliderTime;
    @FXML
    DatePicker dateEvent;
    @FXML
    TextField textFieldName;
    @FXML
    TextField textFieldPrice;
    @FXML
    TextField textFieldHours;
    @FXML
    TextField textFieldMinutes;
    @FXML
    TextField textFieldDescription;

    public void setAll(ClubOwnerBean clubOwnerBean) {
        this.clubOwnerBean = clubOwnerBean;
    }

    @FXML
    private void backToWelcomePage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml", null, clubOwnerBean);
    }


    @FXML
    private void createEvent(ActionEvent actionEvent) throws IOException {

        try {
            eventBean = new EventBean();
            eventBean.setEventDate(dateEvent.getValue());
            eventBean.setDuration((int) sliderTime.getValue());
            eventBean.setHours(Integer.parseInt(textFieldHours.getText()));
            eventBean.setMinutes(Integer.parseInt(textFieldMinutes.getText()));
            eventBean.setName(textFieldName.getText());
            eventBean.setIdClubOwner(this.clubOwnerBean.getId());
            eventBean.setDescription(textFieldDescription.getText());
            eventBean.setPrice(textFieldPrice.getText());

            CreateEventAppController.createEvent(eventBean);



            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml", null, clubOwnerBean);
        } catch (WrongInputTypeException e) {
            System.err.println(e.getCause());
            MyNotification.createNotification(e);
        }

    }
}
