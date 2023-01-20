package nightsout.utils.decorator;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ConcreteDecoratorAccepted extends Decorator {

    private  String toWrite;

    protected void applyDecorationAccepted(Button myButton) {
        myButton.setMinHeight(65);
        myButton.setMinWidth(125);
        myButton.setText(toWrite);
        Font font = Font.font("Arial", FontWeight.BOLD, 25);
        myButton.setFont(font);
        myButton.setStyle("-fx-background-color: #32a844;" + "-fx-background-radius: 28;" + "-fx-text-fill: white;");
    }

    @Override
    public Button getButton() {
        this.toWrite = "Accepted";
        Button myButton = super.getButton();
        this.applyDecorationAccepted(myButton);
        return myButton;
    }

    public ConcreteDecoratorAccepted(Component component) { super(component); }

}
