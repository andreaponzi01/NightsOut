package nightsout.utils.decorator;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ConcreteDecoratorPending extends Decorator {

    String toWrite;

    public ConcreteDecoratorPending(VisualComponent component) { super(component); }

    protected void applyDecorationOne(Button myButton) {

        myButton.setText(toWrite);
        myButton.setMinHeight(65);
        myButton.setMinWidth(125);
        Font font = Font.font("Arial", FontWeight.BOLD, 25);
        myButton.setFont(font);
        myButton.setStyle("-fx-background-color: #ffeecc;" + "-fx-background-radius: 28;" + "-fx-text-fill: #200f54;");
    }


    @Override
    public Button getButton() {

        Button myButton = super.getButton();
        this.toWrite = "Pending";
        this.applyDecorationOne(myButton);
        return myButton;
    }

}
