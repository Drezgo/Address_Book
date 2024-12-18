package com.example.lab_3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.util.Duration;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class PickersController implements Initializable {
    @FXML
    private Label dateLabel;

    @FXML
    private DatePicker myDatePicker;

    @FXML
    private ColorPicker myColorPicker;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Slider mySlider;

    @FXML
    private Label sliderLabel;

    @FXML
    private ImageView imgView;


    @FXML
    private Button pauseButton;
    @FXML
    private MediaView mediaView;
    @FXML
    private Button playButton;
    @FXML
    private Button resetButton;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int score = (int) mySlider.getValue();
                sliderLabel.setText("Оцінка: " + score + " балів");
            }
        });

        file = new File("video.MP4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

    }


    @FXML
    void getDate(ActionEvent event) {
        LocalDate myDate = myDatePicker.getValue();
        System.out.println(myDate.toString());
        String dateFormatter = myDate.format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        dateLabel.setText(dateFormatter);
    }

    @FXML
    void changeColor(ActionEvent event) {
        Color myColor = myColorPicker.getValue();
        scenePane.setBackground(new Background(new BackgroundFill(myColor,null, null)));
    }

    @FXML
    void fileChooser(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Get Image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.png"));
        Stage stage = (Stage) scenePane.getScene().getWindow();

        File file = fileChooser.showOpenDialog(stage);

        if (file!=null) {
            URI uri = file.toURI();
            Image image = new Image(uri.toString());
            imgView.setImage(image);
        }
    }
    @FXML
    void playButton_method(ActionEvent event) {
        mediaPlayer.play();
    }
    @FXML
    void pauseButton_method(ActionEvent event) {
        mediaPlayer.pause();
    }
    @FXML
    void resetButton_method(ActionEvent event) {
        if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
            mediaPlayer.play();
        }
    }


}
