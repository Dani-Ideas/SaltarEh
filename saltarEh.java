import java.awt.Dimension;
import java.awt.Toolkit;
import edu.epromero.util.LienzoStd;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int heith_Lienzo = set_Num_Pixels("heith", (float) .8,480,740);
        int with_Lienzo = set_Num_Pixels("with", (float) .2,320,641);
        /*
        Esta pendiente establecer que Lienzo apareca en el centro de la pantalla del usuario
        + spawn_Center(type): int x,y
        Esta pendiente agregar la imagen de fondo en el lienzo
        LienzoStd.salvar(nombreArchivo);
        */
        LienzoStd.ponTamanioLienzo(with_Lienzo,heith_Lienzo);
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
