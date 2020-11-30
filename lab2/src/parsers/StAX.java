package parsers;

import tariff.Tariff;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAX  {


    public static List<Tariff> parseXML(String fileName) {
        List<Tariff> tariffList = new ArrayList<>();
        Tariff tariff = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlreader = factory.createXMLEventReader(new FileInputStream(fileName));
            while (xmlreader.hasNext()) {
                XMLEvent xmlEvent = xmlreader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("tariff")) {
                        tariff = new Tariff();
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            xmlEvent=xmlreader.nextEvent();
                            //tariff.setId(xmlEvent.asCharacters().getData());
                        }
                    } else if (startElement.getName().getLocalPart().equals("insidenetwork")) {
                        xmlEvent=xmlreader.nextEvent();
                        tariff.callprices.setInsidenetwork(Double.parseDouble(xmlEvent.asCharacters().getData()));
                        //System.out.println("insidenetwork: "+xmlEvent);

                    } else if (startElement.getName().getLocalPart().equals("tariffname")) {
                        xmlEvent = xmlreader.nextEvent();
                        tariff.setName(xmlEvent.asCharacters().getData());
                        //System.out.println("tariffname: "+xmlEvent);
                    }
                    else if (startElement.getName().getLocalPart().equals("payroll")) {
                        xmlEvent = xmlreader.nextEvent();
                        tariff.setPayroll(Integer.parseInt(xmlEvent.asCharacters().getData()));
                       // System.out.println("payroll: "+xmlEvent);
                    }
                    else if (startElement.getName().getLocalPart().equals("outsidenetwork")) {
                        xmlEvent = xmlreader.nextEvent();
                        tariff.callprices.setOutsidenetwork(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        //System.out.println("outsidenetwork: "+xmlEvent);

                    }
                    else if (startElement.getName().getLocalPart().equals("tofixedphones")) {
                        xmlEvent = xmlreader.nextEvent();
                        tariff.callprices.setTofixedphones(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        //System.out.println("tofixedphones: "+xmlEvent);

                    }
                    else if (startElement.getName().getLocalPart().equals("smsprice")) {
                        xmlEvent = xmlreader.nextEvent();
                        tariff.setSmsprice(Double.parseDouble(xmlEvent.asCharacters().getData()));
                        //System.out.println("smsprice: "+xmlEvent);

                    }
                    else if (startElement.getName().getLocalPart().equals("favouritenumbers")) {
                        xmlEvent = xmlreader.nextEvent();
                        tariff.parametrers.setFavouritenumbers(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        //System.out.println("favouritenumbers: "+xmlEvent);
                    }
                    else if (startElement.getName().getLocalPart().equals("tariffing")) {
                        xmlEvent = xmlreader.nextEvent();
                        tariff.parametrers.setTariffing(xmlEvent.asCharacters().getData());
                        //System.out.println("tariffing: "+xmlEvent);
                    }
                    else if (startElement.getName().getLocalPart().equals("connectpayment")) {
                        xmlEvent = xmlreader.nextEvent();
                        tariff.parametrers.setConnectpayment(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        //System.out.println("connectpayment: "+xmlEvent);
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("tariff")) {
                        tariffList.add(tariff);
                    }
                }
            }

        } catch (XMLStreamException | FileNotFoundException exc) {
            exc.printStackTrace();
        }

        return tariffList;
    }
}
