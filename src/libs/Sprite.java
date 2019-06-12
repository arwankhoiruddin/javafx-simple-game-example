package libs;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Sprite extends ImageView {

    int xpos;
    int ypos;

    public String imgPath;
    Configs config = new Configs();

    public void resize(double factor) {
        double newdim = this.getImage().getHeight() * factor;
        this.setImage(new Image(this.imgPath, newdim, newdim, true, false));
    }

    public void render(GraphicsContext gc, int x, int y) {
        gc.drawImage(this.getImage(), x, y);
        this.ypos = y;
        this.xpos = x;
    }

    public void moveLeft(GraphicsContext gc) {
        int x = (int) Math.round(this.xpos - 100);
        int y = (int) Math.round(this.ypos);
        this.render(gc, x, y);
    }

    public void moveRight(GraphicsContext gc) {
        int x = (int) Math.round(this.xpos + 100);
        int y = (int) Math.round(this.ypos);
        this.render(gc, x, y);
    }

    public void moveUp(GraphicsContext gc) {
        int x = (int) Math.round(this.xpos);
        int y = (int) Math.round(this.ypos - 100);
        this.render(gc, x, y);
    }

    public void moveDown(GraphicsContext gc) {
        int x = (int) Math.round(this.xpos);
        int y = (int) Math.round(this.ypos + 100);
        this.render(gc, x, y);
    }

}
