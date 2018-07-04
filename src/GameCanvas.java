import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;

    Background background;

    CreateStar createStar;
    CreateEnemy createEnemy;

    public Player player = new Player();

    private Random random = new Random();


    public GameCanvas() {
        this.setSize(1024, 600);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.background = new Background();
        createStar = new CreateStar();
        createEnemy = new CreateEnemy();
        this.setupPlayer();
    }

    private void setupPlayer() {
        this.player.position.set(100, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);
        this.createStar.stars.forEach(star -> star.render(graphics));
        this.player.render(this.graphics);
        this.createEnemy.enemies.forEach(enemy -> enemy.render(this.graphics));

        this.repaint();
    }

    public void runAll() {
        this.createStar.createStar();
        this.createEnemy.createEnemy();
        this.createStar.stars.forEach(star -> star.run());
        this.createEnemy.enemies.forEach(enemy -> enemy.run(this.player));
        this.player.run();
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
