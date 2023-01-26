package nightsout.utils.decorator;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.db.Query;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.AlertNotFoundException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchPage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class ConcreteDecoratorDelete2 extends Decorator {

    private EventBean2 eventBean;
    private SwitchPage switchPage = new SwitchPage();
    private String toWrite;

    protected void applyDecorationDelete(Button myButton) {

        myButton.setText(toWrite);
        myButton.setOnAction(this::deleteEvent);
        Font font = Font.font("Arial", FontWeight.BOLD, 25);
        myButton.setMinWidth(125);
        myButton.setStyle("-fx-background-color: #d00000;" + "-fx-background-radius: 28;" + "-fx-text-fill: white;");
        myButton.setFont(font);
        myButton.setMinHeight(65);
    }

    public ConcreteDecoratorDelete2(Component component, EventBean2 eventBean) {
        super(component);
        this.eventBean = eventBean;
    }

    private void deleteEvent(ActionEvent ae) {

        Optional<ButtonType> optional;
        Query query;
        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Event");
        alert.setHeaderText("You're about to delete the event!");
        alert.setContentText("Are you sure you want to delete the event?: ");
        try {
            optional = alert.showAndWait();
            if (optional.isEmpty()) {
                throw new AlertNotFoundException();
            }
            ButtonType value = optional.get();
            if (value == ButtonType.OK) {
                query = new Query();
                query.deleteEventById(eventBean.getIdEvent());
                FileUtils.delete(new File("eventImgs/" + eventBean.getName() + "pic.png"));
                switchPage.replaceScene(ae, "/ClubOwnerPage2.fxml");
            }
        } catch (SystemException | AlertNotFoundException e) {
            ErrorDialog.getInstance().handleException(e);
        } catch (IOException e) {
            SystemException ex = new SystemException();
            ex.initCause(e);
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @Override
    public Button getButton() {
        Button myButton = super.getButton();
        this.toWrite = "Delete";
        this.applyDecorationDelete(myButton);
        return myButton;
    }

}
