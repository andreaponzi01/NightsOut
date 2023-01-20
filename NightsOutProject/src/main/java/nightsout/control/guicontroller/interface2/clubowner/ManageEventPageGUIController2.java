package nightsout.control.guicontroller.interface2.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nightsout.control.appcontroller.CreateEventAppController;
import nightsout.control.guicontroller.interface2.item.EventItemGUIController2;
import nightsout.utils.Session;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.engineering.CreatedEventsEngineering;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.BeforeDateException;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongInputTypeException;
import nightsout.utils.observer.Observer;
import nightsout.utils.scene.SwitchPage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManageEventPageGUIController2 implements Initializable, Observer {

    @FXML
    private Slider sliderTime;
    @FXML
    private TextField textFieldEventDate;
    @FXML
    private TextField textFieldEventTime;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldPrice;
    @FXML
    private TextArea textFieldDescription;
    @FXML
    private ImageView imageViewProfile;
    @FXML
    private ListView listViewCreatedEvents;
    private File img;
    private SwitchPage switchPage = new SwitchPage();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CreatedEventsEngineering createdEventsEngineering = new CreatedEventsEngineering();
        try {
            createdEventsEngineering.createdEvents(this, Session.getInstance().getClubOwner().getId());
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    public void createEvent(ActionEvent actionEvent) {

        EventBean2 eventBean = new EventBean2();
        CreateEventAppController controller;
        try {
            controller = new CreateEventAppController();
            eventBean.setEventDate(textFieldEventDate.getText());
            eventBean.setDuration((int) sliderTime.getValue());
            eventBean.setTime(textFieldEventTime.getText());
            eventBean.setName(textFieldName.getText());
            eventBean.setIdClubOwner(Session.getInstance().getClubOwner().getId());
            eventBean.setDescription(textFieldDescription.getText());
            eventBean.setPrice(textFieldPrice.getText());
            eventBean.setImg(this.img);
            controller.createEvent(eventBean);

            switchPage.replaceScene(actionEvent,"/ManageEventPage2.fxml");

        } catch (WrongInputTypeException | EmptyInputException | SystemException | BeforeDateException e) {
            ErrorDialog.getInstance().handleException(e);
        }


    }

    public void loadImage() {

        Stage stage = (Stage) textFieldName.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files", "*.png", "*.jpg", "*.jpeg"));
        img = fileChooser.showOpenDialog(stage).getAbsoluteFile();
        imageViewProfile.setImage(new Image(img.toURI().toString()));
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem2.fxml")).openStream());
                EventItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(new EventBean2(eBean));
                this.listViewCreatedEvents.getItems().add(pane);
            }
            catch (IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }
}
