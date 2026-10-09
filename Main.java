import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sequence = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            sequence[i] = random.nextInt(10000 + 1);
        }

        int minR = -1;
        for (int i = 0; i < 1000; i++) {
            for (int j = i + 1; j < 1000; j++) {
                int product = sequence[i] * sequence[j];
                if (product % 21 != 0) {
                    continue;
                }
                if (minR == -1 || product < minR) {
                    minR = product;
                }
            }
        }

        if (minR == -1) {
            System.out.println("Число R, удовлетворяющее условиям, не найдено. Вывод: -1");
        } else {
            System.out.println("Минимальное число R: " + minR);
        }
    }
}