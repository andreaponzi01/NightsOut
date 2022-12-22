package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nightsout.control.appcontroller.CreateEventAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.Email;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.LoggedClubOwnerBean1;
import nightsout.utils.exception.myexception.*;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.File;

public class CreateEventGUIController1 {

    private ClubOwnerBean1 clubOwnerBean1;

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
    TextArea textFieldDescription;
    @FXML
    ImageView imageViewProfile;

    private File img;

    public void setAll() {

        this.clubOwnerBean1 = LoggedClubOwnerBean1.getInstance();
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

        EventBean1 eventBean1 = new EventBean1();

        try {
            eventBean1.setEventDate(dateEvent.getValue());
            eventBean1.setDuration((int) sliderTime.getValue());
            eventBean1.setTime(textFieldHours.getText(), textFieldMinutes.getText());
            eventBean1.setName(textFieldName.getText());
            eventBean1.setIdClubOwner(this.clubOwnerBean1.getId());
            eventBean1.setDescription(textFieldDescription.getText());
            eventBean1.setPrice(textFieldPrice.getText());
            eventBean1.setImg(this.img);

            CreateEventAppController.createEvent(eventBean1);

            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml");

        } catch (WrongInputTypeException | EmptyInputException | SystemException | BeforeDateException |
                 WrongInputRangeException e) {
            MyNotification.createNotification(e);
        }

        try {
            Email.sendEmail(clubOwnerBean1.getEmail(), "Evento creato con successo!", "L'evento " + eventBean1.getName() + " è stato creato con successo.");
        } catch (EmailException e) {
            MyNotification.createNotification(e);
        }
    }

    public void loadImage() {
        Stage stage = (Stage) textFieldName.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files", "*.png", "*.jpg", "*.jpeg"));
        img = fileChooser.showOpenDialog(stage).getAbsoluteFile();
        this.imageViewProfile.setImage(new Image(img.toURI().toString()));
    }
}
