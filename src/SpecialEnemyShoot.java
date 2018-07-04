import java.util.ArrayList;
import java.util.List;

public class SpecialEnemyShoot implements Attack<Enemy> {
    public List<BulletEnemy> bulletEnemies;
    private int count = 0;
    
    public SpecialEnemyShoot() {
        this.bulletEnemies = new ArrayList<>();
    }

    @Override
    public void run(Enemy enemy) {
        if (this.count == 30) {
            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 10.0) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
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
    }
}
