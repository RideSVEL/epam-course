
package ua.nure.vasilchenko.practice7.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Handy.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Handy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;minLength value="1"/>
 *     &lt;enumeration value="one-handed"/>
 *     &lt;enumeration value="two-handed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "Handy", namespace = "http://nure.ua/vasilchenko/Practice7")
@XmlEnum
public enum Handy {

    @XmlEnumValue("one-handed")
    ONE_HANDED("one-handed"),
    @XmlEnumValue("two-handed")
    TWO_HANDED("two-handed");
    private final String value;

    Handy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Handy fromValue(String v) {
        for (Handy c : Handy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
