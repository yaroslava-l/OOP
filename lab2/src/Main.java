import org.xml.sax.SAXException;
import parsers.DOM;
import parsers.DocHandler;
import parsers.SAX;
import parsers.StAX;
import tariff.Tariff;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        System.out.println("\n\tDOM");
        ArrayList<Tariff> list = DOM.parse();

        System.out.println("\n\tStAX");
        List<Tariff> tariffList = StAX.parseXML("Tariff.xml");
        for (int i = 0; i < tariffList.size(); i++)
            System.out.println(((Tariff) tariffList.get(i)).toString());

        System.out.println("\n\tSAX");
            List<Tariff> trlist= SAX.parseSAX("Tariff.xml");
            for (int i = 0; i < tariffList.size(); i++)
                System.out.println(((Tariff) trlist.get(i)).toString());


    }
}

