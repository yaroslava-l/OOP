package Devices;

public class Phone extends Device {
    double screen;
    public Phone(String name, int modelYear, int power, boolean turn,double screen) {
        super(name, modelYear, power, turn);
        this.screen = screen;
    }
}
