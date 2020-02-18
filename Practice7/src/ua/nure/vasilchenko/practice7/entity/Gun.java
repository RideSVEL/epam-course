
package ua.nure.vasilchenko.practice7.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;


/**
 * <p>Java class for Gun complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Gun">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Model" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Handy" type="{http://nure.ua/vasilchenko/Practice7}Handy"/>
 *         &lt;element name="Origin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TTC" type="{http://nure.ua/vasilchenko/Practice7}TTC"/>
 *         &lt;element name="Material" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "Gun", namespace = "http://nure.ua/vasilchenko/Practice7", propOrder = {
//        "model",
//        "handy",
//        "origin",
//        "ttc",
//        "material"
//})
public class Gun {

    @XmlElement(name = "Model", required = true)
    protected String model;
    @XmlElement(name = "Handy", required = true)
    @XmlSchemaType(name = "string")
    protected Handy handy;
    @XmlElement(name = "Origin", required = true)
    protected String origin;
    @XmlElement(name = "TTC", required = true)
    protected TTC ttc;
    @XmlElement(name = "Material", required = true)
    protected String material;

    /**
     * Gets the value of the model property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the handy property.
     *
     * @return possible object is
     * {@link Handy }
     */
    public Handy getHandy() {
        return handy;
    }

    /**
     * Sets the value of the handy property.
     *
     * @param value allowed object is
     *              {@link Handy }
     */
    public void setHandy(Handy value) {
        this.handy = value;
    }

    /**
     * Gets the value of the origin property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * Gets the value of the ttc property.
     *
     * @return possible object is
     * {@link TTC }
     */
    public TTC getTTC() {
        return ttc;
    }

    /**
     * Sets the value of the ttc property.
     *
     * @param value allowed object is
     *              {@link TTC }
     */
    public void setTTC(TTC value) {
        this.ttc = value;
    }

    /**
     * Gets the value of the material property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets the value of the material property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMaterial(String value) {
        this.material = value;
    }

}
