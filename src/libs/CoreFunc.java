package libs;

import javafx.scene.canvas.GraphicsContext;

public interface CoreFunc {
    public void init(GraphicsContext gc);
    public void animate(GraphicsContext gc, int time);
}
