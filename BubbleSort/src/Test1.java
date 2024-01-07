import java.sql.SQLOutput;
import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) {

        int[] array = {4, 7, 8, 3, 2, 9, 5, 7, 4, 10};
        int max = 0;
        int min = 0;
        double avg = 0;

        System.out.println(Arrays.toString(array) + " - неотсортированный массив");

        int buffer = 0;
        boolean isSorted = false;

        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            avg += array[i]/ array.length;
        }

        max = array[9];
        min = array[0];


        System.out.println(Arrays.toString(array) + " - Отсортированный массив");
        System.out.println(max + " - Максимальное число");
        System.out.println(min + " - Минимальное число");
        System.out.println(avg + " - Среднее число");
    }
}
