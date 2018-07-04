import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateStar {

    int countStar =0;
    Random random = new Random();
    List<Star> stars;

    public CreateStar() {
        this.stars = new ArrayList<>();
    }

    public List<Star> createStar() {
        if (this.countStar == 10) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.velocity.set(-this.random.nextInt(3) + 1, 0);
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
        return stars;
    }
}
