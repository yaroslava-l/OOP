package parsers;

import tariff.Tariff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class SAX {
        public static List<Tariff> parseSAX(String fileName){
        List<Tariff> tariffList = new ArrayList<>();
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            DocHandler dh = new DocHandler();
            if (dh != null)
                parser.parse(fileName, dh);

            tariffList = dh.getNotes();
            Collections.sort(tariffList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tariffList;
        }
    }

