import java.util.ArrayList;
import java.util.Collections;

public class Race {
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
