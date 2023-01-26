package nightsout.control.guicontroller.interface1.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nightsout.control.appcontroller.CreateEventAppController;
import nightsout.utils.Session;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.*;
import nightsout.utils.switchpage.SwitchPage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateEventGUIController1 implements Initializable {

    private ClubOwnerBean1 clubOwnerBean1;
    private File img;
    @FXML
    private Slider sliderTime;
    @FXML
    private DatePicker dateEvent;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldPrice;
    @FXML
    private TextField textFieldHours;
    @FXML
    private TextField textFieldMinutes;
    @FXML
    private TextArea textFieldDescription;
    @FXML
    private ImageView imageViewProfile;

    private SwitchPage switchPage = new SwitchPage();

    private static final String CLUBOWNERPAGE = "/ClubOwnerPage1.fxml";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.clubOwnerBean1 = new ClubOwnerBean1(Session.getInstance().getClubOwner());
    }
    @FXML
    private void backToWelcomePage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, CLUBOWNERPAGE);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    private void createEvent(ActionEvent actionEvent) throws SystemException {

        EventBean1 eventBean1 = new EventBean1();
        CreateEventAppController controller;
        try {
            controller = new CreateEventAppController();
            eventBean1.setEventDate(dateEvent.getValue());
            eventBean1.setDuration((int) sliderTime.getValue());
            eventBean1.setTime(textFieldHours.getText(), textFieldMinutes.getText());
            eventBean1.setName(textFieldName.getText());
            eventBean1.setIdClubOwner(this.clubOwnerBean1.getId());
            eventBean1.setDescription(textFieldDescription.getText());
            eventBean1.setPrice(textFieldPrice.getText());
            eventBean1.setImg(this.img);
            controller.createEvent(eventBean1);
            switchPage.replaceScene(actionEvent,CLUBOWNERPAGE);
        } catch (WrongInputTypeException | EmptyInputException | SystemException | BeforeDateException |
                 WrongInputRangeException e) {
            ErrorDialog.getInstance().handleException(e);
        } catch (CreateEventEmailException e) {
            ErrorDialog.getInstance().handleException(e);
            switchPage.replaceScene(actionEvent,CLUBOWNERPAGE);
        }
    }

    @FXML
    private void loadImage() {
        Stage stage = (Stage) textFieldName.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files", "*.png", "*.jpg", "*.jpeg"));
        img = fileChooser.showOpenDialog(stage).getAbsoluteFile();
        imageViewProfile.setImage(new Image(img.toURI().toString()));
    }
}
