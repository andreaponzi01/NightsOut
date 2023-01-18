package nightsout.utils.decorator;

import javafx.scene.control.Button;

public abstract class Decorator implements Component {

    private Component component;

    protected Decorator(Component component){
        this.component = component; /* = myConcreteComponent */
    }

    @Override
    public Button getButton(){
        return this.component.getButton();
    }

}
