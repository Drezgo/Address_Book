package com.example.lab_3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnRed;

    @FXML
    private Button btnDel;

    @FXML
    private TextField searchField;
    @FXML
    private Button btnFind;

    @FXML
    private TableColumn<Person, String> columnPIP;
    @FXML
    private TableColumn<Person, String> columnPhone;
    @FXML
    private TableView<Person> tableAddressBook;

    private Stage newStage;
    private Stage editDialogStage;
    private Parent root;
    private EditDialogController editDialogController;
    Scene scene;

    private FXMLLoader fxmlLoader = new FXMLLoader();

    private CollectionAddressBook addressBookImpl = new CollectionAddressBook();

    ObservableList<Person> filteredList = FXCollections.observableArrayList();

    @FXML
    void deleteAlert(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Видалення");

        alert.setContentText("Ви впевненні, що хочете видалити запис? ");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {

        }
    }

    public void setNewStage(Stage newStage) {
        this.newStage = newStage;
    }

    @FXML
    void showDialog() throws IOException {
        editDialogStage = new Stage();
        editDialogStage.setScene(scene);
        editDialogStage.setTitle("Вікно редагування");

        editDialogStage.setResizable(false);
        editDialogStage.initModality(Modality.WINDOW_MODAL);
        editDialogStage.initOwner(newStage);

        editDialogStage.showAndWait();

//            Stage stage = new Stage();//???
//            Scene scene = new Scene(fxmlLoaders.load(), 400, 100);
//            stage.setScene(scene);
//
//            stage.setTitle("Додавання");
//            stage.setMinWidth(400);
//            stage.setMinHeight(100);
//            stage.setResizable(false);
//            stage.initModality(Modality.WINDOW_MODAL);
//            stage.initOwner(btnAdd.getScene().getWindow());
//            stage.show();
    }
    @FXML
    void openWindow(ActionEvent event) throws IOException, URISyntaxException {
        Button clickedButton = (Button) event.getSource();
        switch (clickedButton.getId()){
            case "btnAdd":
                editDialogController.setPerson(new Person());
                showDialog();
                addressBookImpl.add(editDialogController.getPerson());
                break;
            case "btnEdit":
                Person selectedPerson = tableAddressBook.getSelectionModel().getSelectedItem();
                if (selectedPerson != null) {
                    editDialogController.setPerson(selectedPerson);
                    showDialog();
                    tableAddressBook.refresh();
                } else {
                    showAlert("Помилка", "Виберіть запис для редагування!");
                }
                break;
            case "btnDel":
                addressBookImpl.delete((Person)  tableAddressBook.getSelectionModel().getSelectedItem());
                filteredList.remove((Person)  tableAddressBook.getSelectionModel().getSelectedItem());
                break;
        }
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void fillText(ActionEvent event) {

    }

    @FXML
    void showSearch(ActionEvent event) {
        String searchText = searchField.getText().toLowerCase();
        filteredList = FXCollections.observableArrayList();
        for (Person person : addressBookImpl.getPersonList()) {
            if (person.getPIP().toLowerCase().contains(searchText) || person.getPHONE().contains(searchText)) {
                filteredList.add(person);
            }
        }
        tableAddressBook.setItems(filteredList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            fxmlLoader.setLocation(HelloController.class.getResource("secondWindow.fxml"));
            root = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
            scene = new Scene(root);
        } catch (IOException e){
            e.printStackTrace();
        }

        columnPIP.setCellValueFactory(new PropertyValueFactory<Person, String>("PIP"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("PHONE"));

//        addressBookImpl.fillTestData();
        tableAddressBook.setItems(addressBookImpl.getPersonList());
    }
}