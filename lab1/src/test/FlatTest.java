package test;

import Devices.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FlatTest {

    ArrayList<Device> devices = new ArrayList<>();
    Flat flat = new Flat();

    @Before
    public void setUp(){
        Device phone1 = new Phone("Apple iPhone 11 64GB", 2020,1200, false, 1000);
        Device laptop1 = new Laptop("Asus ROG Strix G15", 2019, 1500, true, "asd");
        Device blender = new Blender("TEFAL ULTRABLEND COOK BL962B38", 2019, 1300,true, 1000);

        devices.add(phone1);
        devices.add(laptop1);
        devices.add(blender);

        flat.setDevices(devices);
    }

    @Test
    public void sortSuccess_TEST(){

        flat.sortDevices();

        for(int i = 0; i < devices.size() - 1; i++){
            Assert.assertFalse(devices.get(i).getPower() > devices.get(i + 1).getPower());
            Assert.assertEquals(flat.calculatePower(), 2800);
        }

        ArrayList<Device> result = flat.findByRange(1400,2000);

        for(int i = 0; i < result.size(); i++)
            Assert.assertTrue(result.get(i).getPower()<2000 &&result.get(i).getPower()>1400);

    }
}
