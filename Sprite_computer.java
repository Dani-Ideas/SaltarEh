
import edu.epromero.util.LienzoStd;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sprite_computer extends SpritePlayer{
    public int lives = 10,type_colition=0;
    //private double horizontal_movement=(LienzoStd.pideLimiteXMax()-LienzoStd.pideLimiteXMin())*.02;
    public Sprite_computer(double x, double y, double w, double h,ArrayList<Object> listInput) {
        super(x, y, w, h,listInput);
        
    }
    @Override
    public void show() {
        LienzoStd.rectangulo(x_Spawn, y_Spawn, width, height);
    }

    @Override
    public void move(double ratechangeX, double ratechangeY) {
        super.im_alaive(ratechangeY);
        delete(ratechangeY);
    }

    private void delete(double ratechangeY) {
        if (ratechangeY<=LienzoStd.pideLimiteYMin())
            try {
                super.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Sprite_computer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
