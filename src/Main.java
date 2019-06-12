import core.GameCore;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import libs.Configs;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(Configs.appTitle);

        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        Canvas canvas = new Canvas(Configs.appHeight, Configs.appWidth);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        new GameCore().init(gc);

        primaryStage.show();
    }
}
