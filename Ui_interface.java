import edu.epromero.util.LienzoStd;
public class Ui_interface {
    private static int higth_score=0;
    private int actual_score;
    private double withReal=LienzoStd.pideLimiteXMax()-LienzoStd.pideLimiteXMin(), heithReal=LienzoStd.pideLimiteYMax()-LienzoStd.pideLimiteYMin(),x_ponits_box,y_ponits_box;
    public int state;
    public Ui_interface (){
        actual_score=0;
    }
    public void mode(int status_game,int points){
        if(status_game==2||status_game==3)
            mode_play(points);
        if (status_game==1)
            this.state=mode_menu("Menu", getHigth_score(),points);
    }
    private void mode_play(int points){
        x_ponits_box=LienzoStd.pideLimiteXMax()-withReal*.2;
        y_ponits_box=LienzoStd.pideLimiteYMax()-heithReal*.03;
        //recuadro de pausa
        LienzoStd.rectangulo(LienzoStd.pideLimiteXMin()+withReal*.1,LienzoStd.pideLimiteYMax()-heithReal*.03 , withReal*.1, heithReal*.03);
        //recuadro de puntaje
        LienzoStd.rectangulo(x_ponits_box,y_ponits_box, withReal*.2, heithReal*.03);
        //score actual
        LienzoStd.texto(x_ponits_box,y_ponits_box, String.valueOf(points));
    }
    private int mode_menu(String message, int higth_score, int actual_score) {
        x_ponits_box=LienzoStd.pideLimiteXMin()+withReal*.5;
        y_ponits_box= LienzoStd.pideLimiteYMax()-heithReal*.5;
        double radio=(withReal*.25)/2;
        LienzoStd.rectangulo(x_ponits_box,y_ponits_box, withReal*.25, heithReal*.25);
        LienzoStd.circulo(x_ponits_box,y_ponits_box,radio);
        LienzoStd.texto(x_ponits_box,LienzoStd.pideLimiteYMax()-heithReal*.3, message);
        LienzoStd.texto(x_ponits_box, LienzoStd.pideLimiteYMax()-heithReal*.63,"Puntaje maximo "+higth_score);
        LienzoStd.texto(x_ponits_box, LienzoStd.pideLimiteYMax()-heithReal*.68, "Puntaje actual "+actual_score);
        if (radio>=Math.sqrt(Math.pow((x_ponits_box-LienzoStd.ratonX()), 2)+Math.pow((y_ponits_box-LienzoStd.ratonY()), 2)))
            return 2;
        else
            return 1;
    }
    public int getActual_score() {
        return actual_score;
    }
    public void setActual_score(int actual_score) {
        this.actual_score = actual_score;
    }

    /**
     * @return the higth_score
     */
    public static int getHigth_score() {
        return higth_score;
    }

    /**
     * @param aHigth_score the higth_score to set
     */
    public static void setHigth_score(int aHigth_score) {
        higth_score = aHigth_score;
    }
}
