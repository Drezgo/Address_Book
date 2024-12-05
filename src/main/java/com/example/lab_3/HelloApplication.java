package com.example.lab_3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Адресна книга");
        HelloController controller = fxmlLoader.getController();
        controller.setNewStage(stage);
        stage.setScene(scene);
        stage.setMinWidth(500);
        stage.setMinHeight(600);
        stage.setResizable(true);
        stage.show();

//        testData();
    }

    public static void main(String[] args) {
        launch();
    }

//    private void testData() {
//        CollectionAddressBook addressBook = new CollectionAddressBook();
//        addressBook.fillTestData();
//        addressBook.print();
//    }
}