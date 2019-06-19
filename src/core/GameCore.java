package core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import libs.Configs;
import libs.CoreFunc;
import libs.GameText;

import java.util.ArrayList;

public class GameCore implements CoreFunc {

    GameBackground gameBackground = new GameBackground();

    GameText result = new GameText(Color.RED, Color.BLACK);

    ArrayList<Balloon> balloons = new ArrayList<>();

    Monkey monkey = new Monkey();

    int numBalloon = 10;

    int monkeyScore = 0;
    String score = "Score: ";

    @Override
    public void init(GraphicsContext gc) {
        // resize the background to fit the app height
        gameBackground.resize(Configs.appHeight);

        // make some balloon with the same size
        double factor = 0.2;
        for (int i=0; i<numBalloon; i++) {
            Balloon balloon = new Balloon();
            balloon.resize(factor);
            balloons.add(balloon);
        }

        monkey.resize(0.3);

        // initialize with monkey and background
        gameBackground.render(gc, 0, 0);
        monkey.render(gc, monkey.getxMonkey(), monkey.getyMonkey());
        result.setText(gc, score, 10, 100, 100);
    }

    @Override
    public void animate(GraphicsContext gc, int time, ArrayList input) {
        gameBackground.render(gc, 0, 0);

        for (int i=0; i<balloons.size(); i++) {
            balloons.get(i).moveDown(gc);
            if (monkey.collide(balloons.get(i))) {
                balloons.remove(i);
                monkeyScore++;

            }
        }

        if (input.contains("UP"))
            monkey.moveUp(gc);
        if (input.contains("DOWN"))
            monkey.moveDown(gc);
        if (input.contains("LEFT"))
            monkey.moveLeft(gc);
        if (input.contains("RIGHT"))
            monkey.moveRight(gc);

        monkey.render(gc, monkey.getxMonkey(), monkey.getyMonkey());

        if (monkeyScore == 10) {
            score = "Yay, done!";
        } else
            score = "Score: " + monkeyScore;

        result.setText(gc, score, 50, 100, 100);
    }

    @Override
    public void mouseClick(MouseEvent e) {
        // mouse click event here
    }
}
