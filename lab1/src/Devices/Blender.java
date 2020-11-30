package Devices;

public class Blender extends Device {
    private int turnCounter;
    public Blender(String name, int modelYear, int power, boolean turn, int turnCounter) {
        super(name, modelYear, power, turn);
        this.turnCounter = turnCounter;
    }
}
