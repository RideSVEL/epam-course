package ua.nure.vasilchenko.practice7;

import org.xml.sax.SAXException;
import ua.nure.vasilchenko.practice7.constants.Constants;
import ua.nure.vasilchenko.practice7.controllers.DOMController;
import ua.nure.vasilchenko.practice7.controllers.SAXControlle;
import ua.nure.vasilchenko.practice7.controllers.STAXController;
import ua.nure.vasilchenko.practice7.entity.Guns;
import ua.nure.vasilchenko.practice7.util.Sorts;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SAXException,
            ParserConfigurationException, TransformerException, XMLStreamException {

        if (args.length != 1) {
            System.out.println("Enter file with questions.");
            return;
        }

        String xmlFileName = args[0];

        //dom
        DOMController dom = new DOMController(xmlFileName);
        dom.parse(true);
        Guns guns = dom.getGuns();
        Sorts.sortGunsByModel(guns);
        DOMController.saveToXML(guns, Constants.OUTPUT_DOM_XML_FILE);

        //sax
        SAXControlle sax = new SAXControlle(xmlFileName);
        sax.parse(true);
        guns = sax.getGuns();
        Sorts.sortGunsByOrigin(guns);
        DOMController.saveToXML(guns, Constants.OUTPUT_SAX_XML_FILE);

        //stax
        STAXController stax = new STAXController(xmlFileName);
        stax.parse();
        guns = stax.getGuns();
        Sorts.sortGunsBySightingRange(guns);
        DOMController.saveToXML(guns, Constants.OUTPUT_STAX_XML_FILE);
    }
}
