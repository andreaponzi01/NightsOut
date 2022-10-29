module NightsOutProject {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens NightsOut;
    opens NightsOut.control.guiController.interface1 to javafx.fxml ;

}