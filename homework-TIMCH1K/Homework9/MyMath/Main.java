
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Какую вид операции будем производить?(Напишите цифру)");
        System.out.println("1.Нахождение модуля.");
        System.out.println("2.Нахождение максимального значения.");
        int typeOfOperation = scan.nextInt();
        switch (typeOfOperation) {
            case 1:
                System.out.print("Введите число: ");
                double a = scan.nextDouble();
                System.out.println("Результат: " + Calculating.abs(a));
            case 2:
                double nums[];
                System.out.println("Введите количество значений: ");
                int arrLen = scan.nextInt();
                nums = new double[arrLen];
                System.out.println("Вводите числа по очереди: ");

                for (int i = 0; i < nums.length; i++) {
                    nums[i] = scan.nextDouble();
                }
                MinMax minmax = Calculating.max(nums);
                System.out.println("Минимальное значение: " + minmax.min + "Максимальное значение: " + minmax.max);

        }

    }

}