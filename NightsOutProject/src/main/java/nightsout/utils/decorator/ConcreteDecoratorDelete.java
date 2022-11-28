package nightsout.utils.decorator;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.db.Query;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConcreteDecoratorDelete extends Decorator {

    private ClubOwnerBean clubOwnerBean;
    private EventBean eventBean;

    String toWrite;

    public ConcreteDecoratorDelete(VisualComponent component, ClubOwnerBean clubOwnerBean, EventBean eventBean) {
        super(component);
        this.clubOwnerBean = clubOwnerBean;
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
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = Query.deleteEventById(eventBean.getIdEvent());
                preparedStatement.executeUpdate();
                ReplaceSceneDynamic1 replaceSceneDynamic1 = new ReplaceSceneDynamic1();
                replaceSceneDynamic1.switchAndSetScene(ae, "/ClubOwnerPage1.fxml", null, clubOwnerBean);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    private void backToWelcomePage(ActionEvent ae, String fxml, ClubOwnerBean clubOwnerBean) {
        try {
            ReplaceSceneDynamic1 replaceSceneDynamic1 = new ReplaceSceneDynamic1();
            replaceSceneDynamic1.switchAndSetScene(ae, fxml, null, clubOwnerBean);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */

    @Override
    public Button getButton() {
        Button myButton = super.getButton();
        this.toWrite = "Delete";
        this.applyDecorationDelete(myButton);
        return myButton;
    }

}
