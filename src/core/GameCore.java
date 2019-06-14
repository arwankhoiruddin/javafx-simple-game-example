package core;

import javafx.scene.canvas.GraphicsContext;
import libs.Configs;
import libs.CoreFunc;

public class GameCore implements CoreFunc {

    GameBackground gameBackground = new GameBackground();

    Balloon balloon1 = new Balloon();
    Balloon balloon2 = new Balloon();
    Balloon balloon3 = new Balloon();

    int yPos = 0;

    @Override
    public void init(GraphicsContext gc) {
        // resize the background to fit the app height
        gameBackground.resize(Configs.appHeight);

        // make some balloon with the same size
        double factor = 0.2;
        balloon1.resize(factor);
        balloon2.resize(factor);
        balloon3.resize(factor);
    }

    @Override
    public void animate(GraphicsContext gc, int time) {
        yPos += time;
        int ground = Configs.appHeight - 250;
        if (yPos > ground)
            yPos = ground;

        gameBackground.render(gc, 0, 0);
        balloon1.render(gc, 100, yPos);
        balloon2.render(gc, 300, yPos);
        balloon3.render(gc, 500, yPos);
    }
}
