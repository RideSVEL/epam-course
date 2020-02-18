package ua.nure.vasilchenko.practice7;

import org.xml.sax.SAXException;
import ua.nure.vasilchenko.practice7.constants.Constants;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws SAXException, TransformerException, ParserConfigurationException, IOException, XMLStreamException {
        Main.main(new String[]{Constants.INPUT_XML_FILE});
    }
}
