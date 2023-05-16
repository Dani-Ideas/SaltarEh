import edu.epromero.util.LienzoStd;
public class Platform_move extends Basic_Platform {
    static int direccion=5;
    public Platform_move(double x, double y, double w, double h) {
        super(x, y, w, h);
    }
    @Override
    public void move(double ratechangeX, double ratechangeY) {
        super.delete(ratechangeY);
        if (ratechangeX-super.width<= LienzoStd.pideLimiteXMin())
            direccion=5;
         if (ratechangeX+super.width>=LienzoStd.pideLimiteXMax())
            direccion=-5;
        super.setX_Spawn(ratechangeX+direccion);
        super.setY_Spawn(ratechangeY);
}
}