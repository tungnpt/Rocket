import java.awt.*;

public class Background extends GameObject{

    public Background() {
        this.renderer = new BackgroundRenderer(Color.BLACK, 1024, 600);
        this.position = new Vector2D();
    }

    public void render(Graphics graphics) {
        super.render(graphics);
        //this.renderer.render(graphics, this.position);   //not necessary
    }

}
