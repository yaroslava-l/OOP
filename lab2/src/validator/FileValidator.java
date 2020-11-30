package validator;

import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class FileValidator {
    public static void main(String[] args) {
        System.out.println( validateXMLDocument("Tariff.xml", "Tariff.xsd"));
    }
    private static Logger log;



    public static boolean validateXMLDocument(String pathToXmlDocument, String pathToXsdFile) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = factory.newSchema(new File(pathToXsdFile));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(pathToXmlDocument)));
        }  catch (IOException e) {
            log.info(String.format("Validation error2 : %s", e.getMessage()));
            return false;
        }
        catch (SAXException e) {
            log.info(String.format("Validation error1 : %s", e.getMessage()));
            return false; }
        return true;
    }

    static { log = Logger.getLogger(FileValidator.class.getName()); }
}
