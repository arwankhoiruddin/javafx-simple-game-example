package core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import libs.Configs;
import libs.CoreFunc;

import java.util.ArrayList;

public class GameCore implements CoreFunc {

    GameBackground gameBackground = new GameBackground();

    Balloon balloon1 = new Balloon();
    Balloon balloon2 = new Balloon();
    Balloon balloon3 = new Balloon();

    Monkey monkey = new Monkey();

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

        monkey.resize(0.3);

        // initialize with monkey and background
        gameBackground.render(gc, 0, 0);
        monkey.render(gc, monkey.getxMonkey(), monkey.getyMonkey());
    }

    @Override
    public void animate(GraphicsContext gc, int time, ArrayList input) {
        yPos += time;
        int ground = Configs.appHeight - 250;
        if (yPos > ground)
            yPos = ground;

        gameBackground.render(gc, 0, 0);

        balloon1.render(gc, 100, yPos);
        balloon2.render(gc, 300, yPos);
        balloon3.render(gc, 500, yPos);

        if (input.contains("UP"))
            monkey.moveUp(gc);
        if (input.contains("DOWN"))
            monkey.moveDown(gc);
        if (input.contains("LEFT"))
            monkey.moveLeft(gc);
        if (input.contains("RIGHT"))
            monkey.moveRight(gc);

        monkey.render(gc, monkey.getxMonkey(), monkey.getyMonkey());

    }

    @Override
    public void mouseClick(MouseEvent e) {
        // mouse click event here
    }
}
