
import java.util.Scanner;

//Заполните массив случайными числами и выведите максимальное,
//минимальное и среднее значение.
//Для генерации случайного числа используйте метод Math.random(),
//который возвращает значение в промежутке [0,1];
public class MaxMinAvgVALUE {
    public static void main(String[] args) {

        int n = 100;
        double[] array = new double[n]; //создаем массив с вещественным типом данных double и передаем ему размер n=100;

        for (int i = 0; i < array.length; i++) { //создаем цикл для перебора по ВСЕМУ массиву;
            array[i] = Math.random(); //Присваиваем ячейке по индексу случайное значение с помощью метода Math.random;
        }

        double max = array[0]; //Создаем переменную max, в которую запишем МАКСИМАЛЬНОЕ значение из массива;
        double min = array[0]; //Создаем переменную min, в которую запишем МИНИМАЛЬНОЕ значение из массива;
        double avg = 0; //Создаем переменную avg, в которую запишем СРЕДНЕЕ значение из массива;

        for (int i = 0; i < array.length; i++) { //создаем цикл для перебора по ВСЕМУ массиву;

            if (max < array[i])
                max = array[i];

            if (min > array[i])
                min = array[i];

            avg += array[i] / array.length;
        }

        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("avg = " + avg);
    }
}