module com.example.lab_3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;


    opens com.example.lab_3 to javafx.fxml;
    exports com.example.lab_3;
}