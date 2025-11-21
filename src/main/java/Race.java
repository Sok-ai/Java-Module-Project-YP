import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Race {
    public static void startRace() {
        ArrayList<Car> cars = new ArrayList<>();
        System.out.println("Добро пожаловать на гонки! Требуется ввести 3 автомобиля.");

        for (int i = 1; i < 4; i++) {
            System.out.println("=======================");
            System.out.println("Введите название для " + i + " автомобиля");

            String name = requestName();
            int speed = requestSpeed();
            Car car = new Car(name, speed);

            cars.add(car);
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
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.print("Название: ");
        name = scanner.nextLine();
        while (true) {
            if (checkCorrectName(name)) {
                System.out.println("Введена пустая строка. Повторите снова!");
                System.out.print("Повторный ввод названия: ");
                name = scanner.nextLine();
            } else {
                break;
            }
        }
        return name;
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

    private static void countResults(ArrayList<Car> cars) {
        for (Car car : cars) {
            int km = car.getSpeed() * 24;
            car.setKM(km);
        }
        outputWinner(cars);
    }

    private static void outputWinner(ArrayList<Car> cars) {
        Car winner = Collections.max(cars, (car1, car2) ->
                Integer.compare(car1.getKM(), car2.getKM())
        );
        System.out.println("-------------------");
        System.out.printf("Самый лучший и быстрый автомобиль: %s", winner.getName());
    }
}
