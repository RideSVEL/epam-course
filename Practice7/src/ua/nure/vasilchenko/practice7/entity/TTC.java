
package ua.nure.vasilchenko.practice7.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigInteger;


/**
 * <p>Java class for TTC complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TTC">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Distance" type="{http://nure.ua/vasilchenko/Practice7}Distance"/>
 *         &lt;element name="SightingRange" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Clip" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Optics" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "TTC", namespace = "http://nure.ua/vasilchenko/Practice7", propOrder = {
//        "distance",
//        "sightingRange",
//        "clip",
//        "optics"
//})
public class TTC {

    @XmlElement(name = "Distance", required = true)
    protected Distance distance;
    @XmlElement(name = "SightingRange", required = true)
    protected int sightingRange;
    @XmlElement(name = "Clip")
    protected boolean clip;
    @XmlElement(name = "Optics")
    protected boolean optics;

    /**
     * Gets the value of the distance property.
     *
     * @return possible object is
     * {@link Distance }
     */
    public Distance getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     *
     * @param value allowed object is
     *              {@link Distance }
     */
    public void setDistance(Distance value) {
        this.distance = value;
    }

    /**
     * Gets the value of the sightingRange property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public int getSightingRange() {
        return sightingRange;
    }

    /**
     * Sets the value of the sightingRange property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setSightingRange(int value) {
        this.sightingRange = value;
    }

    /**
     * Gets the value of the clip property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isClip() {
        return clip;
    }

    /**
     * Sets the value of the clip property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setClip(Boolean value) {
        this.clip = value;
    }

    /**
     * Gets the value of the optics property.
     */
    public boolean isOptics() {
        return optics;
    }

    /**
     * Sets the value of the optics property.
     */
    public void setOptics(boolean value) {
        this.optics = value;
    }

}
