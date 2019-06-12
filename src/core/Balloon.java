package core;

import libs.Sprite;
import javafx.scene.image.Image;


public class Balloon extends Sprite {

    public Balloon()  {
        super.imgPath = "/core/balloon.jpeg";
        super.setImage(new Image(imgPath));

    }

}
