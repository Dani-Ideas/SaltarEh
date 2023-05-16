import edu.epromero.util.LienzoStd;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
public class SpritePlayer extends Visible_Object {
    public int lives = 10, stamina=50, points=0,type_colition=0;
    public double direction=super.getWidth()+1,velocity=12;
    private double horizontal_movement=(LienzoStd.pideLimiteXMax()-LienzoStd.pideLimiteXMin())*.02, vertical_movement=(LienzoStd.pideLimiteYMax()-LienzoStd.pideLimiteYMin())*.05;
    private ArrayList<Object> list;
    public SpritePlayer(double x, double y, double w, double h,ArrayList<Object> listInput){
        super(x, y, w, h);
        setList(listInput);
    }
    @Override
    public void show() {
        LienzoStd.rectangulo(x_Spawn, y_Spawn, width, height);
    }
    @Override
    public void move(double ratechangeX, double ratechangeY) {
        if (LienzoStd.fuePulsadaTecla(KeyEvent.VK_UP)&&stamina>10){
            stamina-=12;
            ratechangeY+=vertical_movement;
        }
        if (LienzoStd.fuePulsadaTecla(KeyEvent.VK_RIGHT)){
            ratechangeX+=horizontal_movement;
            direction=Math.abs(direction);
            velocity=Math.abs(velocity);
        }
        if(LienzoStd.fuePulsadaTecla(KeyEvent.VK_LEFT)){
            ratechangeX-=horizontal_movement;
            direction*=-1;
            velocity*=-1;
        }
        if (LienzoStd.fuePulsadaTecla(KeyEvent.VK_SPACE) && type_colition == 1) {
            attack(list);
        }
        if (ratechangeX<=LienzoStd.pideLimiteXMin())
            super.setX_Spawn(LienzoStd.pideLimiteXMax()-10);
        else if(ratechangeX>=LienzoStd.pideLimiteXMax())
            super.setX_Spawn(LienzoStd.pideLimiteXMin()+10);
        else
            super.setX_Spawn(ratechangeX);   
        super.setY_Spawn(ratechangeY);
        type_colition=0;
        stamina();
        im_alaive(ratechangeY);
    }
    private void stamina() {
        if(stamina<500)
            stamina+=100;
    }
    public void im_alaive(double y_possiton) {
        if(y_possiton<=LienzoStd.pideLimiteYMax()*.1)
            lives=0;
        if(type_colition==2){
            type_colition=0;
            lives-=1;
        }     
    }
    private void attack(ArrayList<Object> list) {
        //cambiar este metodo despues
        //cambiar este metodo despues
        //cambiar este metodo despues
        Shot shot = new Shot(super.getX_Spawn()+direction,super.getY_Spawn(),LienzoStd.pideLimiteXMax() * 0.007,0,velocity);
        // Agregar el objeto a tu ArrayList existente o realizar otras acciones
        list.add(shot);
    }
    public ArrayList<Object> getList() {
        return list;
    }
    public void setList(ArrayList<Object> list) {
        this.list = list;
    }
}