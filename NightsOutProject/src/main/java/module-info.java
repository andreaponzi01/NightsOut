module NightsOutProject {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires json;
    requires java.mail;
    requires javafx.web;
    requires com.dlsc.gmapsfx;
    requires org.apache.httpcomponents.core5.httpcore5;
    requires java.sql;
    requires mysql.connector.java;
    requires org.controlsfx.controls;
    requires java.desktop;
    requires org.apache.commons.io;


    opens nightsout;
    opens nightsout.control.guicontroller.interface1 to javafx.fxml ;
    opens nightsout.control.guicontroller.interface2 to javafx.fxml ;
    opens nightsout.control.guicontroller.interface2.Item to javafx.fxml;
    opens nightsout.control.guicontroller.interface2.user to javafx.fxml;
    opens nightsout.control.guicontroller.interface2.clubowner to javafx.fxml;
    opens nightsout.control.guicontroller to javafx.fxml;
    opens nightsout.control.guicontroller.interface1.item to javafx.fxml;
    opens nightsout.control.guicontroller.interface1.user to javafx.fxml;
    opens nightsout.control.guicontroller.interface1.clubowner to javafx.fxml;

}