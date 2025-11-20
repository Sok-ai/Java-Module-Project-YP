import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startRace();
    }

    public static void startRace() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Car> cars = new ArrayList<>();
        System.out.println("Добро пожаловать на гонки! Требуется ввести 3 автомобиля.");
        int speed;

        for (int i = 1; i < 4; i++) {
            System.out.println("-----------------------");
            System.out.println("Введите название для " + i + " автомобиля");
            System.out.print("Название: ");
            String name = scanner.next();
            speed = requestSpeed();

            Car car = new Car(name, speed);
            cars.add(car);
        }
    }
    private static boolean checkCorrectSpeed(int speed) {
        return speed < 0 || speed > 250;
    }

    private static int requestSpeed() {
        Scanner scanner = new Scanner(System.in);
        int speed = 0;
        System.out.println("Введите скорость");
        System.out.print("Cкорость (целое число от 0 до 250): ");
        try {
            speed = scanner.nextInt();
            while (true) {
                if (checkCorrectSpeed(speed)) {
                    System.out.println("Введена не верная скорость. Диапазон от 0 до 250");
                    System.out.print("Новое значение скорости: ");
                    speed = scanner.nextInt();
                } else {
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("ОШИБКА: Скорость не может быть буквой или дробью");
            System.out.println("-----------------");
            requestSpeed();
        }
        return speed;
    }
}