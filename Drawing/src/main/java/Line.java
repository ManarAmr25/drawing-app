public class Line extends Shapes{

    private double calcLen(){
        double x = Math.sqrt(Math.pow(this.startPoint.x-this.endPoint.x,2) + Math.pow(this.startPoint.y-this.endPoint.y,2));
        return x;
    }

    @Override
    protected String Show() {
        return "Length: " + Double.toString(calcLen());
    }
}