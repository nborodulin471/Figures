package figures;

import java.util.Objects;

abstract public class Figure {

    private String name;
    private double areal;
    private double perimeter;

    public String getName() {
        return name;
    }

    public double getAreal() {
        return areal;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAreal(double areal) {
        this.areal = areal;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Double.compare(figure.areal, areal) == 0 && Double.compare(figure.perimeter, perimeter) == 0 && Objects.equals(name, figure.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, areal, perimeter);
    }

    @Override
    public String toString() {
        return String.format("Тип фигуры: %s\n" +
                        "Площадь: %.2f кв.мм\n" +
                        "Периметр: %.2f мм\n", name, areal, perimeter);
    }

}
