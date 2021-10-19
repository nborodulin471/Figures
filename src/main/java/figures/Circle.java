package figures;

public class Circle extends Figure {
    private double radius;
    private double diameter;

    public Circle(double radius) {
        super.setName("Круг");
        super.setAreal(Math.PI * (radius * radius));
        super.setPerimeter(Math.PI * 2 * radius);
        this.radius = radius;
        this.diameter = radius * 2;

    }

    @Override
    public String toString() {
        return String.format(super.toString() +
                "Радиус: %.2f мм\n" +
                "Диаметр: %.2f мм\n", radius, diameter);
    }
}
