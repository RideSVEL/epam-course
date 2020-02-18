package ua.nure.vasilchenko.practice7.controllers;

import ua.nure.vasilchenko.practice7.constants.Names;
import ua.nure.vasilchenko.practice7.entity.Distance;
import ua.nure.vasilchenko.practice7.entity.Gun;
import ua.nure.vasilchenko.practice7.entity.Guns;
import ua.nure.vasilchenko.practice7.entity.Handy;
import ua.nure.vasilchenko.practice7.entity.TTC;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

public class STAXController {

    private String xmlFileName;
    private Guns guns = new Guns();

    public Guns getGuns() {
        return guns;
    }

    public STAXController(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public void parse() throws XMLStreamException {
        Gun gun = null;
        TTC ttc = null;
        Distance distance = null;

        String currentElement = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);
        XMLEventReader reader = factory.createXMLEventReader(new StreamSource(xmlFileName));

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isCharacters() && event.asCharacters().isWhiteSpace()) {
                continue;
            }
            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                currentElement = startElement.getName().getLocalPart();

                if (Names.GUN.equalsTo(currentElement)) {
                    gun = new Gun();
                    continue;
                }
                if (Names.TTC.equalsTo(currentElement)) {
                    ttc = new TTC();
                    continue;
                }
                if (Names.DISTANCE.equalsTo(currentElement)) {
                    distance = new Distance();
                    continue;
                }
            }

            if (event.isCharacters()) {
                Characters characters = event.asCharacters();

                if (Names.MODEL.equalsTo(currentElement)) {
                    gun.setModel(characters.getData());
                    continue;
                }
                if (Names.HANDY.equalsTo(currentElement)) {
                    gun.setHandy(Handy.fromValue(characters.getData()));
                    continue;
                }
                if (Names.ORIGIN.equalsTo(currentElement)) {
                    gun.setOrigin(characters.getData());
                    continue;
                }
                if (Names.MATERIAL.equalsTo(currentElement)) {
                    gun.setMaterial(characters.getData());
                    continue;
                }
                if (Names.SHORT.equalsTo(currentElement) ||
                        Names.MIDDLE.equalsTo(currentElement) ||
                        Names.LONG.equalsTo(currentElement)) {
                    distance.setType(currentElement);
                    distance.setRange(Integer.parseInt(characters.getData()));
                    continue;
                }
                if (Names.SIGHTING_RANGE.equalsTo(currentElement)) {
                    ttc.setSightingRange(Integer.parseInt(characters.getData()));
                    continue;
                }
                if (Names.CLIP.equalsTo(currentElement)) {
                    ttc.setClip(Boolean.parseBoolean(characters.getData()));
                    continue;
                }
                if (Names.OPTICS.equalsTo(currentElement)) {
                    ttc.setOptics(Boolean.parseBoolean(characters.getData()));
                    continue;
                }
            }

            if (event.isEndElement()) {
                EndElement endElement = event.asEndElement();
                String localName = endElement.getName().getLocalPart();

                if (Names.GUN.equalsTo(localName)) {
                    guns.getGun().add(gun);
                    continue;
                }
                if (Names.TTC.equalsTo(localName)) {
                    gun.setTTC(ttc);
                    continue;
                }
                if (Names.DISTANCE.equalsTo(localName)) {
                    ttc.setDistance(distance);
                    continue;
                }
            }
        }
        reader.close();
    }
}
