import edu.epromero.util.LienzoStd;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Basic_Platform extends Visible_Object {
    static int Id_number=1,numbers_platforms=0;
    public int Id_object, numbers_respawn=0;
    public Basic_Platform(double x, double y, double w, double h) {
        super(x, y, w, h);
        setId_object(Id_number);
        Id_number+=1;
        numbers_platforms+=1;
    }
    @Override
    public void show() {
        LienzoStd.rectangulo(x_Spawn, y_Spawn, width, height);
    }
    @Override
    public void move(double ratechangeX, double ratechangeY) {
        delete(ratechangeY);
        super.setX_Spawn(ratechangeX);
        super.setY_Spawn(ratechangeY);
    }
    public int getId_object() {
        return Id_object;
    }
    public void setId_object(int Id_object) {
        this.Id_object = Id_object;
    }
    protected void delete(double Y_position) {
        if (Y_position<=LienzoStd.pideLimiteYMin()){
            try {
                super.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(Basic_Platform.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}