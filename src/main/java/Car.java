public class Car {
    private final String NAME;
    private final int SPEED;

    private int km;

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Car(String name, int speed) {
        this.NAME = name;
        this.SPEED = speed;
    }

    public String getNAME() {
        return NAME;
    }
    public int getSPEED() {
        return SPEED;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + NAME + '\'' +
                ", speed=" + SPEED +
                '}';
    }
}
