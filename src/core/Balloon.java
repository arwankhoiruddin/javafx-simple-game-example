package core;

import javafx.scene.canvas.GraphicsContext;
import libs.Configs;
import libs.Sprite;
import javafx.scene.image.Image;

import java.util.Random;


public class Balloon extends Sprite {

    public int yPos = 0;
    public int xPos;

    public boolean visible = true;

    private int movingStep = 1 + new Random().nextInt(5);

    public Balloon()  {
        super.imgPath = "/core/balloon.png";
        super.setImage(new Image(imgPath));
        xPos = new Random().nextInt(Configs.appWidth);
    }

    public void moveDown(GraphicsContext gc) {
        yPos += movingStep;
        if (yPos == Configs.appHeight)
            yPos = 0;
        if (this.visible)
            this.render(gc, xPos, yPos);
    }

}
