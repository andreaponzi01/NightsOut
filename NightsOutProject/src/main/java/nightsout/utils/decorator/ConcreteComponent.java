package nightsout.utils.decorator;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class ConcreteComponent implements VisualComponent {
    private Button button;

    public ConcreteComponent(){
        this.button = new Button();
        this.button.setMinWidth(50);
        this.button.setMinHeight(50);
        this.button.setAlignment(Pos.CENTER);
    }

    @Override
    public Button getButton() {
        return this.button;
    }
}
