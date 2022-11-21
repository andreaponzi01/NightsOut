package nightsout.utils.decorator;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class ConcreteComponent implements VisualComponent {
    private Button button;

    public ConcreteComponent(Button myButton){
        this.button = myButton;
        this.button.setMinWidth(50);
        this.button.setMinHeight(50);
       // this.button.setStyle("-fx-background-color: white");
        //VBox.setMargin(this.button, new Insets(10, 0, 0, 0));
        this.button.setAlignment(Pos.CENTER);
    }

    @Override
    public Button getButton() {
        return this.button;
    }
}
