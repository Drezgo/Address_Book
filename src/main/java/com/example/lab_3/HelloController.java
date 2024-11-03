package com.example.lab_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloController {
    @FXML
    void deleteAlert(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Видалення");

        alert.setContentText("Ви впевненні, що хочете видалити запис? ");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {

        }
    }


    @FXML
    private Button btnAdd;

    @FXML
    private Button btnRed;

    @FXML
    private Button btnDel;

    @FXML
    private TableColumn<Person, String> columnPIP;

    @FXML
    private TableColumn<Person, String> columnPhone;
    @FXML
    private TableView<Person> tableAddressBook;

    private CollectionAddressBook addressBookImpl = new CollectionAddressBook();



    @FXML
    public void  initialize() {
        columnPIP.setCellValueFactory(new PropertyValueFactory<Person, String>("PIP"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("PHONE"));

        addressBookImpl.fillTestData();
        tableAddressBook.setItems(addressBookImpl.getPersonList());
    }

    @FXML
    void showDialog(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("secondWindow.fxml"));

            Stage stage = new Stage();//???
            Scene scene = new Scene(fxmlLoader.load(), 400, 100);
            stage.setScene(scene);

            stage.setTitle("Додавання");
            stage.setMinWidth(400);
            stage.setMinHeight(100);
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnAdd.getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void fillText(ActionEvent event) {

    }

    @FXML
    void showRedag(ActionEvent event) {

    }

    @FXML
    void showSearch(ActionEvent event) {

    }
}