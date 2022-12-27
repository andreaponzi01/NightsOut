package nightsout.utils.decorator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nightsout.control.appcontroller.RequestAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.LoggedUserBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchPage.SwitchAndSetPage1;

public class ConcreteDecoratorSendRequest1 extends Decorator {

    private UserBean1 userBean;
    private EventBean1 eventBean;

    String toWrite;

    public ConcreteDecoratorSendRequest1(VisualComponent component, EventBean1 eventBean) {
        super(component);
        this.userBean = LoggedUserBean1.getInstance();
        this.eventBean = eventBean;
    }

    protected void applyDecorationSendRequest(Button myButton) {
        myButton.setText(toWrite);
        myButton.setMinHeight(65);
        myButton.setMinWidth(125);
        Font font = Font.font("Arial", FontWeight.BOLD, 25);
        myButton.setFont(font);
        myButton.setStyle("-fx-background-color: #b3b3ff;" + "-fx-background-radius: 28;" + "-fx-text-fill: white;");
        myButton.setOnAction((ActionEvent ae) -> sendRequest(ae));
    }

    private void sendRequest(ActionEvent actionEvent){
        try {
            RequestAppController.sendRequest(userBean, eventBean);
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            replacer.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean);
        } catch (SystemException e){
            MyNotification.createNotification(e);
        }
    }

    @Override
    public Button getButton() {
        Button myButton = super.getButton();
        this.toWrite = "Send Request";
        this.applyDecorationSendRequest(myButton);
        return myButton;
    }

}
