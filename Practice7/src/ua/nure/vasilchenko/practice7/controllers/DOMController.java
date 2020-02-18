package ua.nure.vasilchenko.practice7.controllers;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.vasilchenko.practice7.constants.Constants;
import ua.nure.vasilchenko.practice7.constants.Names;
import ua.nure.vasilchenko.practice7.entity.Distance;
import ua.nure.vasilchenko.practice7.entity.Gun;
import ua.nure.vasilchenko.practice7.entity.Guns;
import ua.nure.vasilchenko.practice7.entity.Handy;
import ua.nure.vasilchenko.practice7.entity.TTC;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class DOMController {
    private String xmlFileName;
    private Guns guns;

    public DOMController(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public Guns getGuns() {
        return guns;
    }

    public void parse(boolean validate) throws ParserConfigurationException, IOException, org.xml.sax.SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        if (validate) {
            dbf.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
            dbf.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }
        DocumentBuilder db = dbf.newDocumentBuilder();
        db.setErrorHandler(new DefaultHandler() {
            @Override
            public void error(SAXParseException e) throws SAXParseException {
                throw e;
            }
        });

        Document doc = db.parse(xmlFileName);
        Element root = doc.getDocumentElement();
        guns = new Guns();
        NodeList gunsNodes = root.getElementsByTagName(Names.GUN.value());
        for (int i = 0; i < gunsNodes.getLength(); ++i) {
            Gun gun = getGun(gunsNodes.item(i));
            guns.getGun().add(gun);
        }
    }


    private Gun getGun(Node gunNode) {
        Gun gun = new Gun();
        Element gElement = (Element) gunNode;
        //setting up model
        Node modelNode = gElement.getElementsByTagName(Names.MODEL.value()).item(0);
        gun.setModel(modelNode.getTextContent());
        //Handy
        Node handyNode = gElement.getElementsByTagName(Names.HANDY.value()).item(0);
        gun.setHandy(Handy.fromValue(handyNode.getTextContent()));
        //Origin
        Node originNode = gElement.getElementsByTagName(Names.ORIGIN.value()).item(0);
        gun.setOrigin(originNode.getTextContent());
        //Material
        Node materialNode = gElement.getElementsByTagName(Names.MATERIAL.value()).item(0);
        gun.setMaterial(materialNode.getTextContent());
        // TTC
        Node ttcNode = gElement.getElementsByTagName(Names.TTC.value()).item(0);
        gun.setTTC(getTTC(ttcNode));

        return gun;
    }

    public TTC getTTC(Node ttcNode) {
        TTC ttc = new TTC();
        Element tElement = (Element) ttcNode;

        Element distanceNode = (Element) tElement.getElementsByTagName(Names.DISTANCE.value()).item(0);
        NodeList distanceChildNodes = distanceNode.getChildNodes();
        for (int i = 0; i < distanceChildNodes.getLength(); ++i) {
            if (!distanceChildNodes.item(i).getTextContent().trim().isEmpty()) {
                ttc.setDistance(new Distance
                        (distanceChildNodes.item(i).getNodeName(),
                                Integer.parseInt(distanceChildNodes.item(i).getTextContent())));
                break;
            }
        }

        //Sighting Range
        Node rangeNode = tElement.getElementsByTagName(Names.SIGHTING_RANGE.value()).item(0);
        ttc.setSightingRange(Integer.parseInt(rangeNode.getTextContent()));
        //Optics
        Node opticsNode = tElement.getElementsByTagName(Names.OPTICS.value()).item(0);
        ttc.setOptics(Boolean.parseBoolean(opticsNode.getTextContent()));
        //Collar
        Node clipNode = tElement.getElementsByTagName(Names.CLIP.value()).item(0);
        ttc.setClip(Boolean.parseBoolean(clipNode.getTextContent()));


        return ttc;
    }


    public static Document getDocument(Guns guns) throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();

        Element element = document.createElement(Names.GUNS.value());
        document.appendChild(element);

        for (Gun gun : guns.getGun()) {
            Element gElement = document.createElement(Names.GUN.value());
            element.appendChild(gElement);
            //Model
            Element modelElement = document.createElement(Names.MODEL.value());
            modelElement.setTextContent(gun.getModel());
            gElement.appendChild(modelElement);
            //Handy
            Element handyElement = document.createElement(Names.HANDY.value());
            handyElement.setTextContent(gun.getHandy().value());
            gElement.appendChild(handyElement);
            //Origin
            Element originElement = document.createElement(Names.ORIGIN.value());
            originElement.setTextContent(gun.getOrigin());
            gElement.appendChild(originElement);
            //Material
            Element materialElement = document.createElement(Names.MATERIAL.value());
            materialElement.setTextContent(gun.getMaterial());
            gElement.appendChild(materialElement);

            // TTC
            Element ttcElement = document.createElement(Names.TTC.value());
            gElement.appendChild(ttcElement);
            //Distance
            Element distanceElement = document.createElement(Names.DISTANCE.value());
            Element distanceChildElement = document.createElement(gun.getTTC().getDistance().getType());
            distanceChildElement.setTextContent(String.valueOf(gun.getTTC().getDistance().getRange()));
            distanceElement.appendChild(distanceChildElement);
            ttcElement.appendChild(distanceElement);
            //Sighting Range
            Element rangeElement = document.createElement(Names.SIGHTING_RANGE.value());
            rangeElement.setTextContent(String.valueOf(gun.getTTC().getSightingRange()));
            ttcElement.appendChild(rangeElement);
            //Clip
            Element clipElement = document.createElement(Names.CLIP.value());
            clipElement.setTextContent(String.valueOf(gun.getTTC().isClip()));
            ttcElement.appendChild(clipElement);
            //Optics
            Element opticsElement = document.createElement(Names.OPTICS.value());
            opticsElement.setTextContent(String.valueOf(gun.getTTC().isOptics()));
            ttcElement.appendChild(opticsElement);
        }
        return document;
    }


    public static void saveToXML(Guns guns, String xmlFileName) throws ParserConfigurationException,
            TransformerException {
        saveToXML(getDocument(guns), xmlFileName);
    }

    public static void saveToXML(Document document, String xmlFileName) throws TransformerException {
        StreamResult result = new StreamResult(new File(xmlFileName));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        transformer.transform(new DOMSource(document), result);
    }

}
