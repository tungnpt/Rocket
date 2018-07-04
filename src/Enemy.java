import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Enemy extends GameObject{

    //public Vector2D position;
    public BufferedImage image;
    public Vector2D velocity;
    protected List<BulletEnemy> bulletEnemies;
    protected int count = 0;

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.bulletEnemies = new ArrayList<>();
    }

    abstract public void run(Player player);

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y, 20, 20, null);
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}
