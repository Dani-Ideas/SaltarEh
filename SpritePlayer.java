import edu.epromero.util.LienzoStd;
import java.awt.event.KeyEvent;
public class SpritePlayer extends Visible_Object {
    public int lives = 1, stamina=50;;
    private double horizontal_movement=(LienzoStd.pideLimiteXMax()-LienzoStd.pideLimiteXMin())*.02, vertical_movement=(LienzoStd.pideLimiteYMax()-LienzoStd.pideLimiteYMin())*.02;
    public SpritePlayer(double x, double y, double w, double h) {
        super(x, y, w, h);
    }
    @Override
    public void show() {
        LienzoStd.rectangulo(x_Spawn, y_Spawn, width, height);
    }
    @Override
    public void move(double ratechangeX, double ratechangeY) {
        if (LienzoStd.fuePulsadaTecla(KeyEvent.VK_UP)&&stamina>0){
            stamina-=12;
            ratechangeY+=vertical_movement;
        }
        if (LienzoStd.fuePulsadaTecla(KeyEvent.VK_RIGHT)){
            ratechangeX+=horizontal_movement;
        }
        if(LienzoStd.fuePulsadaTecla(KeyEvent.VK_LEFT)){
            ratechangeX-=horizontal_movement;
        }
        if (ratechangeX<=LienzoStd.pideLimiteXMin())
            super.setX_Spawn(LienzoStd.pideLimiteXMax()-10);
        else if(ratechangeX>=LienzoStd.pideLimiteXMax())
            super.setX_Spawn(LienzoStd.pideLimiteXMin()+10);
        else
            super.setX_Spawn(ratechangeX);   
        super.setY_Spawn(ratechangeY);
        stamina();
    }
    private void stamina() {
        if(stamina<50)
            stamina+=2;
    }
}