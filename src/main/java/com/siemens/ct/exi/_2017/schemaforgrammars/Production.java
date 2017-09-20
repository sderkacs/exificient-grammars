//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.09.20 um 03:16:53 PM CEST 
//


package com.siemens.ct.exi._2017.schemaforgrammars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Production complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Production">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="startDocument">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="endDocument">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="attribute" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="attributeNamespaceID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                     &lt;element name="attributeLocalNameID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                     &lt;element name="attributeDatatypeID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="attributeNS" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *           &lt;element name="attributeGeneric">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="startElement">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="startElementNamespaceID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                     &lt;element name="startElementLocalNameID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                     &lt;element name="startElementGrammarID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="startElementNS" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *           &lt;element name="startElementGeneric">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="endElement">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="characters">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="charactersDatatypeID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="charactersGeneric">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *         &lt;element name="nextGrammarID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Production", propOrder = {
    "startDocument",
    "endDocument",
    "attribute",
    "attributeNS",
    "attributeGeneric",
    "startElement",
    "startElementNS",
    "startElementGeneric",
    "endElement",
    "characters",
    "charactersGeneric",
    "nextGrammarID"
})
public class Production {

    protected Production.StartDocument startDocument;
    protected Production.EndDocument endDocument;
    protected Production.Attribute attribute;
    @XmlSchemaType(name = "unsignedInt")
    protected Long attributeNS;
    protected Production.AttributeGeneric attributeGeneric;
    protected Production.StartElement startElement;
    @XmlSchemaType(name = "unsignedInt")
    protected Long startElementNS;
    protected Production.StartElementGeneric startElementGeneric;
    protected Production.EndElement endElement;
    protected Production.Characters characters;
    protected Production.CharactersGeneric charactersGeneric;
    @XmlSchemaType(name = "unsignedInt")
    protected Long nextGrammarID;

    /**
     * Ruft den Wert der startDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Production.StartDocument }
     *     
     */
    public Production.StartDocument getStartDocument() {
        return startDocument;
    }

    /**
     * Legt den Wert der startDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Production.StartDocument }
     *     
     */
    public void setStartDocument(Production.StartDocument value) {
        this.startDocument = value;
    }

    /**
     * Ruft den Wert der endDocument-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Production.EndDocument }
     *     
     */
    public Production.EndDocument getEndDocument() {
        return endDocument;
    }

    /**
     * Legt den Wert der endDocument-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Production.EndDocument }
     *     
     */
    public void setEndDocument(Production.EndDocument value) {
        this.endDocument = value;
    }

    /**
     * Ruft den Wert der attribute-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Production.Attribute }
     *     
     */
    public Production.Attribute getAttribute() {
        return attribute;
    }

    /**
     * Legt den Wert der attribute-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Production.Attribute }
     *     
     */
    public void setAttribute(Production.Attribute value) {
        this.attribute = value;
    }

    /**
     * Ruft den Wert der attributeNS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAttributeNS() {
        return attributeNS;
    }

    /**
     * Legt den Wert der attributeNS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAttributeNS(Long value) {
        this.attributeNS = value;
    }

    /**
     * Ruft den Wert der attributeGeneric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Production.AttributeGeneric }
     *     
     */
    public Production.AttributeGeneric getAttributeGeneric() {
        return attributeGeneric;
    }

    /**
     * Legt den Wert der attributeGeneric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Production.AttributeGeneric }
     *     
     */
    public void setAttributeGeneric(Production.AttributeGeneric value) {
        this.attributeGeneric = value;
    }

    /**
     * Ruft den Wert der startElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Production.StartElement }
     *     
     */
    public Production.StartElement getStartElement() {
        return startElement;
    }

    /**
     * Legt den Wert der startElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Production.StartElement }
     *     
     */
    public void setStartElement(Production.StartElement value) {
        this.startElement = value;
    }

    /**
     * Ruft den Wert der startElementNS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStartElementNS() {
        return startElementNS;
    }

    /**
     * Legt den Wert der startElementNS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStartElementNS(Long value) {
        this.startElementNS = value;
    }

    /**
     * Ruft den Wert der startElementGeneric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Production.StartElementGeneric }
     *     
     */
    public Production.StartElementGeneric getStartElementGeneric() {
        return startElementGeneric;
    }

    /**
     * Legt den Wert der startElementGeneric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Production.StartElementGeneric }
     *     
     */
    public void setStartElementGeneric(Production.StartElementGeneric value) {
        this.startElementGeneric = value;
    }

    /**
     * Ruft den Wert der endElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Production.EndElement }
     *     
     */
    public Production.EndElement getEndElement() {
        return endElement;
    }

    /**
     * Legt den Wert der endElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Production.EndElement }
     *     
     */
    public void setEndElement(Production.EndElement value) {
        this.endElement = value;
    }

    /**
     * Ruft den Wert der characters-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Production.Characters }
     *     
     */
    public Production.Characters getCharacters() {
        return characters;
    }

    /**
     * Legt den Wert der characters-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Production.Characters }
     *     
     */
    public void setCharacters(Production.Characters value) {
        this.characters = value;
    }

    /**
     * Ruft den Wert der charactersGeneric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Production.CharactersGeneric }
     *     
     */
    public Production.CharactersGeneric getCharactersGeneric() {
        return charactersGeneric;
    }

    /**
     * Legt den Wert der charactersGeneric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Production.CharactersGeneric }
     *     
     */
    public void setCharactersGeneric(Production.CharactersGeneric value) {
        this.charactersGeneric = value;
    }

    /**
     * Ruft den Wert der nextGrammarID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNextGrammarID() {
        return nextGrammarID;
    }

    /**
     * Legt den Wert der nextGrammarID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNextGrammarID(Long value) {
        this.nextGrammarID = value;
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
     *         &lt;element name="attributeNamespaceID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *         &lt;element name="attributeLocalNameID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *         &lt;element name="attributeDatatypeID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
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
        "attributeNamespaceID",
        "attributeLocalNameID",
        "attributeDatatypeID"
    })
    public static class Attribute {

        @XmlSchemaType(name = "unsignedInt")
        protected long attributeNamespaceID;
        @XmlSchemaType(name = "unsignedInt")
        protected long attributeLocalNameID;
        @XmlSchemaType(name = "unsignedInt")
        protected long attributeDatatypeID;

        /**
         * Ruft den Wert der attributeNamespaceID-Eigenschaft ab.
         * 
         */
        public long getAttributeNamespaceID() {
            return attributeNamespaceID;
        }

        /**
         * Legt den Wert der attributeNamespaceID-Eigenschaft fest.
         * 
         */
        public void setAttributeNamespaceID(long value) {
            this.attributeNamespaceID = value;
        }

        /**
         * Ruft den Wert der attributeLocalNameID-Eigenschaft ab.
         * 
         */
        public long getAttributeLocalNameID() {
            return attributeLocalNameID;
        }

        /**
         * Legt den Wert der attributeLocalNameID-Eigenschaft fest.
         * 
         */
        public void setAttributeLocalNameID(long value) {
            this.attributeLocalNameID = value;
        }

        /**
         * Ruft den Wert der attributeDatatypeID-Eigenschaft ab.
         * 
         */
        public long getAttributeDatatypeID() {
            return attributeDatatypeID;
        }

        /**
         * Legt den Wert der attributeDatatypeID-Eigenschaft fest.
         * 
         */
        public void setAttributeDatatypeID(long value) {
            this.attributeDatatypeID = value;
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
    public static class AttributeGeneric {


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
     *         &lt;element name="charactersDatatypeID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
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
        "charactersDatatypeID"
    })
    public static class Characters {

        @XmlSchemaType(name = "unsignedInt")
        protected long charactersDatatypeID;

        /**
         * Ruft den Wert der charactersDatatypeID-Eigenschaft ab.
         * 
         */
        public long getCharactersDatatypeID() {
            return charactersDatatypeID;
        }

        /**
         * Legt den Wert der charactersDatatypeID-Eigenschaft fest.
         * 
         */
        public void setCharactersDatatypeID(long value) {
            this.charactersDatatypeID = value;
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
    public static class CharactersGeneric {


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
    public static class EndDocument {


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
    public static class EndElement {


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
    public static class StartDocument {


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
     *         &lt;element name="startElementNamespaceID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *         &lt;element name="startElementLocalNameID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *         &lt;element name="startElementGrammarID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
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
        "startElementNamespaceID",
        "startElementLocalNameID",
        "startElementGrammarID"
    })
    public static class StartElement {

        @XmlSchemaType(name = "unsignedInt")
        protected long startElementNamespaceID;
        @XmlSchemaType(name = "unsignedInt")
        protected long startElementLocalNameID;
        @XmlSchemaType(name = "unsignedInt")
        protected long startElementGrammarID;

        /**
         * Ruft den Wert der startElementNamespaceID-Eigenschaft ab.
         * 
         */
        public long getStartElementNamespaceID() {
            return startElementNamespaceID;
        }

        /**
         * Legt den Wert der startElementNamespaceID-Eigenschaft fest.
         * 
         */
        public void setStartElementNamespaceID(long value) {
            this.startElementNamespaceID = value;
        }

        /**
         * Ruft den Wert der startElementLocalNameID-Eigenschaft ab.
         * 
         */
        public long getStartElementLocalNameID() {
            return startElementLocalNameID;
        }

        /**
         * Legt den Wert der startElementLocalNameID-Eigenschaft fest.
         * 
         */
        public void setStartElementLocalNameID(long value) {
            this.startElementLocalNameID = value;
        }

        /**
         * Ruft den Wert der startElementGrammarID-Eigenschaft ab.
         * 
         */
        public long getStartElementGrammarID() {
            return startElementGrammarID;
        }

        /**
         * Legt den Wert der startElementGrammarID-Eigenschaft fest.
         * 
         */
        public void setStartElementGrammarID(long value) {
            this.startElementGrammarID = value;
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
    public static class StartElementGeneric {


    }

}
