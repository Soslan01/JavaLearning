/*
Задача:

Напишите класс, конструктор которого принимает два массива: массив значений и массив весов значений.
Класс должен содержать метод, который будет возвращать элемент из первого массива случайным образом, с учётом его веса.
Пример:
Дан массив [1, 2, 3], и массив весов [1, 2, 10].
В среднем, значение «1» должно возвращаться в 2 раза реже, чем значение «2» и в десять раз реже, чем значение «3».

 */

/*
    Решение основывается на геометрической идее:
    Будем считать, что веса — это длины некоторых отрезков.
    Тогда надо "уложить" все отрезки в один общий,
    генерировать случайное значение из этого общего отрезка,
    определять в какой из наших отрезков попало значение:
    |-|--|----------|
    0-1--3----------13
              ^
 */
public class Main {
    public static void main(String[] args) {

        int[] values = {1, 4, 5};
        int[] weights = {1, 2, 10};
        RandomFromArray random = new RandomFromArray(values, weights);

        System.out.println(random.getRandom());
        System.out.println(random.getRandom());
        System.out.println(random.getRandom());
        System.out.println(random.getRandom());
        System.out.println(random.getRandom());
        System.out.println(random.getRandom());
        System.out.println(random.getRandom());
        System.out.println(random.getRandom());
        System.out.println(random.getRandom());
        System.out.println(random.getRandom());
    }
}

class RandomFromArray {

    private int[] values; //Значения чисел в массиве;
    private int[] weights; //Веса этих чисел из массива;
    private int[] ranges; //Левые границы отрезков;
    private int sum; //Общая длина всех отрезков;

    //Конструктор для экземпляра класса, который должен принимать;
    //массив чисел и массив весов для этих чисел;
    public RandomFromArray(int[] values, int[]weights) {
        this.values = values;
        this.weights = weights;
        ranges = new int[values.length];

        //Сумма длин всех отрезков;
        sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        //Заполняем ranges левыми границами;
        int lastSum = 0;
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = lastSum;
            lastSum += weights[i];
        }
    }

    public int getRandom() {
        int random = (int) (Math.random() * (sum - 1));

        int ourRangeIndex = 0;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] > random) {
                break;
            }
            ourRangeIndex = i;
        }
        return values[ourRangeIndex];
    }
}