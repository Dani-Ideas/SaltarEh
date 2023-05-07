
public abstract class Visible_Object {

    protected double x_Spawn;
    protected double y_Spawn;
    protected double width;
    protected double height;

    public Visible_Object(double x_input_Spawn, double y_input_Spawn, double with_input, double heith_input) {
        setX_Spawn(x_input_Spawn);
        setY_Spawn(y_input_Spawn);
        setWidth(with_input);
        setHeight(heith_input);
    }

    public abstract void show();

    public abstract void move(double ratechangeX, double ratechangeY);

    public double getX_Spawn() {
        return x_Spawn;
    }

    protected void setX_Spawn(double x_Spawn) {
        this.x_Spawn = x_Spawn;
    }

    public double getY_Spawn() {
        return y_Spawn;
    }

    protected void setY_Spawn(double y_Spawn) {
        this.y_Spawn = y_Spawn;
    }

    public double getWidth() {
        return width;
    }

    protected void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    protected void setHeight(double height) {
        this.height = height;
    }

}