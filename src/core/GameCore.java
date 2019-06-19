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
        gameBackground.render(gc, 0, 0);

        balloon1.moveDown(gc);
        balloon2.moveDown(gc);
        balloon3.moveDown(gc);

        if (input.contains("UP"))
            monkey.moveUp(gc);
        if (input.contains("DOWN"))
            monkey.moveDown(gc);
        if (input.contains("LEFT"))
            monkey.moveLeft(gc);
        if (input.contains("RIGHT"))
            monkey.moveRight(gc);

        if (monkey.collide(balloon1)) balloon1.visible = false;
        if (monkey.collide(balloon2)) balloon2.visible = false;
        if (monkey.collide(balloon3)) balloon3.visible = false;

        monkey.render(gc, monkey.getxMonkey(), monkey.getyMonkey());

    }

    @Override
    public void mouseClick(MouseEvent e) {
        // mouse click event here
    }
}
