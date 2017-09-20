//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.09.20 um 03:16:53 PM CEST 
//


package com.siemens.ct.exi._2017.schemaforgrammars;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für grammarType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="grammarType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Document"/>
 *     &lt;enumeration value="DocContent"/>
 *     &lt;enumeration value="DocEnd"/>
 *     &lt;enumeration value="Fragment"/>
 *     &lt;enumeration value="FragmentContent"/>
 *     &lt;enumeration value="FirstStartTagContent"/>
 *     &lt;enumeration value="StartTagContent"/>
 *     &lt;enumeration value="ElementContent"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "grammarType")
@XmlEnum
public enum GrammarType {

    @XmlEnumValue("Document")
    DOCUMENT("Document"),
    @XmlEnumValue("DocContent")
    DOC_CONTENT("DocContent"),
    @XmlEnumValue("DocEnd")
    DOC_END("DocEnd"),
    @XmlEnumValue("Fragment")
    FRAGMENT("Fragment"),
    @XmlEnumValue("FragmentContent")
    FRAGMENT_CONTENT("FragmentContent"),
    @XmlEnumValue("FirstStartTagContent")
    FIRST_START_TAG_CONTENT("FirstStartTagContent"),
    @XmlEnumValue("StartTagContent")
    START_TAG_CONTENT("StartTagContent"),
    @XmlEnumValue("ElementContent")
    ELEMENT_CONTENT("ElementContent");
    private final String value;

    GrammarType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GrammarType fromValue(String v) {
        for (GrammarType c: GrammarType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
