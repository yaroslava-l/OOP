package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;
import parsers.DOM;
import parsers.DocHandler;
import tariff.Tariff;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static parsers.StAX.parseXML;

public class ParsersTests {

    ArrayList<Tariff> tariffList = new ArrayList<>();

    @Before
    public void setUp(){
        Tariff tar1 = new Tariff();
        tar1.setId("");
        tar1.setName("WGold");
        tar1.setPayroll(100);
        tar1.callprices.setInsidenetwork(0);
        tar1.callprices.setOutsidenetwork(15);
        tar1.callprices.setTofixedphones(6);
        tar1.setSmsprice(2);
        tar1.parametrers.setFavouritenumbers(10);
        tar1.parametrers.setTariffing("twelve_seconds");
        tar1.parametrers.setConnectpayment(50);

        Tariff tar2 = new Tariff();
        tar2.setName("Family");
        tar2.setPayroll(250);
        tar2.callprices.setInsidenetwork(0);
        tar2.callprices.setOutsidenetwork(20);
        tar2.callprices.setTofixedphones(6);
        tar2.setSmsprice(2);
        tar2.parametrers.setFavouritenumbers(5);
        tar2.parametrers.setTariffing("twelve_seconds");
        tar2.parametrers.setConnectpayment(100);

        Tariff tar3 = new Tariff();
        tar3.setName("your_tr");
        tar3.setPayroll(150);
        tar3.callprices.setInsidenetwork(1);
        tar3.callprices.setOutsidenetwork(5);
        tar3.callprices.setTofixedphones(6);
        tar3.setSmsprice(0);
        tar3.parametrers.setFavouritenumbers(2);
        tar3.parametrers.setTariffing("each_minute");
        tar3.parametrers.setConnectpayment(50);

        Tariff tar4 = new Tariff();
        tar4.setName("TTTen");
        tar4.setPayroll(200);
        tar4.callprices.setInsidenetwork(10);
        tar4.callprices.setOutsidenetwork(10);
        tar4.callprices.setTofixedphones(10);
        tar4.setSmsprice(10);
        tar4.parametrers.setFavouritenumbers(8);
        tar4.parametrers.setTariffing("twelve_seconds");
        tar4.parametrers.setConnectpayment(40);

        Tariff tar5 = new Tariff();
        tar5.setName("Work");
        tar5.setPayroll(400);
        tar5.callprices.setInsidenetwork(0);
        tar5.callprices.setOutsidenetwork(10);
        tar5.callprices.setTofixedphones(8);
        tar5.setSmsprice(0);
        tar5.parametrers.setFavouritenumbers(5);
        tar5.parametrers.setTariffing("each_minute");
        tar5.parametrers.setConnectpayment(100);

        tariffList.add(tar1);
        tariffList.add(tar2);
        tariffList.add(tar3);
        tariffList.add(tar4);
        tariffList.add(tar5);
    }

    @Test
    public void StAX_TEST(){
        String fileName = "Tariff.xml";
        List<Tariff> tariffListLocal = parseXML(fileName);

        Assert.assertEquals(this.tariffList.size(), tariffListLocal.size());
        for(int i = 0; i < tariffListLocal.size(); i++){
            Assert.assertEquals(tariffList.get(i).getName(), tariffListLocal.get(i).getName());
            Assert.assertEquals(tariffList.get(i).getId(), tariffListLocal.get(i).getId());
            Assert.assertEquals(tariffList.get(i).getPayroll(), tariffListLocal.get(i).getPayroll());
            Assert.assertEquals(tariffList.get(i).getSmsprice(), tariffListLocal.get(i).getSmsprice(), 0.0002);
            Assert.assertEquals(tariffList.get(i).getCallprices().getInsidenetwork(), tariffListLocal.get(i).getCallprices().getInsidenetwork(), 0.0002);
            Assert.assertEquals(tariffList.get(i).getCallprices().getOutsidenetwork(), tariffListLocal.get(i).getCallprices().getOutsidenetwork(), 0.0002);
            Assert.assertEquals(tariffList.get(i).getCallprices().getTofixedphones(), tariffListLocal.get(i).getCallprices().getTofixedphones(), 0.0002);
            Assert.assertEquals(tariffList.get(i).getParameters().getConnectpayment(), tariffListLocal.get(i).getParameters().getConnectpayment());
            Assert.assertEquals(tariffList.get(i).getParameters().getFavouritenumbers(), tariffListLocal.get(i).getParameters().getFavouritenumbers());
            Assert.assertEquals(tariffList.get(i).getParameters().getTariffing(), tariffListLocal.get(i).getParameters().getTariffing());

        }

    }

    @Test
    public void SAX_TEST() throws IOException, SAXException, ParserConfigurationException {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        DocHandler dh = new DocHandler();
        List<Tariff> tariffListLocal;
        if (dh != null)
            parser.parse("Tariff.xml", dh);
        tariffListLocal = dh.getNotes();

        Assert.assertEquals(this.tariffList.size(), tariffListLocal.size());
        for(int i = 0; i < tariffListLocal.size(); i++){
            Assert.assertEquals(tariffList.get(i).getName(), tariffListLocal.get(i).getName());
            Assert.assertEquals(tariffList.get(i).getPayroll(), tariffListLocal.get(i).getPayroll());
            Assert.assertEquals(tariffList.get(i).getSmsprice(), tariffListLocal.get(i).getSmsprice(), 0.0002);
            Assert.assertEquals(tariffList.get(i).getCallprices().getInsidenetwork(), tariffListLocal.get(i).getCallprices().getInsidenetwork(), 0.0002);
            Assert.assertEquals(tariffList.get(i).getCallprices().getOutsidenetwork(), tariffListLocal.get(i).getCallprices().getOutsidenetwork(), 0.0002);
            Assert.assertEquals(tariffList.get(i).getCallprices().getTofixedphones(), tariffListLocal.get(i).getCallprices().getTofixedphones(), 0.0002);
            Assert.assertEquals(tariffList.get(i).getParameters().getConnectpayment(), tariffListLocal.get(i).getParameters().getConnectpayment());
            Assert.assertEquals(tariffList.get(i).getParameters().getFavouritenumbers(), tariffListLocal.get(i).getParameters().getFavouritenumbers());
            Assert.assertEquals(tariffList.get(i).getParameters().getTariffing(), tariffListLocal.get(i).getParameters().getTariffing());

        }
    }

    @Test
    public void DOM_TEST() throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Tariff> tariffListLocal = DOM.parse();
        Assert.assertEquals(this.tariffList.size(), tariffListLocal.size());
        for(int i = 0; i < tariffListLocal.size(); i++){
            Assert.assertEquals(tariffList.get(i).getName(), tariffListLocal.get(i).getName());
            Assert.assertEquals(tariffList.get(i).getPayroll(), tariffListLocal.get(i).getPayroll());
            Assert.assertEquals(tariffList.get(i).getSmsprice(), tariffListLocal.get(i).getSmsprice(), 0.0002);
            Assert.assertEquals(tariffList.get(i).getCallprices().getInsidenetwork(), tariffListLocal.get(i).getCallprices().getInsidenetwork(), 0.0002);
            Assert.assertEquals(tariffList.get(i).getCallprices().getOutsidenetwork(), tariffListLocal.get(i).getCallprices().getOutsidenetwork(), 0.0002);
            Assert.assertEquals(tariffList.get(i).getCallprices().getTofixedphones(), tariffListLocal.get(i).getCallprices().getTofixedphones(), 0.0002);
            Assert.assertEquals(tariffList.get(i).getParameters().getConnectpayment(), tariffListLocal.get(i).getParameters().getConnectpayment());
            Assert.assertEquals(tariffList.get(i).getParameters().getFavouritenumbers(), tariffListLocal.get(i).getParameters().getFavouritenumbers());
            Assert.assertEquals(tariffList.get(i).getParameters().getTariffing(), tariffListLocal.get(i).getParameters().getTariffing());

        }
    }
}
