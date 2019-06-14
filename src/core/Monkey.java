package core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import libs.Sprite;

public class Monkey extends Sprite {

    private int xMonkey = 600;
    private int yMonkey = 300;

    private int movingStep = 10;

    public int getxMonkey() {
        return xMonkey;
    }

    public int getyMonkey() {
        return yMonkey;
    }

    public Monkey() {
        super.imgPath = "/core/monkey.png";
        super.setImage(new Image(imgPath));
    }

    public void moveUp(GraphicsContext gc) {
        yMonkey -= movingStep;
        this.render(gc, xMonkey, yMonkey);
    }

    public void moveDown(GraphicsContext gc) {
        yMonkey += movingStep;
        this.render(gc, xMonkey, yMonkey);
    }

    public void moveLeft(GraphicsContext gc) {
        xMonkey -= movingStep;
        this.render(gc, xMonkey, yMonkey);
    }

    public void moveRight(GraphicsContext gc) {
        xMonkey += movingStep;
        this.render(gc, xMonkey, yMonkey);
    }

}
