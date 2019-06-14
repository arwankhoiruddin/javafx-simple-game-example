# What this repository is about?

This repository is a simple framework for game development in JavaFX, used in Object Oriented Programming Lab at Universiti Teknologi PETRONAS, Malaysia

# Can I use it for free?

Yes

# Who develop this framework?

This framework is developed and maintained by Arwan Ahmad Khoiruddin

# Can I participate to develop the framework?

Yes

# How I use this framework?

## Start your new Game

This repository contains an example of simple "game" in JavaFX. If you want to start the new game, just remove all the files inside `core` package/folder and follow the following instructions.

## Game Configuration

Some configuration of the game can be found in `Config.java` inside `libs` folder. You can modify the configurations such as:

* Application title (`appTitle`)
* Application width (`appWidth`)
* Application height (`appHeight`)

## Creating Sprite

To create sprite, you can extends your class with `Sprite` class in `libs` folder. See example below:

```
package core;

import libs.Sprite;
import javafx.scene.image.Image;

public class Balloon extends Sprite {

    public Balloon()  {
        super.imgPath = "/core/balloon.jpeg";
        super.setImage(new Image(imgPath));
    }

}

```

To create other Sprite object, you must extend your new class to Sprite, copy the lines inside the Balloon constructor and modify the `imgPath` to point to your Sprite image.

Say you want to create `Monkey.java`. Your class will be like this

```
package core;

import libs.Sprite;
import javafx.scene.image.Image;

public class Monkey extends Sprite {

    public Monkey()  {
        super.imgPath = "/core/monkey.png";
        super.setImage(new Image(imgPath));
    }

}
```

## Main place to code your game

The main place to code your game is in `GameCore` class. You may notice that the `GameCore` class implements `CoreFunc`, which will ensure that `GameCore` contains all functions needed to run the game.

To start with your project, create `GameCore` class inside `core` package. Your code should be like following

```
package core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import libs.Configs;
import libs.CoreFunc;

import java.util.ArrayList;

public class GameCore implements CoreFunc {

   @Override
    public void init(GraphicsContext gc) {
    }

    @Override
    public void animate(GraphicsContext gc, int time, ArrayList input) {
 
    }

    @Override
    public void mouseClick(MouseEvent e) {
    }
}

```

See simple example below to see how to create your game in JavaFX

```
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
```

Good luck with your game project in JavaFX