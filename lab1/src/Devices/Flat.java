package Devices;

import java.util.ArrayList;
import java.util.Collections;

public class Flat {

    private ArrayList<Device> devices;

    public Flat() {
        this.devices = new ArrayList<>();
    }

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }

    public ArrayList<Device> getDevice() {
        return devices;
    }

    public void addDevice(Device device) { devices.add(device); }

    public void deleteDevice(String name){
        for(int i = 0; i < devices.size(); i++) {
            Device d1 = devices.get(i);
            if(d1.getName().equals(name)) {
                devices.remove(i);
                return;
            }
        }
    }

    public void sortDevices(){
        if(devices == null)
            return;

        for(int i = 0; i < devices.size(); i++){
            for(int j = 0; j < devices.size() - 1 - i; j++){
                if(devices.get(j).getPower() > devices.get(j + 1).getPower()){
                    Device temp = devices.get(j);
                    devices.set(j, devices.get(j + 1));
                    devices.set(j + 1, temp);
                }
            }
        }
    }

    public void showDevices(){
        for (Device device : devices) {
            System.out.println(device.toString());
        }
        System.out.println();
    }

    public void showDevices(ArrayList<Device> devices){
        for (Device device : devices) {
            System.out.println(device.toString());
        }
        System.out.println();
    }

    public ArrayList<Device> findByRange(int min, int max){
        if(min >= max)
            return null;

        ArrayList<Device> result = new ArrayList<>();

        for (Device device : devices) {
            if (device.getPower() <= max && device.getPower() >= min) {
                result.add(device);
            }
        }

        showDevices(result);
        return result;
    }

    public int calculatePower(){
        int power = 0;
        for(Device device : devices){
            if(device.getDeviceTurn())
                power += device.getPower();
        }

        return power;
    }
    public void turndevice(String name){
        for(Device device : devices){
            if(device.getName().equals(name))
                if(device.getDeviceTurn())
                    device.setDeviceTurn(false);
                else
                    device.setDeviceTurn(true);
        }
    }
}
