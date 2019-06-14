# What this repository is about?

This repository is a simple framework for game development in JavaFX, used in Object Oriented Programming Lab at Universiti Teknologi PETRONAS, Malaysia

# Can I use it for free?

Yes

# Who develop this framework?

This framework is developed and maintained by Arwan Ahmad Khoiruddin

# Can I participate to develop the framework?

Yes

# How I use this framework?

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

## Main place to code your game

The main place to code your game is in `GameCore` class. You may notice that the `GameCore` class implements `CoreFunc`, which will ensure that `GameCore` will contain all functions needed to run the game.

See simple example below:

```
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


```