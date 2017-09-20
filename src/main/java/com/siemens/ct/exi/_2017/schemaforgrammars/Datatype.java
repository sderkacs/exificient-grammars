//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.09.20 um 03:16:53 PM CEST 
//


package com.siemens.ct.exi._2017.schemaforgrammars;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für Datatype complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Datatype">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ct.siemens.com/exi/2017/SchemaForGrammars}DatatypeBasics">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="list" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="enumeration">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;choice>
 *                     &lt;element name="base64BinaryValue" type="{http://www.w3.org/2001/XMLSchema}base64Binary" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="hexBinaryValue" type="{http://www.w3.org/2001/XMLSchema}hexBinary" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="booleanValue" type="{http://www.w3.org/2001/XMLSchema}boolean" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="gYearValue" type="{http://www.w3.org/2001/XMLSchema}gYear" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="gYearMonthValue" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="dateValue" type="{http://www.w3.org/2001/XMLSchema}date" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="dateTimeValue" type="{http://www.w3.org/2001/XMLSchema}dateTime" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="gMonthValue" type="{http://www.w3.org/2001/XMLSchema}gMonth" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="gMonthDayValue" type="{http://www.w3.org/2001/XMLSchema}gMonthDay" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="gDayValue" type="{http://www.w3.org/2001/XMLSchema}gDay" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="timeValue" type="{http://www.w3.org/2001/XMLSchema}time" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="decimalValue" type="{http://www.w3.org/2001/XMLSchema}decimal" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="floatValue" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="integerValue" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="stringValue" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;/choice>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *         &lt;element name="schemaTypeNamespaceID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="schemaTypeLocalNameID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="baseDatatypeID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Datatype", propOrder = {
    "list",
    "enumeration",
    "schemaTypeNamespaceID",
    "schemaTypeLocalNameID",
    "baseDatatypeID"
})
public class Datatype
    extends DatatypeBasics
{

    protected Datatype.List list;
    protected Datatype.Enumeration enumeration;
    @XmlSchemaType(name = "unsignedInt")
    protected long schemaTypeNamespaceID;
    @XmlSchemaType(name = "unsignedInt")
    protected long schemaTypeLocalNameID;
    @XmlSchemaType(name = "unsignedInt")
    protected Long baseDatatypeID;

    /**
     * Ruft den Wert der list-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Datatype.List }
     *     
     */
    public Datatype.List getList() {
        return list;
    }

    /**
     * Legt den Wert der list-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Datatype.List }
     *     
     */
    public void setList(Datatype.List value) {
        this.list = value;
    }

    /**
     * Ruft den Wert der enumeration-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Datatype.Enumeration }
     *     
     */
    public Datatype.Enumeration getEnumeration() {
        return enumeration;
    }

    /**
     * Legt den Wert der enumeration-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Datatype.Enumeration }
     *     
     */
    public void setEnumeration(Datatype.Enumeration value) {
        this.enumeration = value;
    }

    /**
     * Ruft den Wert der schemaTypeNamespaceID-Eigenschaft ab.
     * 
     */
    public long getSchemaTypeNamespaceID() {
        return schemaTypeNamespaceID;
    }

    /**
     * Legt den Wert der schemaTypeNamespaceID-Eigenschaft fest.
     * 
     */
    public void setSchemaTypeNamespaceID(long value) {
        this.schemaTypeNamespaceID = value;
    }

    /**
     * Ruft den Wert der schemaTypeLocalNameID-Eigenschaft ab.
     * 
     */
    public long getSchemaTypeLocalNameID() {
        return schemaTypeLocalNameID;
    }

    /**
     * Legt den Wert der schemaTypeLocalNameID-Eigenschaft fest.
     * 
     */
    public void setSchemaTypeLocalNameID(long value) {
        this.schemaTypeLocalNameID = value;
    }

    /**
     * Ruft den Wert der baseDatatypeID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBaseDatatypeID() {
        return baseDatatypeID;
    }

    /**
     * Legt den Wert der baseDatatypeID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBaseDatatypeID(Long value) {
        this.baseDatatypeID = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="base64BinaryValue" type="{http://www.w3.org/2001/XMLSchema}base64Binary" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="hexBinaryValue" type="{http://www.w3.org/2001/XMLSchema}hexBinary" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="booleanValue" type="{http://www.w3.org/2001/XMLSchema}boolean" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="gYearValue" type="{http://www.w3.org/2001/XMLSchema}gYear" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="gYearMonthValue" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="dateValue" type="{http://www.w3.org/2001/XMLSchema}date" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="dateTimeValue" type="{http://www.w3.org/2001/XMLSchema}dateTime" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="gMonthValue" type="{http://www.w3.org/2001/XMLSchema}gMonth" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="gMonthDayValue" type="{http://www.w3.org/2001/XMLSchema}gMonthDay" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="gDayValue" type="{http://www.w3.org/2001/XMLSchema}gDay" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="timeValue" type="{http://www.w3.org/2001/XMLSchema}time" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="decimalValue" type="{http://www.w3.org/2001/XMLSchema}decimal" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="floatValue" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="integerValue" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="stringValue" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "base64BinaryValue",
        "hexBinaryValue",
        "booleanValue",
        "gYearValue",
        "gYearMonthValue",
        "dateValue",
        "dateTimeValue",
        "gMonthValue",
        "gMonthDayValue",
        "gDayValue",
        "timeValue",
        "decimalValue",
        "floatValue",
        "integerValue",
        "stringValue"
    })
    public static class Enumeration {

        protected java.util.List<byte[]> base64BinaryValue;
        @XmlElement(type = String.class)
        @XmlJavaTypeAdapter(HexBinaryAdapter.class)
        @XmlSchemaType(name = "hexBinary")
        protected java.util.List<byte[]> hexBinaryValue;
        @XmlElement(type = Boolean.class)
        protected java.util.List<Boolean> booleanValue;
        @XmlSchemaType(name = "gYear")
        protected java.util.List<XMLGregorianCalendar> gYearValue;
        @XmlSchemaType(name = "gYearMonth")
        protected java.util.List<XMLGregorianCalendar> gYearMonthValue;
        @XmlSchemaType(name = "date")
        protected java.util.List<XMLGregorianCalendar> dateValue;
        @XmlSchemaType(name = "dateTime")
        protected java.util.List<XMLGregorianCalendar> dateTimeValue;
        @XmlSchemaType(name = "gMonth")
        protected java.util.List<XMLGregorianCalendar> gMonthValue;
        @XmlSchemaType(name = "gMonthDay")
        protected java.util.List<XMLGregorianCalendar> gMonthDayValue;
        @XmlSchemaType(name = "gDay")
        protected java.util.List<XMLGregorianCalendar> gDayValue;
        @XmlSchemaType(name = "time")
        protected java.util.List<XMLGregorianCalendar> timeValue;
        protected java.util.List<BigDecimal> decimalValue;
        @XmlElement(type = Float.class)
        protected java.util.List<Float> floatValue;
        protected java.util.List<BigInteger> integerValue;
        protected java.util.List<String> stringValue;

        /**
         * Gets the value of the base64BinaryValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the base64BinaryValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBase64BinaryValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * byte[]
         * 
         */
        public java.util.List<byte[]> getBase64BinaryValue() {
            if (base64BinaryValue == null) {
                base64BinaryValue = new ArrayList<byte[]>();
            }
            return this.base64BinaryValue;
        }

        /**
         * Gets the value of the hexBinaryValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the hexBinaryValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHexBinaryValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public java.util.List<byte[]> getHexBinaryValue() {
            if (hexBinaryValue == null) {
                hexBinaryValue = new ArrayList<byte[]>();
            }
            return this.hexBinaryValue;
        }

        /**
         * Gets the value of the booleanValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the booleanValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBooleanValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Boolean }
         * 
         * 
         */
        public java.util.List<Boolean> getBooleanValue() {
            if (booleanValue == null) {
                booleanValue = new ArrayList<Boolean>();
            }
            return this.booleanValue;
        }

        /**
         * Gets the value of the gYearValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the gYearValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGYearValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XMLGregorianCalendar }
         * 
         * 
         */
        public java.util.List<XMLGregorianCalendar> getGYearValue() {
            if (gYearValue == null) {
                gYearValue = new ArrayList<XMLGregorianCalendar>();
            }
            return this.gYearValue;
        }

        /**
         * Gets the value of the gYearMonthValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the gYearMonthValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGYearMonthValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XMLGregorianCalendar }
         * 
         * 
         */
        public java.util.List<XMLGregorianCalendar> getGYearMonthValue() {
            if (gYearMonthValue == null) {
                gYearMonthValue = new ArrayList<XMLGregorianCalendar>();
            }
            return this.gYearMonthValue;
        }

        /**
         * Gets the value of the dateValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dateValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDateValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XMLGregorianCalendar }
         * 
         * 
         */
        public java.util.List<XMLGregorianCalendar> getDateValue() {
            if (dateValue == null) {
                dateValue = new ArrayList<XMLGregorianCalendar>();
            }
            return this.dateValue;
        }

        /**
         * Gets the value of the dateTimeValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dateTimeValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDateTimeValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XMLGregorianCalendar }
         * 
         * 
         */
        public java.util.List<XMLGregorianCalendar> getDateTimeValue() {
            if (dateTimeValue == null) {
                dateTimeValue = new ArrayList<XMLGregorianCalendar>();
            }
            return this.dateTimeValue;
        }

        /**
         * Gets the value of the gMonthValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the gMonthValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGMonthValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XMLGregorianCalendar }
         * 
         * 
         */
        public java.util.List<XMLGregorianCalendar> getGMonthValue() {
            if (gMonthValue == null) {
                gMonthValue = new ArrayList<XMLGregorianCalendar>();
            }
            return this.gMonthValue;
        }

        /**
         * Gets the value of the gMonthDayValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the gMonthDayValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGMonthDayValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XMLGregorianCalendar }
         * 
         * 
         */
        public java.util.List<XMLGregorianCalendar> getGMonthDayValue() {
            if (gMonthDayValue == null) {
                gMonthDayValue = new ArrayList<XMLGregorianCalendar>();
            }
            return this.gMonthDayValue;
        }

        /**
         * Gets the value of the gDayValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the gDayValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGDayValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XMLGregorianCalendar }
         * 
         * 
         */
        public java.util.List<XMLGregorianCalendar> getGDayValue() {
            if (gDayValue == null) {
                gDayValue = new ArrayList<XMLGregorianCalendar>();
            }
            return this.gDayValue;
        }

        /**
         * Gets the value of the timeValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the timeValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTimeValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XMLGregorianCalendar }
         * 
         * 
         */
        public java.util.List<XMLGregorianCalendar> getTimeValue() {
            if (timeValue == null) {
                timeValue = new ArrayList<XMLGregorianCalendar>();
            }
            return this.timeValue;
        }

        /**
         * Gets the value of the decimalValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the decimalValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDecimalValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BigDecimal }
         * 
         * 
         */
        public java.util.List<BigDecimal> getDecimalValue() {
            if (decimalValue == null) {
                decimalValue = new ArrayList<BigDecimal>();
            }
            return this.decimalValue;
        }

        /**
         * Gets the value of the floatValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the floatValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFloatValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Float }
         * 
         * 
         */
        public java.util.List<Float> getFloatValue() {
            if (floatValue == null) {
                floatValue = new ArrayList<Float>();
            }
            return this.floatValue;
        }

        /**
         * Gets the value of the integerValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the integerValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIntegerValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BigInteger }
         * 
         * 
         */
        public java.util.List<BigInteger> getIntegerValue() {
            if (integerValue == null) {
                integerValue = new ArrayList<BigInteger>();
            }
            return this.integerValue;
        }

        /**
         * Gets the value of the stringValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the stringValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStringValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public java.util.List<String> getStringValue() {
            if (stringValue == null) {
                stringValue = new ArrayList<String>();
            }
            return this.stringValue;
        }

    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class List {


    }

}
