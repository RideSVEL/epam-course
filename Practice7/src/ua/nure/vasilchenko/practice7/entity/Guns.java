
package ua.nure.vasilchenko.practice7.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Gun" type="{http://nure.ua/vasilchenko/Practice7}Gun" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "gun"
})
//@XmlRootElement(name = "Guns", namespace = "http://nure.ua/vasilchenko/Practice7")
public class Guns {

    @XmlElement(name = "Gun", required = true)
    protected List<Gun> gun;

    /**
     * Gets the value of the gun property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gun property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGun().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Gun }
     */
    public List<Gun> getGun() {
        if (gun == null) {
            gun = new ArrayList<>();
        }
        return this.gun;
    }


}
