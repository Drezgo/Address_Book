package com.example.lab_3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CheckBoxesController {
    @FXML
    private Label lblTrueAnswer;
    @FXML
    private CheckBox ChB1;
    @FXML
    private CheckBox ChB2;
    @FXML
    private CheckBox ChB3;
    @FXML
    private CheckBox ChB4;
    @FXML
    private ChoiceBox choiceB;
    @FXML
    private Label lblAnwerChoice;
    @FXML
    private ComboBox comboBox;
    @FXML
    private Label lblAnwerCombo;
    @FXML
    private RadioButton radio24;
    @FXML
    private RadioButton radio27;
    @FXML
    private RadioButton radio21;
    @FXML
    private Label lblRadio;

    private ToggleGroup radiotoggleGroup;

    private Stage newStage;
    @FXML
    private HBox sceneHbox;


    @FXML
    public void initialize(){
        lblTrueAnswer.setText("");
        lblAnwerChoice.setText("");
        lblAnwerCombo.setText("");
        lblRadio.setText("");

        choiceB.getItems().addAll("Правильно","Неправильно");
        comboBox.getItems().addAll("Калина", "Гімн","Пес Патрон", "Байрактар");

        radiotoggleGroup = new ToggleGroup();
        this.radio24.setToggleGroup(radiotoggleGroup);
        this.radio21.setToggleGroup(radiotoggleGroup);
        this.radio27.setToggleGroup(radiotoggleGroup);

        toggleContextText = new ToggleGroup();
        this.first.setToggleGroup(toggleContextText);
        this.second.setToggleGroup(toggleContextText);
    }

    @FXML
    void checkBoxAnswer(ActionEvent event) {
        String answer = "Ваша відповідь:";
        if (ChB1.isSelected())
            answer += "\nБрянська область";
        if (ChB2.isSelected())
            answer += "\nМосковська область";
        if (ChB3.isSelected())
            answer += "\nКурська область";
        if (ChB4.isSelected())
            answer += "\nКалінінградська область";

        this.lblTrueAnswer.setText(answer);
    }

    @FXML
    void choiceBoxAnswer(ActionEvent event) {
        lblAnwerChoice.setText("Відповідь: " +choiceB.getValue().toString());
    }

    @FXML
    void comboBoxPressed(ActionEvent event) {
        lblAnwerCombo.setText("Відповідь: "+comboBox.getValue().toString());
    }

    @FXML
    void RadioAnswer(ActionEvent event) {
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.radio27))
            lblRadio.setText("Відповідь: 27");
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.radio21))
            lblRadio.setText("Відповідь: 21");
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.radio24))
            lblRadio.setText("Відповідь: 24");
    }


    @FXML
    void exitButton(ActionEvent event) {

        newStage = (Stage) sceneHbox.getScene().getWindow();
//        System.out.println("Success");
        newStage.close();
    }



    //TODO: Контекстне меню вікна
    @FXML
    private RadioMenuItem first;
    @FXML
    private TextField textField;
    @FXML
    private RadioMenuItem second;

    private ToggleGroup toggleContextText;

    @FXML
    void toggleContextText(ActionEvent event) {
        if (toggleContextText.getSelectedToggle().equals(this.first))
            textField.setText("RandomText");
        else if (toggleContextText.getSelectedToggle().equals(this.second))
            textField.setText(null);
    }





//    todo: ______7_лабораторна______

    @FXML
    void openDatePicker(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pickersANDplayers.fxml"));
        Parent root = loader.load();

        // Створення нового вікна (Stage)
        Stage newStage = new Stage();
        newStage.setTitle("Нове вікно");
        newStage.setScene(new Scene(root));
        newStage.show();
    }



}