public class NormalEnemy extends Enemy {
    @Override
    public void run(Player player) {
        Vector2D velocity = player.position
                .subtract(this.position)
                .normalize()
                .multiply(1.5f);
        this.velocity.set(velocity);
        this.position.addUp(this.velocity);
        if (this.count == 15) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.position.set(this.position);
            bulletEnemy.velocity.set(
                    (this.velocity.copy().multiply(2f))
            );
            this.bulletEnemies.add(bulletEnemy);
            this.count = 0;
        } else {
            this.count += 1;
        }

        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }
}
