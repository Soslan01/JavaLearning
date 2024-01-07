import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        int[] massive = {11, 3, 14, 16, 7}; //Создаем массив, который необходимо отсортировать пузырьковым методом;

        boolean isSorted = false; //Проверка массива отсортирован ли он уже;
        int buffer; //Переменная, в которую мы будем записывать число, котороые нужно будет поменять местами;

        while(!isSorted) { //Цикл будет работать до тех пор, пока массив не будет отсортирован;

            isSorted = true;

            for (int i = 0; i < massive.length - 1; i++) { //Перебор по массиву;
            if (massive[i] > massive[i + 1]) { //Если какое то число больше впереди стоящего числа, то мы меняем;
                //их местами до тех пор, пока весь массив не будет отсортирован;
                isSorted = false;

                buffer = massive[i];
                massive[i] = massive[i + 1];
                massive[i + 1] = buffer;
            }
            }
        }

        System.out.println(Arrays.toString(massive));

    }
}