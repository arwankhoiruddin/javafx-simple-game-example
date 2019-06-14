package core;

import javafx.scene.image.Image;
import libs.Sprite;

public class GameBackground extends Sprite {

    public GameBackground() {
        super.imgPath = "/core/background.jpg";
        super.setImage(new Image(imgPath));
    }

}
