
import edu.epromero.util.LienzoStd;

public class SpritePlayer extends Visible_Object {

    public int lives = 1;

    public SpritePlayer(double x, double y, double w, double h) {
        super(x, y, w, h);
    }

    @Override
    public void show() {
        LienzoStd.rectangulo(x_Spawn, y_Spawn, width, height);
    }

    @Override
    public void move(double ratechangeX, double ratechangeY) {
        super.setX_Spawn(ratechangeX);
        super.setY_Spawn(ratechangeY);
    }

}