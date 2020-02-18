package ua.nure.vasilchenko.practice7.controllers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.vasilchenko.practice7.constants.Constants;
import ua.nure.vasilchenko.practice7.constants.Names;
import ua.nure.vasilchenko.practice7.entity.Distance;
import ua.nure.vasilchenko.practice7.entity.Gun;
import ua.nure.vasilchenko.practice7.entity.Guns;
import ua.nure.vasilchenko.practice7.entity.Handy;
import ua.nure.vasilchenko.practice7.entity.TTC;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXControlle extends DefaultHandler {

    private String xmlFileName;
    private String currentElement;

    private Guns guns;
    private Gun gun;
    private TTC ttc;
    private Distance distance;

    public Guns getGuns() {
        return guns;
    }

    public SAXControlle(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public void parse(boolean validate) throws SAXException, ParserConfigurationException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        if (validate) {
            factory.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
            factory.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }
        factory.newSAXParser().parse(xmlFileName, this);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        throw e;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = localName;
        if (Names.GUNS.equalsTo(currentElement)) {
            guns = new Guns();
            return;
        }
        if (Names.GUN.equalsTo(currentElement)) {
            gun = new Gun();
            return;
        }
        if (Names.TTC.equalsTo(currentElement)) {
            ttc = new TTC();
            return;
        }
        if (Names.DISTANCE.equalsTo(currentElement)) {
            distance = new Distance();
            return;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String elementText = new String(ch, start, length).trim();
        if (elementText.isEmpty()) {
            return;
        }
        if (Names.MODEL.equalsTo(currentElement)) {
            gun.setModel(elementText);
            return;
        }
        if (Names.HANDY.equalsTo(currentElement)) {
            gun.setHandy(Handy.fromValue(elementText));
            return;
        }
        if (Names.ORIGIN.equalsTo(currentElement)) {
            gun.setOrigin(elementText);
            return;
        }
        if (Names.MATERIAL.equalsTo(currentElement)) {
            gun.setMaterial(elementText);
            return;
        }
        if (Names.SHORT.equalsTo(currentElement)) {
            distance.setType(Names.SHORT.value());
            distance.setRange(Integer.parseInt(elementText));
            return;
        }
        if (Names.MIDDLE.equalsTo(currentElement)) {
            distance.setType(Names.MIDDLE.value());
            distance.setRange(Integer.parseInt(elementText));
            return;
        }
        if (Names.LONG.equalsTo(currentElement)) {
            distance.setType(Names.LONG.value());
            distance.setRange(Integer.parseInt(elementText));
            return;
        }
        if (Names.SIGHTING_RANGE.equalsTo(currentElement)) {
            ttc.setSightingRange(Integer.parseInt(elementText));
            return;
        }
        if (Names.CLIP.equalsTo(currentElement)) {
            ttc.setClip(Boolean.parseBoolean(elementText));
            return;
        }
        if (Names.OPTICS.equalsTo(currentElement)) {
            ttc.setOptics(Boolean.parseBoolean(elementText));
            return;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (Names.GUN.equalsTo(localName)) {
            guns.getGun().add(gun);
            return;
        }
        if (Names.TTC.equalsTo(localName)) {
            gun.setTTC(ttc);
            return;
        }
        if (Names.DISTANCE.equalsTo(localName)) {
            ttc.setDistance(distance);
            return;
        }
    }
}
