//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.09.20 um 03:16:53 PM CEST 
//


package com.siemens.ct.exi._2017.schemaforgrammars;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für DatatypeBasics complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DatatypeBasics">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="base64Binary">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="hexBinary">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="boolean">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice minOccurs="0">
 *                   &lt;element name="patternFacet">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="dateAndTime">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="dateTime">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="time">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="date">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="gYearMonth">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="gYear">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="gMonthDay">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="gDay">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="gMonth">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="decimal">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="double">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="integer">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice minOccurs="0">
 *                   &lt;element name="unsignedInteger">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="nBitUnsignedInteger">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="lowerBound" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                             &lt;element name="upperBound" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="string">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice minOccurs="0">
 *                   &lt;element name="restrictedCharSet">
 *                     &lt;simpleType>
 *                       &lt;list itemType="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatatypeBasics", propOrder = {
    "base64Binary",
    "hexBinary",
    "_boolean",
    "dateAndTime",
    "decimal",
    "_double",
    "integer",
    "string"
})
@XmlSeeAlso({
    Datatype.class
})
public class DatatypeBasics {

    protected DatatypeBasics.Base64Binary base64Binary;
    protected DatatypeBasics.HexBinary hexBinary;
    @XmlElement(name = "boolean")
    protected DatatypeBasics.Boolean _boolean;
    protected DatatypeBasics.DateAndTime dateAndTime;
    protected DatatypeBasics.Decimal decimal;
    @XmlElement(name = "double")
    protected DatatypeBasics.Double _double;
    protected DatatypeBasics.Integer integer;
    protected DatatypeBasics.String string;

    /**
     * Ruft den Wert der base64Binary-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DatatypeBasics.Base64Binary }
     *     
     */
    public DatatypeBasics.Base64Binary getBase64Binary() {
        return base64Binary;
    }

    /**
     * Legt den Wert der base64Binary-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DatatypeBasics.Base64Binary }
     *     
     */
    public void setBase64Binary(DatatypeBasics.Base64Binary value) {
        this.base64Binary = value;
    }

    /**
     * Ruft den Wert der hexBinary-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DatatypeBasics.HexBinary }
     *     
     */
    public DatatypeBasics.HexBinary getHexBinary() {
        return hexBinary;
    }

    /**
     * Legt den Wert der hexBinary-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DatatypeBasics.HexBinary }
     *     
     */
    public void setHexBinary(DatatypeBasics.HexBinary value) {
        this.hexBinary = value;
    }

    /**
     * Ruft den Wert der boolean-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DatatypeBasics.Boolean }
     *     
     */
    public DatatypeBasics.Boolean getBoolean() {
        return _boolean;
    }

    /**
     * Legt den Wert der boolean-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DatatypeBasics.Boolean }
     *     
     */
    public void setBoolean(DatatypeBasics.Boolean value) {
        this._boolean = value;
    }

    /**
     * Ruft den Wert der dateAndTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DatatypeBasics.DateAndTime }
     *     
     */
    public DatatypeBasics.DateAndTime getDateAndTime() {
        return dateAndTime;
    }

    /**
     * Legt den Wert der dateAndTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DatatypeBasics.DateAndTime }
     *     
     */
    public void setDateAndTime(DatatypeBasics.DateAndTime value) {
        this.dateAndTime = value;
    }

    /**
     * Ruft den Wert der decimal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DatatypeBasics.Decimal }
     *     
     */
    public DatatypeBasics.Decimal getDecimal() {
        return decimal;
    }

    /**
     * Legt den Wert der decimal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DatatypeBasics.Decimal }
     *     
     */
    public void setDecimal(DatatypeBasics.Decimal value) {
        this.decimal = value;
    }

    /**
     * Ruft den Wert der double-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DatatypeBasics.Double }
     *     
     */
    public DatatypeBasics.Double getDouble() {
        return _double;
    }

    /**
     * Legt den Wert der double-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DatatypeBasics.Double }
     *     
     */
    public void setDouble(DatatypeBasics.Double value) {
        this._double = value;
    }

    /**
     * Ruft den Wert der integer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DatatypeBasics.Integer }
     *     
     */
    public DatatypeBasics.Integer getInteger() {
        return integer;
    }

    /**
     * Legt den Wert der integer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DatatypeBasics.Integer }
     *     
     */
    public void setInteger(DatatypeBasics.Integer value) {
        this.integer = value;
    }

    /**
     * Ruft den Wert der string-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DatatypeBasics.String }
     *     
     */
    public DatatypeBasics.String getString() {
        return string;
    }

    /**
     * Legt den Wert der string-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DatatypeBasics.String }
     *     
     */
    public void setString(DatatypeBasics.String value) {
        this.string = value;
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
    public static class Base64Binary {


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
     *       &lt;choice minOccurs="0">
     *         &lt;element name="patternFacet">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "patternFacet"
    })
    public static class Boolean {

        protected DatatypeBasics.Boolean.PatternFacet patternFacet;

        /**
         * Ruft den Wert der patternFacet-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link DatatypeBasics.Boolean.PatternFacet }
         *     
         */
        public DatatypeBasics.Boolean.PatternFacet getPatternFacet() {
            return patternFacet;
        }

        /**
         * Legt den Wert der patternFacet-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link DatatypeBasics.Boolean.PatternFacet }
         *     
         */
        public void setPatternFacet(DatatypeBasics.Boolean.PatternFacet value) {
            this.patternFacet = value;
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
        public static class PatternFacet {


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
     *       &lt;choice>
     *         &lt;element name="dateTime">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="time">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="date">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="gYearMonth">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="gYear">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="gMonthDay">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="gDay">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="gMonth">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "dateTime",
        "time",
        "date",
        "gYearMonth",
        "gYear",
        "gMonthDay",
        "gDay",
        "gMonth"
    })
    public static class DateAndTime {

        protected DatatypeBasics.DateAndTime.DateTime dateTime;
        protected DatatypeBasics.DateAndTime.Time time;
        protected DatatypeBasics.DateAndTime.Date date;
        protected DatatypeBasics.DateAndTime.GYearMonth gYearMonth;
        protected DatatypeBasics.DateAndTime.GYear gYear;
        protected DatatypeBasics.DateAndTime.GMonthDay gMonthDay;
        protected DatatypeBasics.DateAndTime.GDay gDay;
        protected DatatypeBasics.DateAndTime.GMonth gMonth;

        /**
         * Ruft den Wert der dateTime-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link DatatypeBasics.DateAndTime.DateTime }
         *     
         */
        public DatatypeBasics.DateAndTime.DateTime getDateTime() {
            return dateTime;
        }

        /**
         * Legt den Wert der dateTime-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link DatatypeBasics.DateAndTime.DateTime }
         *     
         */
        public void setDateTime(DatatypeBasics.DateAndTime.DateTime value) {
            this.dateTime = value;
        }

        /**
         * Ruft den Wert der time-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link DatatypeBasics.DateAndTime.Time }
         *     
         */
        public DatatypeBasics.DateAndTime.Time getTime() {
            return time;
        }

        /**
         * Legt den Wert der time-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link DatatypeBasics.DateAndTime.Time }
         *     
         */
        public void setTime(DatatypeBasics.DateAndTime.Time value) {
            this.time = value;
        }

        /**
         * Ruft den Wert der date-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link DatatypeBasics.DateAndTime.Date }
         *     
         */
        public DatatypeBasics.DateAndTime.Date getDate() {
            return date;
        }

        /**
         * Legt den Wert der date-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link DatatypeBasics.DateAndTime.Date }
         *     
         */
        public void setDate(DatatypeBasics.DateAndTime.Date value) {
            this.date = value;
        }

        /**
         * Ruft den Wert der gYearMonth-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link DatatypeBasics.DateAndTime.GYearMonth }
         *     
         */
        public DatatypeBasics.DateAndTime.GYearMonth getGYearMonth() {
            return gYearMonth;
        }

        /**
         * Legt den Wert der gYearMonth-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link DatatypeBasics.DateAndTime.GYearMonth }
         *     
         */
        public void setGYearMonth(DatatypeBasics.DateAndTime.GYearMonth value) {
            this.gYearMonth = value;
        }

        /**
         * Ruft den Wert der gYear-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link DatatypeBasics.DateAndTime.GYear }
         *     
         */
        public DatatypeBasics.DateAndTime.GYear getGYear() {
            return gYear;
        }

        /**
         * Legt den Wert der gYear-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link DatatypeBasics.DateAndTime.GYear }
         *     
         */
        public void setGYear(DatatypeBasics.DateAndTime.GYear value) {
            this.gYear = value;
        }

        /**
         * Ruft den Wert der gMonthDay-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link DatatypeBasics.DateAndTime.GMonthDay }
         *     
         */
        public DatatypeBasics.DateAndTime.GMonthDay getGMonthDay() {
            return gMonthDay;
        }

        /**
         * Legt den Wert der gMonthDay-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link DatatypeBasics.DateAndTime.GMonthDay }
         *     
         */
        public void setGMonthDay(DatatypeBasics.DateAndTime.GMonthDay value) {
            this.gMonthDay = value;
        }

        /**
         * Ruft den Wert der gDay-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link DatatypeBasics.DateAndTime.GDay }
         *     
         */
        public DatatypeBasics.DateAndTime.GDay getGDay() {
            return gDay;
        }

        /**
         * Legt den Wert der gDay-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link DatatypeBasics.DateAndTime.GDay }
         *     
         */
        public void setGDay(DatatypeBasics.DateAndTime.GDay value) {
            this.gDay = value;
        }

        /**
         * Ruft den Wert der gMonth-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link DatatypeBasics.DateAndTime.GMonth }
         *     
         */
        public DatatypeBasics.DateAndTime.GMonth getGMonth() {
            return gMonth;
        }

        /**
         * Legt den Wert der gMonth-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link DatatypeBasics.DateAndTime.GMonth }
         *     
         */
        public void setGMonth(DatatypeBasics.DateAndTime.GMonth value) {
            this.gMonth = value;
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
        public static class Date {


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
        public static class DateTime {


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
        public static class GDay {


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
        public static class GMonth {


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
        public static class GMonthDay {


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
        public static class GYear {


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
        public static class GYearMonth {


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
        public static class Time {


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
    public static class Decimal {


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
    public static class Double {


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
    public static class HexBinary {


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
     *       &lt;choice minOccurs="0">
     *         &lt;element name="unsignedInteger">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="nBitUnsignedInteger">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="lowerBound" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *                   &lt;element name="upperBound" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "unsignedInteger",
        "nBitUnsignedInteger"
    })
    public static class Integer {

        protected DatatypeBasics.Integer.UnsignedInteger unsignedInteger;
        protected DatatypeBasics.Integer.NBitUnsignedInteger nBitUnsignedInteger;

        /**
         * Ruft den Wert der unsignedInteger-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link DatatypeBasics.Integer.UnsignedInteger }
         *     
         */
        public DatatypeBasics.Integer.UnsignedInteger getUnsignedInteger() {
            return unsignedInteger;
        }

        /**
         * Legt den Wert der unsignedInteger-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link DatatypeBasics.Integer.UnsignedInteger }
         *     
         */
        public void setUnsignedInteger(DatatypeBasics.Integer.UnsignedInteger value) {
            this.unsignedInteger = value;
        }

        /**
         * Ruft den Wert der nBitUnsignedInteger-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link DatatypeBasics.Integer.NBitUnsignedInteger }
         *     
         */
        public DatatypeBasics.Integer.NBitUnsignedInteger getNBitUnsignedInteger() {
            return nBitUnsignedInteger;
        }

        /**
         * Legt den Wert der nBitUnsignedInteger-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link DatatypeBasics.Integer.NBitUnsignedInteger }
         *     
         */
        public void setNBitUnsignedInteger(DatatypeBasics.Integer.NBitUnsignedInteger value) {
            this.nBitUnsignedInteger = value;
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
         *       &lt;sequence>
         *         &lt;element name="lowerBound" type="{http://www.w3.org/2001/XMLSchema}integer"/>
         *         &lt;element name="upperBound" type="{http://www.w3.org/2001/XMLSchema}integer"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "lowerBound",
            "upperBound"
        })
        public static class NBitUnsignedInteger {

            @XmlElement(required = true)
            protected BigInteger lowerBound;
            @XmlElement(required = true)
            protected BigInteger upperBound;

            /**
             * Ruft den Wert der lowerBound-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getLowerBound() {
                return lowerBound;
            }

            /**
             * Legt den Wert der lowerBound-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setLowerBound(BigInteger value) {
                this.lowerBound = value;
            }

            /**
             * Ruft den Wert der upperBound-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getUpperBound() {
                return upperBound;
            }

            /**
             * Legt den Wert der upperBound-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setUpperBound(BigInteger value) {
                this.upperBound = value;
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
        public static class UnsignedInteger {


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
     *       &lt;choice minOccurs="0">
     *         &lt;element name="restrictedCharSet">
     *           &lt;simpleType>
     *             &lt;list itemType="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *           &lt;/simpleType>
     *         &lt;/element>
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
        "restrictedCharSet"
    })
    public static class String {

        @XmlList
        @XmlElement(type = Long.class)
        protected List<Long> restrictedCharSet;

        /**
         * Gets the value of the restrictedCharSet property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the restrictedCharSet property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRestrictedCharSet().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Long }
         * 
         * 
         */
        public List<Long> getRestrictedCharSet() {
            if (restrictedCharSet == null) {
                restrictedCharSet = new ArrayList<Long>();
            }
            return this.restrictedCharSet;
        }

    }

}
