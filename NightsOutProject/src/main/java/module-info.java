module NightsOutProject {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires org.controlsfx.controls;

    opens nightsout;
    opens nightsout.control.guicontroller.interface1 to javafx.fxml ;

}