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

    public void resize(int newSize) {
        // check first which one is larger between height and width
        Image tmp = new Image(this.imgPath);
        int size;
        if (tmp.getHeight() > tmp.getWidth())
            this.setImage(new Image(this.imgPath, newSize, 0, true, false));
        else
            this.setImage(new Image(this.imgPath, 0, newSize, true, false));
    }

    public void render(GraphicsContext gc, int x, int y) {
        gc.drawImage(this.getImage(), x, y);
        this.ypos = y;
        this.xpos = x;
    }

}
