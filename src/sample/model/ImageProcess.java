package sample.model;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;

public class ImageProcess implements ImageProcessAdapter {
    //Set extension filter for images
    FileChooser.ExtensionFilter imageFilter
            = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");

    @Override
    public Image uploadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(imageFilter);
        File imageFile = fileChooser.showOpenDialog(null);
        if (imageFile != null) {
            Image mainImage = new Image(imageFile.toURI().toString());
            return mainImage;
        } else {
            return null;
        }
    }
}