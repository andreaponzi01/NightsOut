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
    opens nightsout.control to javafx.fxml;

}