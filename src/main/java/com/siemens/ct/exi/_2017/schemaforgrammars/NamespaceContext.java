//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.09.20 um 03:16:53 PM CEST 
//


package com.siemens.ct.exi._2017.schemaforgrammars;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für NamespaceContext complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="NamespaceContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="qnameContext" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice minOccurs="0">
 *                     &lt;element name="globalSimpleTypeDatatypeID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                     &lt;element name="globalComplexTypeGrammarID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;/choice>
 *                   &lt;element name="globalElementGrammarID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *                   &lt;element name="globalAttributeDatatypeID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="localName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="namespaceURI" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NamespaceContext", propOrder = {
    "qnameContext"
})
public class NamespaceContext {

    protected List<NamespaceContext.QnameContext> qnameContext;
    @XmlAttribute(name = "namespaceURI")
    protected String namespaceURI;

    /**
     * Gets the value of the qnameContext property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the qnameContext property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQnameContext().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NamespaceContext.QnameContext }
     * 
     * 
     */
    public List<NamespaceContext.QnameContext> getQnameContext() {
        if (qnameContext == null) {
            qnameContext = new ArrayList<NamespaceContext.QnameContext>();
        }
        return this.qnameContext;
    }

    /**
     * Ruft den Wert der namespaceURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespaceURI() {
        return namespaceURI;
    }

    /**
     * Legt den Wert der namespaceURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespaceURI(String value) {
        this.namespaceURI = value;
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
     *         &lt;choice minOccurs="0">
     *           &lt;element name="globalSimpleTypeDatatypeID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *           &lt;element name="globalComplexTypeGrammarID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *         &lt;/choice>
     *         &lt;element name="globalElementGrammarID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
     *         &lt;element name="globalAttributeDatatypeID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="localName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "globalSimpleTypeDatatypeID",
        "globalComplexTypeGrammarID",
        "globalElementGrammarID",
        "globalAttributeDatatypeID"
    })
    public static class QnameContext {

        @XmlSchemaType(name = "unsignedInt")
        protected Long globalSimpleTypeDatatypeID;
        @XmlSchemaType(name = "unsignedInt")
        protected Long globalComplexTypeGrammarID;
        @XmlSchemaType(name = "unsignedInt")
        protected Long globalElementGrammarID;
        @XmlSchemaType(name = "unsignedInt")
        protected Long globalAttributeDatatypeID;
        @XmlAttribute(name = "localName")
        protected String localName;

        /**
         * Ruft den Wert der globalSimpleTypeDatatypeID-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getGlobalSimpleTypeDatatypeID() {
            return globalSimpleTypeDatatypeID;
        }

        /**
         * Legt den Wert der globalSimpleTypeDatatypeID-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setGlobalSimpleTypeDatatypeID(Long value) {
            this.globalSimpleTypeDatatypeID = value;
        }

        /**
         * Ruft den Wert der globalComplexTypeGrammarID-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getGlobalComplexTypeGrammarID() {
            return globalComplexTypeGrammarID;
        }

        /**
         * Legt den Wert der globalComplexTypeGrammarID-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setGlobalComplexTypeGrammarID(Long value) {
            this.globalComplexTypeGrammarID = value;
        }

        /**
         * Ruft den Wert der globalElementGrammarID-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getGlobalElementGrammarID() {
            return globalElementGrammarID;
        }

        /**
         * Legt den Wert der globalElementGrammarID-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setGlobalElementGrammarID(Long value) {
            this.globalElementGrammarID = value;
        }

        /**
         * Ruft den Wert der globalAttributeDatatypeID-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getGlobalAttributeDatatypeID() {
            return globalAttributeDatatypeID;
        }

        /**
         * Legt den Wert der globalAttributeDatatypeID-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setGlobalAttributeDatatypeID(Long value) {
            this.globalAttributeDatatypeID = value;
        }

        /**
         * Ruft den Wert der localName-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocalName() {
            return localName;
        }

        /**
         * Legt den Wert der localName-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocalName(String value) {
            this.localName = value;
        }

    }

}
