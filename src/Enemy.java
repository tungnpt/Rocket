import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Enemy extends GameObject {

    public BufferedImage image;
    public Vector2D velocity;
    protected int count = 0;

    public Attack enemyAttack;

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.enemyAttack = new NormalEnemyShoot();
    }

    abstract public void run(Player player);

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, 20, 20, null);
    }
}
