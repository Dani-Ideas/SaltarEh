import java.awt.Dimension;
import java.awt.Toolkit;
import edu.epromero.util.LienzoStd;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SaltarEh {
    public static void main(String[] args) {
        //valores que se usarn en todo mometo para el juego
        int heith_Lienzo = set_Num_Pixels("heith", (float) .8,480,740);
        int with_Lienzo = set_Num_Pixels("with", (float) .2,320,641);
        int game_status=1,gravity_value=-1,temp=0;
        // estableciendo el tamanio de la ventana
        LienzoStd.ponTamanioLienzo(with_Lienzo,heith_Lienzo);
        LienzoStd.ponEscalaX(16, with_Lienzo);
        LienzoStd.ponEscalaY(34, heith_Lienzo);
        //declaracion de objetos
        ArrayList<Object> objectsColition= new ArrayList<Object>();
        SpritePlayer bigHero = new SpritePlayer(with_Lienzo*2/3,heith_Lienzo*5/6,15,30,objectsColition);
        Ui_interface interface_user = new Ui_interface();        
        //generate_Objects(objectsColition,bigHero.points);
        Platform_move platform1= new Platform_move(with_Lienzo/2,heith_Lienzo/2,50,10);
        Platform_Weak platform2= new Platform_Weak(with_Lienzo/3,heith_Lienzo/3,50,10);
        Basic_Platform platform3= new Basic_Platform(with_Lienzo*2/3,heith_Lienzo*2/3,50,10);
        //asignacion de objetos en la lista para colicion y usar sus metodos en method_Objects()
        objectsColition.add(platform1);
        objectsColition.add(platform2);
        objectsColition.add(platform3);
        objectsColition.add(bigHero);
        //mostrar objetos antes de empezar el juego
        //interface_user.mode(game_status,bigHero.points);   
        method_Objects(objectsColition, "show");
        try {
            while(bigHero.lives>0){
                //cambia de fase el juego de pausa a renudar, permite al jugador ver la pantalla por mas tiempo para reaccionar
                if (game_status==1){                    
                    Thread.sleep(3000);
                    game_status+=1;
                }
                //fase de creaccion de objetos
                if (temp==50){
                    //ya se que esto esta mal pero solo es temporal
                    generate_Objects(objectsColition,bigHero.points);
                    temp=0;
                }
                temp+=1;
                //fase de mover objetos
                move_Objects(objectsColition, gravity_value);
                bigHero.move(bigHero.getX_Spawn(), bigHero.getY_Spawn()-7+gravity_value);
                //fase de comprobacion de colicion
                colition_Manager(objectsColition);
                //fase de impresion de objetos
                method_Objects(objectsColition, "show");
                interface_user.mode(game_status,bigHero.points);
                LienzoStd.mostrar(0);
                //permite ver los ojetos por cietos milisegundos para ver el movimiento
                Thread.sleep(120);
                //borra todos los objetos para dejar la vetana en blanco
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
    private static void method_Objects(ArrayList<Object> the_list, String name_method) {
        /*
        En este código, object.getClass().getMethod(name_method) obtiene el objeto Method correspondiente 
        al nombre del método proporcionado. Luego, method.invoke(object) invoca ese método en el objeto específico.
        */
    for (Object object : the_list) {
        try {
            Method method = object.getClass().getMethod(name_method);
            method.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }}}    
    private static void move_Objects(ArrayList<Object> listaObjetos,int gravityValue) {
    for (Object objeto : listaObjetos) {
        if (objeto instanceof Basic_Platform) {
            Basic_Platform platform1 = (Basic_Platform) objeto;
            platform1.move(platform1.getX_Spawn(), platform1.getY_Spawn() + gravityValue);
        }
        if (objeto instanceof Shot) {
            Shot the_shot = (Shot) objeto;
            the_shot.move(the_shot.getX_Spawn(), the_shot.getY_Spawn() + gravityValue);
        }
    }
    }
    private static void colition_Manager(ArrayList<Object> all_objects) {
        for (int i = 0; i < all_objects.size(); i++) {
            Object object = all_objects.get(i);
            if (object instanceof SpritePlayer) {
                SpritePlayer player = (SpritePlayer) object;
                for (int j = 0; j < all_objects.size(); j++) {
                    Object otherObject = all_objects.get(j);
                    if (otherObject instanceof Basic_Platform){
                        Basic_Platform platform = (Basic_Platform) otherObject;
                        if (player.getHeight()+platform.getHeight() >= Math.abs(player.getY_Spawn()-platform.getY_Spawn())&&player.getWidth()+platform.getWidth()>=Math.abs(player.getX_Spawn()-platform.getX_Spawn())) {
                            //respeta el espacio de la palataforma
                            player.move(player.getX_Spawn(), platform.getY_Spawn()+player.getHeight()+platform.getHeight()+1);
                            //Le indica al objeto del jugador que esta colicionando con plataforma
                            player.type_colition=1;
                            if (platform.getId_object()!=0){
                                player.points+=10;
                                platform.Id_object=0;
                            }
                            //el kame-kame-kaaaaaaaa
                            if(platform instanceof Platform_Weak){
                                Platform_Weak platform_to_broke = (Platform_Weak) platform;
                                platform_to_broke.time_to_break();
                            }}}
                    
                }}}}
    private static void generate_Objects(ArrayList<Object> list,int points_to_dificulty) {
        double number_random=generateRandomNumber(LienzoStd.pideLimiteXMin(),LienzoStd.pideLimiteXMax());
        if (points_to_dificulty<=100){
            double[] probabilities = {0.7, 0.3};
            int event= generateEvent(probabilities);
            if (event ==0){
            Basic_Platform platform= new Basic_Platform(number_random,LienzoStd.pideLimiteYMax()+10,LienzoStd.pideLimiteXMax()*.15,LienzoStd.pideLimiteYMax()*.01);
            list.add(platform);}
            else{
               Platform_Weak platform2= new Platform_Weak(number_random,LienzoStd.pideLimiteYMax()+10,LienzoStd.pideLimiteXMax()*.15,LienzoStd.pideLimiteYMax()*.01);
            list.add(platform2);
            }
        }else if (points_to_dificulty<=200){
            double[] probabilities = {0.5, 0.3, 0.2};
            int event= generateEvent(probabilities);
            if (event ==0){
                Basic_Platform platform= new Basic_Platform(number_random,LienzoStd.pideLimiteYMax()+10,LienzoStd.pideLimiteXMax()*.15,LienzoStd.pideLimiteYMax()*.01);
                list.add(platform);}
            else if(event ==1){
               Platform_Weak platform2= new Platform_Weak(number_random,LienzoStd.pideLimiteYMax()+10,LienzoStd.pideLimiteXMax()*.15,LienzoStd.pideLimiteYMax()*.01);
            list.add(platform2);
           }else{
               Platform_move platform3= new Platform_move(number_random,LienzoStd.pideLimiteYMax()+10,LienzoStd.pideLimiteXMax()*.15,LienzoStd.pideLimiteYMax()*.01);
               list.add(platform3);
           }
        }else{
            double[] probabilities = {0.4,0.3,0.2,0.1};
            int event= generateEvent(probabilities);
            if (event ==0){
                Basic_Platform platform= new Basic_Platform(number_random,LienzoStd.pideLimiteYMax()+10,LienzoStd.pideLimiteXMax()*.15,LienzoStd.pideLimiteYMax()*.01);
                list.add(platform);}
            else if(event ==1){
               Platform_Weak platform2= new Platform_Weak(number_random,LienzoStd.pideLimiteYMax()+10,LienzoStd.pideLimiteXMax()*.15,LienzoStd.pideLimiteYMax()*.01);
            list.add(platform2);
           }else if(event==2){
               Platform_move platform3= new Platform_move(number_random,LienzoStd.pideLimiteYMax()+10,LienzoStd.pideLimiteXMax()*.15,LienzoStd.pideLimiteYMax()*.01);
               list.add(platform3);
           }else{
               Sprite_computer enemy= new Sprite_computer(number_random,LienzoStd.pideLimiteYMax()+10,LienzoStd.pideLimiteXMax()*.05,LienzoStd.pideLimiteYMax()*.07,list);
               System.out.println("enemigo");
               list.add(enemy);
           }
        }
    }
    private static double generateRandomNumber(double min, double max) {
        return Math.random() * (max - min + 1) + min;
    }
    public static int generateEvent(double[] probabilities){
    double randomValue = Math.random();
    double cumulativeProbability = 0;
    for (int i = 0; i < probabilities.length; i++) {
        cumulativeProbability += probabilities[i];
        if (randomValue <= cumulativeProbability) {
            return i;
        }
    }

    return 0; // Si no se encontró ningún evento (esto puede ocurrir si las probabilidades no suman 1)
}
}