package nightsout.utils.factory;

import javafx.scene.control.Alert;

public class MyAlert implements MyDialogBox {
    @Override
    public void useMyDialogBox(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning!");
        alert.setHeaderText(e.getMessage());
        alert.showAndWait();
    }
}
