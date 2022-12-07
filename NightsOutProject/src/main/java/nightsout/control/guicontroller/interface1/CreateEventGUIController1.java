package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nightsout.control.appcontroller.CreateEventAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.Email;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.exception.myexception.*;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.File;

public class CreateEventGUIController1 {

    private ClubOwnerBean clubOwnerBean;

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

    private File img;

    @FXML
    private MenuClubOwnerGUIController1 menuController;

    public void setAll() {

        this.clubOwnerBean = LoggedClubOwnerBean.getInstance();
        this.menuController.setAll();
    }

    @FXML
    private void backToWelcomePage(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @FXML
    private void createEvent(ActionEvent actionEvent) {

        EventBean eventBean = new EventBean();

        try {
            eventBean.setEventDate(dateEvent.getValue());
            eventBean.setDuration((int) sliderTime.getValue());
            eventBean.setHours(textFieldHours.getText());
            eventBean.setMinutes(textFieldMinutes.getText());
            eventBean.setName(textFieldName.getText());
            eventBean.setIdClubOwner(this.clubOwnerBean.getId());
            eventBean.setDescription(textFieldDescription.getText());
            eventBean.setPrice(textFieldPrice.getText());
            eventBean.setImg(this.img);

            CreateEventAppController.createEvent(eventBean);

            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml");

        } catch (WrongInputTypeException | EmptyInputException | SystemException | BeforeDateException | WrongInputRangeException e) {
            e.printStackTrace();
            MyNotification.createNotification(e);
        }

        try {
            Email.sendEmail(clubOwnerBean.getEmail(), "Evento creato con successo!", "L'evento " + eventBean.getName() + " è stato creato con successo.");
        } catch (EmailException e) {
            MyNotification.createNotification(e);
        }
    }

    public void loadImage() {
        Stage stage = (Stage) textFieldName.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files", "*.png", "*.jpg", "*.jpeg"));
        img = fileChooser.showOpenDialog(stage).getAbsoluteFile();
    }
}
