package parsers;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import tariff.Tariff;

public class DocHandler extends DefaultHandler{
    List tarifflist = new ArrayList();
    Tariff curr = new Tariff();
    int current = -1;

    public List getNotes() {
        return tarifflist;
    }



    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (qName.equals("tariff")) {
            curr = new Tariff();
            curr.setId(attrs.getValue(0));
        }
        if (qName.equals("tariffname"))
            current = 1;
        else if (qName.equals("payroll"))
            current = 2;
        else if (qName.equals("insidenetwork"))
            current = 3;
        else if (qName.equals("outsidenetwork"))
            current = 4;
        else if (qName.equals("tofixedphones"))
            current = 5;
        else if (qName.equals("smsprice"))
            current = 6;
        else if (qName.equals("favouritenumbers"))
            current = 7;
        else if (qName.equals("tariffing"))
            current = 8;
        else if (qName.equals("connectpayment"))
            current = 9;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("tariff"))
            tarifflist.add(curr);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length);
        try {
            switch (current) {
                case 1:
                    curr.setName(s);
                    break;
                case 2:
                    curr.setPayroll(Integer.parseInt(s));
                    break;
                case 3:
                    curr.callprices.setInsidenetwork(Double.parseDouble(s));
                    break;
                case 4:
                    curr.callprices.setOutsidenetwork(Integer.parseInt(s));
                    break;
                case 5:
                    curr.callprices.setTofixedphones(Integer.parseInt(s));
                    break;
                case 6:
                    curr.setSmsprice(Double.parseDouble(s));
                    break;
                case 7:
                    curr.parametrers.setFavouritenumbers(Integer.parseInt(s));
                    break;
                case 8:
                    curr.parametrers.setTariffing(s);
                    break;
                case 9:
                    curr.parametrers.setConnectpayment(Integer.parseInt(s));
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        } current = -1;
    }
}

