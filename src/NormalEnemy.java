import java.awt.*;

public class NormalEnemy extends Enemy {
    @Override
    public void run(Player player) {
        Vector2D velocity = player.position
                .subtract(this.position)
                .normalize()
                .multiply(1.5f);
        this.velocity.set(velocity);
        this.position.addUp(this.velocity);
        this.enemyAttack.run(this);
    }

    public void render(Graphics graphics) {
        super.render(graphics);
        ((NormalEnemyShoot) this.enemyAttack)
                .bulletEnemies
                .forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}
