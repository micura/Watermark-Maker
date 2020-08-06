package sample.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import sample.model.MainImage;
import sample.model.WatermarkImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Controller {
    @FXML
    private ImageView showMainImage;
    @FXML
    private ImageView showWaterMark;

    @FXML
    private void imageProcess(ActionEvent event) {
        MainImage mainImage = new MainImage();
        mainImage.setMainImageView(showMainImage);
        showMainImage.setImage(mainImage.uploadImage());
    }

    @FXML
    private void watermarkProcess(ActionEvent event) {
        WatermarkImage watermarkImage = new WatermarkImage();
        showWaterMark.setImage(watermarkImage.uploadImage());
    }

    @FXML
    private void saveButton(ActionEvent event) {
        Group merge = new Group(
                showMainImage,
                showWaterMark
        );

        File outputFile = new File("C:/Users/f/Desktop/Adam/formattedPicture.png");
        BufferedImage bImage = SwingFXUtils.fromFXImage(merge.snapshot(null, null), null);
        try {
            ImageIO.write(bImage, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
