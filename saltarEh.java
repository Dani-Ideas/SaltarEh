import java.awt.Dimension;
import java.awt.Toolkit;
import edu.epromero.util.LienzoStd;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//package saltareh;

/**
 *
 * @author d7n45
 */
public class SaltarEh {


    public static void main(String[] args) {
        
        int heith_Lienzo = set_Num_Pixels("heith", (float) .8,480,740);
        int with_Lienzo = set_Num_Pixels("with", (float) .2,320,641);
        int temp=0;

        /*
        Esta pendiente establecer que Lienzo apareca en el centro de la pantalla del usuario
        + spawn_Center(type): int x,y
        Esta pendiente agregar la imagen de fondo en el lienzo
        LienzoStd.salvar(nombreArchivo);
        */
        // estableciendo el tamanio de la ventana
        LienzoStd.ponTamanioLienzo(with_Lienzo,heith_Lienzo);
        LienzoStd.ponEscalaX(16, with_Lienzo);
        LienzoStd.ponEscalaY(34, heith_Lienzo);
        
        Basic_Platform platform1= new Basic_Platform(with_Lienzo/2,heith_Lienzo/2,50,25);
        Basic_Platform platform2= new Basic_Platform(with_Lienzo/3,heith_Lienzo/3,50,25);
        Basic_Platform platform3= new Basic_Platform(with_Lienzo*2/3,heith_Lienzo*2/3,50,25);
        SpritePlayer bigHero = new SpritePlayer(with_Lienzo*2/3,heith_Lienzo*5/6,15,30);
        
        
        ArrayList<Object> objectsColition= new ArrayList<Object>();
        objectsColition.add(platform1);
        objectsColition.add(platform2);
        objectsColition.add(platform3);
        objectsColition.add(bigHero);

        for (int i = 0; i < objectsColition.size(); i++) {
            Object object = objectsColition.get(i);
            if (object instanceof Basic_Platform) {
                Basic_Platform platform = (Basic_Platform) object;
                platform.show();
            } else if (object instanceof SpritePlayer) {
                SpritePlayer player = (SpritePlayer) object;
                player.show();
            }
        }
        
        /*platform1.show();
        platform2.show();
        platform3.show();
        bigHero.show();*/
        /* no se puede porque es un array abtracto
        Visible_Object objectscolition[] =new Visible_Object[20];
        objectscolition[0]=platform1;
        objectscolition[1]=platform2;
        objectscolition[2]=platform3;
        objectscolition[4]=bigHero;
        for (int i=0; i<objectscolition.length;i++) {
            objectscolition[i].show();
        }
        */

        try {
            while(bigHero.lives>0){
                //primer pausa para que al jugador le de tiempo a reaccionar
                if (temp >-1)                    
                    Thread.sleep(3000);
                
                //Esto es temporal
                temp-=1;
                //Esto es temporal

                platform1.move(platform1.getX_Spawn(), platform1.getY_Spawn()-1);
                platform3.move(platform3.getX_Spawn(), platform3.getY_Spawn()-1);
                platform1.show();
                platform3.show();
                platform2.show();
                bigHero.move(bigHero.getX_Spawn(), bigHero.getY_Spawn()-4);
                bigHero.show();

                
                LienzoStd.linea(0, heith_Lienzo*.15, with_Lienzo, heith_Lienzo*.15);
                LienzoStd.linea(0, heith_Lienzo*.75, with_Lienzo, heith_Lienzo*.75);


                Thread.sleep(120);

                LienzoStd.limpia();
            }        
        } 
        catch (InterruptedException ex) {
        Logger.getLogger(SaltarEh.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        
        /*
        //////////////////////////////////////////////////////////
        /// prueva de las figuras
        LienzoStd.rectangulo(with_Lienzo/2, heith_Lienzo/2, 50, 25);
        LienzoStd.circulo(0, 0,50);
        LienzoStd.elipse(with_Lienzo/2, heith_Lienzo*.8, 40, 30);
        LienzoStd.linea(0, heith_Lienzo*.25, with_Lienzo, heith_Lienzo*.25);
        LienzoStd.arc(with_Lienzo/2, heith_Lienzo*.9, 100, 45, 90);
        /// prueva de las figuras
        //////////////////////////////////////////////////////////
        */
        //LienzoStd.mostrar(0);
        


    }

    private static int set_Num_Pixels(String type,float persent,int limitDown,int limitUp) {
        int parammet;
        Dimension display = Toolkit.getDefaultToolkit().getScreenSize();

        if ("heith".equals(type))
           parammet = (int) display.getHeight();
        else if("with".equals(type))
            parammet = (int) display.getWidth();
        else
            parammet = 0;
        /////
        if (parammet*persent<limitDown)
                return limitDown;
            else if (parammet*persent>limitUp)
                return limitUp;
            else
                return (int)(parammet*persent);
        /////
    }
    
}
