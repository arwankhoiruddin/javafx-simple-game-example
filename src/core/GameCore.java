package core;

import javafx.scene.canvas.GraphicsContext;
import libs.CoreFunc;

public class GameCore implements CoreFunc {

    @Override
    public void init(GraphicsContext gc) {
        Balloon balloon1 = new Balloon();
        balloon1.resize(0.9);
        balloon1.render(gc, 100, 0);

        Balloon balloon2 = new Balloon();
        balloon2.resize(0.5);
        balloon2.render(gc, 100, 500);
    }
}
