package figures;

public class Rectangle extends Figure {
    private double height;
    private double width;
    private double diagonal;

    public Rectangle(double a, double b) {
        super.setName("Прямоугольник");
        super.setAreal(a * b);
        super.setPerimeter(a + b + a + b);
        this.diagonal = Math.sqrt((a * a) + (b * b));
        this.height = Integer.min((int) a, (int) b);
        this.width = Integer.max((int) a, (int) b);
    }

    @Override
    public String toString() {
        return String.format(super.toString() +
                        "Длина диагонали: %.2f мм\n" +
                        "Длина %.2f (размер длинной стороны)\n" +
                        "Ширина %.2f (размер короткой стороны)\n",
                diagonal, width, height);
    }

}
