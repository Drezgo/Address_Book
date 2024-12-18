module com.example.lab_3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;


    opens com.example.lab_3 to javafx.fxml;
    exports com.example.lab_3;
}