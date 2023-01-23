package nightsout.utils.decorator;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.engineering.EventPageEngineering;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchPage;

public class ConcreteDecoratorDelete1 extends Decorator {

    private EventBean1 eventBean;
    private SwitchPage switchPage = new SwitchPage();
    private String toWrite;

    public ConcreteDecoratorDelete1(Component component, EventBean1 eventBean) {

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

        EventPageEngineering engineering;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Event");
        alert.setHeaderText("You're about to delete the event!");
        alert.setContentText("Are you sure you want to delete the event?: ");
        if(alert.showAndWait().get() == ButtonType.OK) {
            try {
                engineering = new EventPageEngineering();
                engineering.deleteEvent(eventBean);
                switchPage.replaceScene(ae,"/ClubOwnerPage1.fxml");
            } catch (SystemException e) {
                ErrorDialog.getInstance().handleException(e);
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
