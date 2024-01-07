//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Vector[] vectors = Vector.generate(2);
        //Простой вывод двух векторов, которые сгенерировались в массив;
        System.out.println("1 - " + vectors[0]);
        System.out.println("2 - " + vectors[1]);
        //Вывод длин векторов;
        System.out.println("vector1 length - " + vectors[0]);
        System.out.println("vector2 length - " + vectors[1]);
        //Скалярное произведение двух векторов;
        System.out.println("scalarProduct of vectors - " + vectors[0].scalarProduct(vectors[1]));
        //Векторное произведение векторов;
        System.out.println("crossProduct of vectors - " + vectors[0].crossProduct(vectors[1]));
        //Косинус угла (сos) между двумя векторами;
        System.out.println("cos of the angle of two vectors - " + vectors[0].cos(vectors[1]));
        //Сумма двух векторов;
        System.out.println("summ of vectors - " + vectors[0].add(vectors[1]));
        //Разница двух векторов;
        System.out.println("subtract of vectors - " + vectors[0].substract(vectors[1]));

    }
}

