import edu.epromero.util.LienzoStd;
public class Basic_Platform extends Visible_Object {
    public Basic_Platform(double x, double y, double w, double h) {
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