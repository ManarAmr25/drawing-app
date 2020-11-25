import java.awt.*;

public class Rectangle extends Shapes{


    private int calcWidth(){
        return Math.abs(this.endPoint.x - this.startPoint.x);
    }

    private int calcHeight(){
        return Math.abs(this.endPoint.y - this.startPoint.y);
    }

    @Override
    protected String Show() {
        Point center = calcCenter();
        return "Width: " + Double.toString(calcWidth()) + " ,height: " + Integer.toString(calcHeight()) + " ,center: ( " + center.x + "," + center.y + " )";
    }
}
