public class AndroidPhone extends Device {
    public final String brand;

    public AndroidPhone(int serialNumber, int capacity, String brand) {
        super(serialNumber, capacity);
        this.brand = brand;
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.printf("Вас приветствует %s%n", brand);
    }

    @Override
    public String toString() {
        return "AndroidPhone{" +
                "brand='" + brand + '\'' +
                ", BATTERY_CAPACITY=" + batteryCapacity +
                '}';
    }


}
