package nightsout.utils.decorator;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchPage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ConcreteDecoratorDelete2 extends Decorator {

    private EventBean2 eventBean;
    String toWrite;

    public ConcreteDecoratorDelete2(VisualComponent component, EventBean2 eventBean) {

        super(component);
        this.eventBean = eventBean;
    }
    protected void applyDecorationDelete(Button myButton) {

        myButton.setText(toWrite);
        myButton.setMinHeight(65);
        myButton.setMinWidth(125);
        Font font = Font.font("Arial", FontWeight.BOLD, 25);
        myButton.setFont(font);
        myButton.setStyle("-fx-background-color: #d00000;" + "-fx-background-radius: 28;" + "-fx-text-fill: white;");
        myButton.setOnAction((ActionEvent ae) -> deleteEvent(ae));
    }
    private void deleteEvent(ActionEvent ae) {

        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Event");
        alert.setHeaderText("You're about to delete the event!");
        alert.setContentText("Are you sure you want to delete the event?: ");
        if(alert.showAndWait().get() == ButtonType.OK) {
            try {
                Query.deleteEventById(eventBean.getIdEvent());
                FileUtils.delete(new File("eventImgs/" + eventBean.getName()));
                SwitchPage.replaceScene(ae,"/ClubOwnerPage2.fxml");
            } catch (SystemException e) {
                CreateNotification.createNotification(e);
            } catch (IOException e) {
                SystemException ex = new SystemException();
                ex.initCause(e);
                CreateNotification.createNotification(e);
            }
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
