package figures;

import exception.FileNotValidException;

public class Triangle extends Figure {
    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c) throws FileNotValidException {
        super.setName("Треугольник");
        super.setPerimeter(a + b + c);
        super.setAreal(areaGeron());
        this.a = a;
        this.b = b;
        this.c = c;
        triangleExists();
    }

    // в параметрах oP... передаются смежные стороны
    // а первым параметром идет противолежащая сторона
    public double opposingCorners(double res, double oP1, double oP2){
        double cos = (Math.abs(oP1*oP1) + Math.abs(oP2 * oP2) - Math.abs(res * res)) / (2 * oP1 * oP2);
        return Math.toDegrees(Math.acos(cos));
    }

    public void triangleExists() throws FileNotValidException {
        if (!((a < b+c) && (b < a+c) && (c < a+b))){
            throw new FileNotValidException("Введенные параметры треугольника не допускают его существование");
        }
    }

    public double areaGeron(){
        double p = super.getPerimeter();
        if (p == 0){
            throw new IllegalStateException("Не установлен периметр");
        }

        // формула Герона
        p = p / 2;
        double areal =  p * (p - a) * (p - b) * (p - c);
        areal = Math.sqrt(areal);
        return areal;
    }


    @Override
    public String toString() {
        return String.format(super.toString() +
                "длинна стороны a: %.2f и противолежащий угол %.2f градусов\n"+
                "длинна стороны b: %.2f и противолежащий угол %.2f градусов\n"+
                "длинна стороны c: %.2f и противолежащий угол %.2f градусов\n",
                a, opposingCorners(a, c, b), b, opposingCorners(b, a, c), c, opposingCorners(c, a, b));
    }
}
