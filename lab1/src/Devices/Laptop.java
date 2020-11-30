package Devices;

public class Laptop extends Device {
    String core;
    public Laptop(String name, int modelYear, int power, boolean turn, String core) {
        super(name, modelYear, power, turn);
        this.core = core;
    }
}
