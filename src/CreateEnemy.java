import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateEnemy {
    int countEnemy =0;
    Random random = new Random();
    List<Enemy> enemies;

    public CreateEnemy() {
        this.enemies = new ArrayList<>();
    }

    public List<Enemy> createEnemy() {
        if (this.countEnemy == 100) {
            Enemy e;
            if(enemies.size()% 20 == 19){
                e = new SpecialEnemy();
            }else{
                e = new NormalEnemy();
            }
            e.position.set(random.nextInt(1025), random.nextInt(601));
            e.image = this.loadImage("resources/images/circle.png");
            enemies.add(e);
            this.countEnemy = 0;
        } else {
            this.countEnemy += 1;
        }
        return enemies;
    }
    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
