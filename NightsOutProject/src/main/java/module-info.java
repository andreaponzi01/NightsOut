module com.example.nightsoutproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.nightsoutproject to javafx.fxml;
    exports com.example.nightsoutproject;
}