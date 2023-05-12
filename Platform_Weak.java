public class Platform_Weak extends Basic_Platform{
    int resisitance=17;
    public Platform_Weak(double x, double y, double w, double h) {
        super(x, y, w, h);
    }
    public void time_to_break(){
        if (resisitance>0)
            resisitance-=1;
        else{
            super.height=0;
            super.width=0;
        }    
    }
}
