package parsers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tariff.Tariff;

public class DOM {

    public static ArrayList<Tariff> parse() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBiulder = factory.newDocumentBuilder();
        Document doc = documentBiulder.parse (new File ("Tariff.xml"));

        String titleEl = doc.getDocumentElement().getNodeName();

        NodeList nodeList1 = doc.getElementsByTagName("tariff");
        NodeList nodeList2 = doc.getElementsByTagName("callprices");
        NodeList nodeList3 = doc.getElementsByTagName("parameters");

        String tariffname = "", tariffing = "";
        int payroll = 0, outsidenetwork = 0, tofixedphones = 0, favouritenumbers = 0, connectpayment = 0;
        double insidenetwork = 0, smsprice = 0;

        ArrayList<Tariff> list = new ArrayList<>();

        System.out.println ("tariffname    payroll   insidenetwork  	outsidenetwork 	tofixedphones 	smsprice 	favouritenumbers  	tariffing 			connectpayment");
        int i=-1;
        int j=-1;
        int k=-1;
        while (i < nodeList1.getLength()-1){
            i++;
            Element element1 = (Element)nodeList1.item(i);

            tariffname = element1.getElementsByTagName("tariffname").item(0).getChildNodes().item(0).getNodeValue();
            payroll = Integer.parseInt(element1.getElementsByTagName("payroll").item(0).getChildNodes().item(0).getNodeValue());
            smsprice = Double.parseDouble(element1.getElementsByTagName("smsprice").item(0).getChildNodes().item(0).getNodeValue());

            if (j < nodeList2.getLength()){
                j++;
                Element element2 = (Element)nodeList2.item(j);

                insidenetwork = Double.parseDouble(element2.getElementsByTagName("insidenetwork").item(0).getChildNodes().item(0).getNodeValue());
                outsidenetwork = Integer.parseInt(element2.getElementsByTagName("outsidenetwork").item(0).getChildNodes().item(0).getNodeValue());
                tofixedphones = Integer.parseInt(element2.getElementsByTagName("tofixedphones").item(0).getChildNodes().item(0).getNodeValue());
            }

            if (k < nodeList3.getLength()){
                k++;
                Element element3 = (Element)nodeList3.item(k);

                favouritenumbers = Integer.parseInt(element3.getElementsByTagName("favouritenumbers").item(0).getChildNodes().item(0).getNodeValue());
                tariffing = element3.getElementsByTagName("tariffing").item(0).getChildNodes().item(0).getNodeValue();
                connectpayment = Integer.parseInt(element3.getElementsByTagName("connectpayment").item(0).getChildNodes().item(0).getNodeValue());

            }
            System.out.println (tariffname + "	     " + payroll + "	    " + insidenetwork + "	          	" + outsidenetwork + "	         	" + tofixedphones + "		         " + smsprice + "    	   " + favouritenumbers + "			    " + tariffing + "	         	" + connectpayment);

            Tariff tempTariff = new Tariff(tariffname, payroll, smsprice);
            tempTariff.callprices.setTofixedphones(tofixedphones);
            tempTariff.callprices.setInsidenetwork(insidenetwork);
            tempTariff.callprices.setOutsidenetwork(outsidenetwork);
            tempTariff.parametrers.setConnectpayment(connectpayment);
            tempTariff.parametrers.setFavouritenumbers(favouritenumbers);
            tempTariff.parametrers.setTariffing(tariffing);

            list.add(tempTariff);
        }

        return list;

    }

}
