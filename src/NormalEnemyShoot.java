import java.util.ArrayList;
import java.util.List;

public class NormalEnemyShoot implements Attack<Enemy> {
    public List<BulletEnemy> bulletEnemies;
    private int count = 0;

    public NormalEnemyShoot() {
        this.bulletEnemies = new ArrayList<>();
    }

    @Override
    public void run(Enemy enemy) {
        if (this.count == 15) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.position.set(enemy.position);
            bulletEnemy.velocity.set(
                    (enemy.velocity.copy().multiply(2f))
            );
            this.bulletEnemies.add(bulletEnemy);
            this.count = 0;
        } else {
            this.count += 1;
        }
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }
}
