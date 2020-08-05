package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;

import java.io.File;


public class Controller {
    @FXML
    private ImageView showMainImage;
    @FXML
    private ImageView showWaterMark;

    //Set extension filter for images
    FileChooser.ExtensionFilter imageFilter
            = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");

    @FXML
    private void uploadImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        File imageFile = fileChooser.showOpenDialog(null);
        if (imageFile != null) {
            Image mainImage = new Image(imageFile.toURI().toString());
            showMainImage.setImage(mainImage);
        }
    }

    @FXML
    private void uploadWatermark(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        File imageFile = fileChooser.showOpenDialog(null);
        if (imageFile != null) {
            Image waterMark = new Image(imageFile.toURI().toString());
            showWaterMark.setImage(waterMark);
        }

    }

    @FXML
    private void saveButton(ActionEvent event) {
        System.out.println("Megnyomtad a mentés gombot");
    }
}
