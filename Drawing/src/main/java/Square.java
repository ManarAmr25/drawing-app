import java.awt.*;

public class Square extends Shapes{

    private int calcLen(){
        return Math.abs(this.endPoint.x - this.startPoint.x);
    }

    @Override
    protected String Show() {
        Point center = calcCenter();
        return "Length: " + Integer.toString(calcLen()) + " ,center: ( " + center.x + "," + center.y + " )";
    }
}
