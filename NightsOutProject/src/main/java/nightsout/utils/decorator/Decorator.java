package nightsout.utils.decorator;

import javafx.scene.control.Button;

public abstract class Decorator implements VisualComponent {

    private VisualComponent component;

    protected Decorator(VisualComponent component){
        this.component = component; /* = myConcreteComponent */
    }

    @Override
    public Button getButton(){
        return this.component.getButton();
    }

}
