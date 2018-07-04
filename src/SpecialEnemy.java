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
        this.bulletEnemies = new ArrayList<>();
    }

    @Override
    public void run(Player player) {
        this.position.addUp(this.velocity);
        if (this.count == 30) {
            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 10.0) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(this.position);
                bulletEnemy.velocity.set(
                        (new Vector2D(3.0f, 0.0f)).rotate(angle)
                );
                this.bulletEnemies.add(bulletEnemy);
            }
            this.count = 0;
        } else {
            this.count += 1;
        }

        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
        this.backtoScreen();
    }
    private void backtoScreen() {
        if (this.position.x < 0) this.position.set(1024, this.random.nextInt(600));

        if (this.position.x > 1024) this.position.set(0, this.random.nextInt(600));

        if (this.position.y < 0) this.position.set(this.random.nextInt(1024), 600);

        if (this.position.y > 600) this.position.set(this.random.nextInt(1024), 0);
    }
}
