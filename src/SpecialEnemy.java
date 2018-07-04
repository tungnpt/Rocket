import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class SpecialEnemy extends Enemy {

    private Random random = new Random();
    private int direction = random.nextInt(2);

    public SpecialEnemy() {
        this.position = new Vector2D();
        if (direction == 1) {
            this.velocity = new Vector2D(1.5f, 0);
        } else {
            this.velocity = new Vector2D(0, 1.5f);
        }
        this.enemyAttack = new SpecialEnemyShoot();
    }

    @Override
    public void run(Player player) {
        this.position.addUp(this.velocity);
        this.enemyAttack.run(this);
        this.backtoScreen();
    }

    private void backtoScreen() {
        if (this.position.x < 0) this.position.set(1024, this.random.nextInt(600));

        if (this.position.x > 1024) this.position.set(0, this.random.nextInt(600));

        if (this.position.y < 0) this.position.set(this.random.nextInt(1024), 600);

        if (this.position.y > 600) this.position.set(this.random.nextInt(1024), 0);
    }

    public void render(Graphics graphics) {
        super.render(graphics);
        ((SpecialEnemyShoot) this.enemyAttack)
                .bulletEnemies
                .forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}
