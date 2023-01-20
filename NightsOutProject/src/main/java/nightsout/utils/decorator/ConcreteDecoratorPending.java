package nightsout.utils.decorator;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ConcreteDecoratorPending extends Decorator {

    private String toWrite;

    public ConcreteDecoratorPending(Component component) { super(component); }

    @Override
    public Button getButton() {

        Button myButton = super.getButton();
        this.toWrite = "Pending";
        this.applyDecorationPending(myButton);
        return myButton;
    }

    protected void applyDecorationPending(Button myButton) {

        myButton.setText(toWrite);
        myButton.setMinHeight(65);
        myButton.setMinWidth(125);
        Font font = Font.font("Arial", FontWeight.BOLD, 25);
        myButton.setFont(font);
        myButton.setStyle("-fx-background-color: #ffeecc;" + "-fx-background-radius: 28;" + "-fx-text-fill: #200f54;");
    }

}
