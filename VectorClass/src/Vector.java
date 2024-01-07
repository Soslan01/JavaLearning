public class Vector {
    //Приватные поля для вектора;
    private double x;
    private double y;
    private double z;

    //Конструктор для объекта(экземпляра) этого класса;
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Метод для вычисления длины вектора - корень из суммы квадратов;
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    //Метод для вычисления скалярного произведения векторов;
    public double scalarProduct(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    //Метод для вычисления векторного произведения векторов;
    public Vector crossProduct(Vector vector) {
        return new Vector(y * vector.z - z * vector.y,
                          z * vector.x - x * vector.z,
                          x * vector.y - y * vector.x);
    }

    //Метод для вычисления косинуса угла между векторами;
    //Скалярное произведение векторов делится на произведение (модулей) длин векторов;
    public double cos(Vector vector) {
        return scalarProduct(vector) / (length() * vector.length());
    }

    //Метод для вычисления суммы двух векторов;
    public Vector add(Vector vector) {
        return new Vector(x + vector.x,
                          y + vector.y,
                          z + vector.z);
    }

    //Метод для вычисления разницы двух векторов;
    public Vector substract(Vector vector) {
        return new Vector(x - vector.x,
                          y - vector.y,
                          z- vector.z);
    }

    public static Vector[] generate(int n) {
        Vector[] vectors = new Vector[n]; //Создается массив с векторами, длина которого n;
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "Vector {" +
                "x = " + x +
                ", y = " + y +
                ", z = " + z + '}';
    }
}
