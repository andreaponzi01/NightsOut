package nightsout.utils.decorator;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

public class ConcreteDecoratorDelete extends Decorator {

    private EventBean eventBean;

    String toWrite;

    public ConcreteDecoratorDelete(VisualComponent component, EventBean eventBean) {

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
        myButton.setOnAction((ActionEvent ae) -> {
            try {
                deleteEvent(ae);
            } catch (SystemException e) {
                MyNotification.createNotification(e);
            }
        });
    }

    private void deleteEvent(ActionEvent ae) throws SystemException {

        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Event");
        alert.setHeaderText("You're about to delete the event!");
        alert.setContentText("Are you sure you want to delete the event?: ");

        if(alert.showAndWait().get() == ButtonType.OK) {
            try {
                Query.deleteEventById(eventBean.getIdEvent());
                ReplaceSceneDynamic1 replaceSceneDynamic1 = new ReplaceSceneDynamic1();
                replaceSceneDynamic1.switchAndSetScene(ae, "/ClubOwnerPage1.fxml");
            } catch (SystemException e) {
                MyNotification.createNotification(e);
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
