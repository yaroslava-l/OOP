import Devices.*;
import java.util.*;

public class Main {



    public static void main(String[] args) {

        ArrayList<Device> devices = new ArrayList<>();
        Device phone1 = new Phone("Apple iPhone 11 64GB", 2020,1200, false, 1000);
        Device laptop1 = new Laptop("Asus ROG Strix G15", 2019, 1500, true, "asd");
        Device blender = new Blender("TEFAL ULTRABLEND COOK BL962B38", 2019, 1300,true, 1000);


        devices.add(phone1);
        devices.add(laptop1);
        devices.add(blender);


        Flat flat = new Flat();
        flat.setDevices(devices);

        flat.showDevices();

        flat.sortDevices();

        flat.showDevices();

        flat.findByRange(1300, 1700);

        System.out.println(flat.calculatePower());

        while(true) {
            System.out.println("1 View list");
            System.out.println("2 Add");
            System.out.println("3 Delete");
            System.out.println("4 Sort");
            System.out.println("5 Find range");
            System.out.println("6 Switch  On");
            System.out.println("7 Total Power");
            System.out.println("8 Exit");
            getChoiceMenu(devices,flat);

        }

    }

    public static void getChoiceMenu(ArrayList<Device> devices, Flat flat) {
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        switch (userChoice) {
            case "1"://show
                flat.showDevices();
                break;
            case "2"://add
            {
                String name=scanner.nextLine();;
                int power=scanner.nextInt();
                int year=scanner.nextInt();
                boolean turn=scanner.nextBoolean();
                Device device= new Device(name,year,power,turn);
                flat.addDevice(device);
                break;
            }
            case "3"://delete
                System.out.println("Name:");
                String delname=scanner.nextLine();
                flat.deleteDevice(delname);
                break;

            case "4"://sort
                flat.sortDevices();
                break;

            case "5"://find
                System.out.println("min:");
                int min=scanner.nextInt();
                System.out.println("max:");
                int max=scanner.nextInt();
                flat.findByRange(min,max);
                break;

            case "6"://turn on
                System.out.println("Name:");
                String name=scanner.nextLine();
                flat.turndevice(name);
                break;

            case "7"://total power
                int totalpower=flat.calculatePower();
                System.out.println(totalpower);
                break;

            case "8"://exit
                System.out.println("The program is closed.");
                System.exit(0);
                break;

            default:
                break;
        }
    }
}
