import java.awt.Dimension;
import java.awt.Toolkit;
import edu.epromero.util.LienzoStd;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SaltarEh {
    public static void main(String[] args) {
        
        int heith_Lienzo = set_Num_Pixels("heith", (float) .8,480,740);
        int with_Lienzo = set_Num_Pixels("with", (float) .2,320,641);
        int temp=0;
        // estableciendo el tamanio de la ventana
        LienzoStd.ponTamanioLienzo(with_Lienzo,heith_Lienzo);
        LienzoStd.ponEscalaX(16, with_Lienzo);
        LienzoStd.ponEscalaY(34, heith_Lienzo);
        ////
        Platform_move platform1= new Platform_move(with_Lienzo/2,heith_Lienzo/2,50,25);
        Platform_Weak platform2= new Platform_Weak(with_Lienzo/3,heith_Lienzo/3,50,25);
        Basic_Platform platform3= new Basic_Platform(with_Lienzo*2/3,heith_Lienzo*2/3,50,25);
        SpritePlayer bigHero = new SpritePlayer(with_Lienzo*2/3,heith_Lienzo*5/6,15,30);
        
        ArrayList<Object> objectsColition= new ArrayList<Object>();
        objectsColition.add(platform1);
        objectsColition.add(platform2);
        objectsColition.add(platform3);
        objectsColition.add(bigHero);

        show_Objects(objectsColition);
        
        try {
            while(bigHero.lives>0){
                //primer pausa para que al jugador le de tiempo a reaccionar
                if (temp >-1)                    
                    Thread.sleep(3000);
                //Esto es temporal
                temp-=1;
                //Esto es temporal

                //cambiar esto mas tarde
                platform1.move(platform1.getX_Spawn(), platform1.getY_Spawn()-1);
                platform3.move(platform3.getX_Spawn(), platform3.getY_Spawn()-1);
                bigHero.move(bigHero.getX_Spawn(), bigHero.getY_Spawn()-3);
                
                colition_Manager(objectsColition);
                show_Objects(objectsColition);
                
                Thread.sleep(120);
                LienzoStd.mostrar(0);
                LienzoStd.limpia();
            }        
        } 
        catch (InterruptedException ex) {
        Logger.getLogger(SaltarEh.class.getName()).log(Level.SEVERE, null, ex);
        }}
    private static int set_Num_Pixels(String type,float persent,int limitDown,int limitUp) {
        int parammet;
        Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
        if ("heith".equals(type))
           parammet = (int) display.getHeight();
        else if("with".equals(type))
            parammet = (int) display.getWidth();
        else
            parammet = 0;
        if (parammet*persent<limitDown)
                return limitDown;
            else if (parammet*persent>limitUp)
                return limitUp;
            else
                return (int)(parammet*persent);
    }
    private static void show_Objects(ArrayList<Object> the_list) {
        
        for (int i = 0; i < the_list.size(); i++) {
            Object object = the_list.get(i);
            if (object instanceof Basic_Platform) {
                Basic_Platform platform = (Basic_Platform) object;
                platform.show();
            } else if (object instanceof SpritePlayer) {
                SpritePlayer player = (SpritePlayer) object;
                player.show();
            } else if(object instanceof Platform_move){
              Platform_move platform_movemet=  (Platform_move) object;
              platform_movemet.show();
            }
        }}
    private static void colition_Manager(ArrayList<Object> all_objects) {
        for (int i = 0; i < all_objects.size(); i++) {
            Object object = all_objects.get(i);
            if (object instanceof SpritePlayer) {
                SpritePlayer player = (SpritePlayer) object;
                for (int j = 0; j < all_objects.size(); j++) {
                    Object otherObject = all_objects.get(j);
                    if (otherObject instanceof Basic_Platform) {
                        Basic_Platform platform = (Basic_Platform) otherObject;
                        if (player.getHeight()+platform.getHeight() >= Math.abs(player.getY_Spawn()-platform.getY_Spawn())&&player.getWidth()+platform.getWidth()>=Math.abs(player.getX_Spawn()-platform.getX_Spawn())) {
                            player.move(player.getX_Spawn(), platform.getY_Spawn()+player.getHeight()+platform.getHeight()+1);
                            //el kame-kame-kaaaaaaaa
                            if(platform instanceof Platform_Weak){
                                Platform_Weak platform_to_broke = (Platform_Weak) platform;
                                platform_to_broke.time_to_break();
                            }}}}}}}}