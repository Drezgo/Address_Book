package com.example.lab_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditDialogController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOK;

    @FXML
    private TextField txtPIP;

    @FXML
    private TextField txtPhone;

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        txtPIP.setText(person.getPIP());
        txtPhone.setText(person.getPHONE());
    }

    @FXML
    void actionSave(ActionEvent event) {
        person.setPIP(txtPIP.getText());
        person.setPHONE(txtPhone.getText());
        actionClose(event);
    }

    @FXML
    void actionClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
}
