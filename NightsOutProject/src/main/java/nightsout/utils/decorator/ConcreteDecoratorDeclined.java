package nightsout.utils.decorator;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ConcreteDecoratorDeclined extends Decorator {

    private String toWrite;

    public ConcreteDecoratorDeclined(Component component) { super(component); }

    protected void applyDecorationDeclined(Button myButton) {
        myButton.setText(toWrite);
        myButton.setMinHeight(65);
        myButton.setMinWidth(125);
        Font font = Font.font("Arial", FontWeight.BOLD, 25);
        myButton.setFont(font);
        myButton.setStyle("-fx-background-color: #d00000;" + "-fx-background-radius: 28;" + "-fx-text-fill: white;");
    }

    @Override
    public Button getButton() {
        Button myButton = super.getButton();
        this.toWrite = "Declined";
        this.applyDecorationDeclined(myButton);
        return myButton;
    }

}
