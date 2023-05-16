
import edu.epromero.util.LienzoStd;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Shot extends Visible_Object {
    private double velocity;
    static int numbershot=0;
    public Shot(double x, double y, double w, double h,double velocityInput) {
        super(x, y, w, h);
        setVelocity(velocityInput);   
        numbershot+=1;
    }
    @Override
    public void show() {
        LienzoStd.circulo(this.x_Spawn, this.y_Spawn, super.getWidth());
    }
    @Override
    public void move(double ratechangeX, double ratechangeY) {
        if ((ratechangeX<=LienzoStd.pideLimiteXMin()||ratechangeX>=LienzoStd.pideLimiteXMax())&&numbershot>0){
            numbershot-=1;
            try {
                super.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(Shot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        super.setX_Spawn(ratechangeX+getVelocity());
        super.setY_Spawn(ratechangeY);
    }
    public double getVelocity() {
        return velocity;
    }
    protected void setVelocity(double velocity) {
        this.velocity = velocity;
    }
}
