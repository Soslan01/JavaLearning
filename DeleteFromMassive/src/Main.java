//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] testArray = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println("Первоначальный вид массива: " + Arrays.toString(testArray));

        System.out.println("Введите число, которое необходимо удалить: " );
        int val = sc.nextInt();

        System.out.println("Отредактированный массив: " + Arrays.toString(removeElement(testArray, val)));
    }

    public static int[] removeElement(int[] nums, int val) { //Для метода передаем массив и само число, которое;
        //необходимо удалить;
        int offset = 0; //переменная, которая указывает количество удаленных чисел;
        //на это же число массив нужно будет сместить, чтобы в нем не осталось нулей;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                offset++;
            } else {
                nums [i - offset] = nums[i];
            }
        }

        return Arrays.copyOf(nums, nums.length - offset);
    }
}