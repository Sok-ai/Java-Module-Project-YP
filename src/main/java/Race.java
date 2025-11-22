import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Race {
    private final static int MAX_SPEED = 250;
    private final static int MIN_SPEED = 0;
    private final static Scanner SCANNER = new Scanner(System.in);
    private static Car winner = new Car("", -1);

    public static void startRace() {
        System.out.println("Добро пожаловать на гонки! Требуется ввести 3 автомобиля.");

        for (int i = 1; i < 4; i++) {
            System.out.println("=======================");
            System.out.println("Введите название для " + i + " автомобиля");

            String name = requestName();
            int speed = requestSpeed();
            Car car = new Car(name, speed);

            winner = (winner.getKm() > car.getKm()) ? winner : car;
        }

        countResults(cars);
    }

    private static boolean checkCorrectName(String name) {
        return name.isBlank();
    }

    private static boolean checkCorrectSpeed(int speed) {
        return speed < 0 || speed > 250;
    }

    private static String requestName() {
        String name;
        System.out.print("Название: ");
        name = SCANNER.nextLine();
        while (true) {
            if (checkCorrectName(name)) {
                System.out.println("Введена пустая строка. Повторите снова!");
                System.out.print("Повторный ввод названия: ");
                name = SCANNER.nextLine();
            } else {
                break;
            }
        }
        return name;
    }

    private static int requestSpeed() {
        int speed;
        System.out.println("Введите скорость");
        System.out.print("Cкорость (целое число от 0 до 250): ");
        try {
            speed = SCANNER.nextInt();
            SCANNER.nextLine();
            while (true) {
                if (checkCorrectSpeed(speed)) {
                    System.out.println("Введена не верная скорость. Диапазон от 0 до 250");
                    System.out.print("Новое значение скорости: ");
                    speed = SCANNER.nextInt();
                } else {
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("ОШИБКА: Скорость не может быть буквой или дробью");
            System.out.println("-----------------");
            SCANNER.nextLine();
            speed = requestSpeed();
        }

        return speed;
    }

    private static void outputWinner(Car car) {
        System.out.println("-------------------");
        System.out.printf("Самый лучший и быстрый автомобиль: %s", winner.getName());
    }
}
