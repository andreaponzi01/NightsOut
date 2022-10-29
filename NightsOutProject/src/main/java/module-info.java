module NightsOutProject {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens NightsOut;
    opens NightsOut.control.guiController.interface1 to javafx.fxml ;

}