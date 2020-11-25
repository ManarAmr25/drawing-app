import java.awt.*;

public class Circle extends Shapes{

    private double calcRadius(){
        return Math.abs(this.endPoint.y - this.startPoint.y)/2;
    }

    @Override
    protected String Show() {
        Point center = calcCenter();
        double radius = calcRadius();
        return "radius: " + radius + " ,center: ( " + center.x + "," + center.y + " )";
    }
}
