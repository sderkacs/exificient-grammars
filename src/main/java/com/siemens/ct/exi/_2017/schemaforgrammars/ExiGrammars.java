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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="qnames">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="namespaceContext" type="{http://www.ct.siemens.com/exi/2017/SchemaForGrammars}NamespaceContext" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="simpleDatatypes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="simpleDatatype" type="{http://www.ct.siemens.com/exi/2017/SchemaForGrammars}Datatype" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="grammars">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="isBuiltInXMLSchemaTypesOnly">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="grammar" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="isTypeCastable" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="isNillable" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="production" type="{http://www.ct.siemens.com/exi/2017/SchemaForGrammars}Production" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="grammarType" use="required" type="{http://www.ct.siemens.com/exi/2017/SchemaForGrammars}grammarType" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="documentGrammarID" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *                 &lt;attribute name="fragmentGrammarID" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *                 &lt;attribute name="elementFragmentGrammarID" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "qnames",
    "simpleDatatypes",
    "grammars"
})
@XmlRootElement(name = "exiGrammars")
public class ExiGrammars {

    @XmlElement(required = true)
    protected ExiGrammars.Qnames qnames;
    protected ExiGrammars.SimpleDatatypes simpleDatatypes;
    @XmlElement(required = true)
    protected ExiGrammars.Grammars grammars;

    /**
     * Ruft den Wert der qnames-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExiGrammars.Qnames }
     *     
     */
    public ExiGrammars.Qnames getQnames() {
        return qnames;
    }

    /**
     * Legt den Wert der qnames-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExiGrammars.Qnames }
     *     
     */
    public void setQnames(ExiGrammars.Qnames value) {
        this.qnames = value;
    }

    /**
     * Ruft den Wert der simpleDatatypes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExiGrammars.SimpleDatatypes }
     *     
     */
    public ExiGrammars.SimpleDatatypes getSimpleDatatypes() {
        return simpleDatatypes;
    }

    /**
     * Legt den Wert der simpleDatatypes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExiGrammars.SimpleDatatypes }
     *     
     */
    public void setSimpleDatatypes(ExiGrammars.SimpleDatatypes value) {
        this.simpleDatatypes = value;
    }

    /**
     * Ruft den Wert der grammars-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExiGrammars.Grammars }
     *     
     */
    public ExiGrammars.Grammars getGrammars() {
        return grammars;
    }

    /**
     * Legt den Wert der grammars-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExiGrammars.Grammars }
     *     
     */
    public void setGrammars(ExiGrammars.Grammars value) {
        this.grammars = value;
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
     *         &lt;element name="isBuiltInXMLSchemaTypesOnly">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="grammar" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="isTypeCastable" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="isNillable" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="production" type="{http://www.ct.siemens.com/exi/2017/SchemaForGrammars}Production" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="grammarType" use="required" type="{http://www.ct.siemens.com/exi/2017/SchemaForGrammars}grammarType" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="documentGrammarID" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *       &lt;attribute name="fragmentGrammarID" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *       &lt;attribute name="elementFragmentGrammarID" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "isBuiltInXMLSchemaTypesOnly",
        "grammar"
    })
    public static class Grammars {

        @XmlElement(required = true)
        protected ExiGrammars.Grammars.IsBuiltInXMLSchemaTypesOnly isBuiltInXMLSchemaTypesOnly;
        protected List<ExiGrammars.Grammars.Grammar> grammar;
        @XmlAttribute(name = "documentGrammarID", required = true)
        @XmlSchemaType(name = "unsignedInt")
        protected long documentGrammarID;
        @XmlAttribute(name = "fragmentGrammarID", required = true)
        @XmlSchemaType(name = "unsignedInt")
        protected long fragmentGrammarID;
        @XmlAttribute(name = "elementFragmentGrammarID", required = true)
        @XmlSchemaType(name = "unsignedInt")
        protected long elementFragmentGrammarID;

        /**
         * Ruft den Wert der isBuiltInXMLSchemaTypesOnly-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link ExiGrammars.Grammars.IsBuiltInXMLSchemaTypesOnly }
         *     
         */
        public ExiGrammars.Grammars.IsBuiltInXMLSchemaTypesOnly getIsBuiltInXMLSchemaTypesOnly() {
            return isBuiltInXMLSchemaTypesOnly;
        }

        /**
         * Legt den Wert der isBuiltInXMLSchemaTypesOnly-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link ExiGrammars.Grammars.IsBuiltInXMLSchemaTypesOnly }
         *     
         */
        public void setIsBuiltInXMLSchemaTypesOnly(ExiGrammars.Grammars.IsBuiltInXMLSchemaTypesOnly value) {
            this.isBuiltInXMLSchemaTypesOnly = value;
        }

        /**
         * Gets the value of the grammar property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the grammar property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGrammar().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExiGrammars.Grammars.Grammar }
         * 
         * 
         */
        public List<ExiGrammars.Grammars.Grammar> getGrammar() {
            if (grammar == null) {
                grammar = new ArrayList<ExiGrammars.Grammars.Grammar>();
            }
            return this.grammar;
        }

        /**
         * Ruft den Wert der documentGrammarID-Eigenschaft ab.
         * 
         */
        public long getDocumentGrammarID() {
            return documentGrammarID;
        }

        /**
         * Legt den Wert der documentGrammarID-Eigenschaft fest.
         * 
         */
        public void setDocumentGrammarID(long value) {
            this.documentGrammarID = value;
        }

        /**
         * Ruft den Wert der fragmentGrammarID-Eigenschaft ab.
         * 
         */
        public long getFragmentGrammarID() {
            return fragmentGrammarID;
        }

        /**
         * Legt den Wert der fragmentGrammarID-Eigenschaft fest.
         * 
         */
        public void setFragmentGrammarID(long value) {
            this.fragmentGrammarID = value;
        }

        /**
         * Ruft den Wert der elementFragmentGrammarID-Eigenschaft ab.
         * 
         */
        public long getElementFragmentGrammarID() {
            return elementFragmentGrammarID;
        }

        /**
         * Legt den Wert der elementFragmentGrammarID-Eigenschaft fest.
         * 
         */
        public void setElementFragmentGrammarID(long value) {
            this.elementFragmentGrammarID = value;
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
         *         &lt;element name="isTypeCastable" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="isNillable" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="production" type="{http://www.ct.siemens.com/exi/2017/SchemaForGrammars}Production" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="grammarType" use="required" type="{http://www.ct.siemens.com/exi/2017/SchemaForGrammars}grammarType" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "isTypeCastable",
            "isNillable",
            "production"
        })
        public static class Grammar {

            protected ExiGrammars.Grammars.Grammar.IsTypeCastable isTypeCastable;
            protected ExiGrammars.Grammars.Grammar.IsNillable isNillable;
            protected List<Production> production;
            @XmlAttribute(name = "grammarType", required = true)
            protected GrammarType grammarType;

            /**
             * Ruft den Wert der isTypeCastable-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link ExiGrammars.Grammars.Grammar.IsTypeCastable }
             *     
             */
            public ExiGrammars.Grammars.Grammar.IsTypeCastable getIsTypeCastable() {
                return isTypeCastable;
            }

            /**
             * Legt den Wert der isTypeCastable-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link ExiGrammars.Grammars.Grammar.IsTypeCastable }
             *     
             */
            public void setIsTypeCastable(ExiGrammars.Grammars.Grammar.IsTypeCastable value) {
                this.isTypeCastable = value;
            }

            /**
             * Ruft den Wert der isNillable-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link ExiGrammars.Grammars.Grammar.IsNillable }
             *     
             */
            public ExiGrammars.Grammars.Grammar.IsNillable getIsNillable() {
                return isNillable;
            }

            /**
             * Legt den Wert der isNillable-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link ExiGrammars.Grammars.Grammar.IsNillable }
             *     
             */
            public void setIsNillable(ExiGrammars.Grammars.Grammar.IsNillable value) {
                this.isNillable = value;
            }

            /**
             * Gets the value of the production property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the production property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getProduction().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Production }
             * 
             * 
             */
            public List<Production> getProduction() {
                if (production == null) {
                    production = new ArrayList<Production>();
                }
                return this.production;
            }

            /**
             * Ruft den Wert der grammarType-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link GrammarType }
             *     
             */
            public GrammarType getGrammarType() {
                return grammarType;
            }

            /**
             * Legt den Wert der grammarType-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link GrammarType }
             *     
             */
            public void setGrammarType(GrammarType value) {
                this.grammarType = value;
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
            public static class IsNillable {


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
            public static class IsTypeCastable {


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
        public static class IsBuiltInXMLSchemaTypesOnly {


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
     *       &lt;sequence>
     *         &lt;element name="namespaceContext" type="{http://www.ct.siemens.com/exi/2017/SchemaForGrammars}NamespaceContext" maxOccurs="unbounded" minOccurs="0"/>
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
        "namespaceContext"
    })
    public static class Qnames {

        protected List<NamespaceContext> namespaceContext;

        /**
         * Gets the value of the namespaceContext property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the namespaceContext property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNamespaceContext().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NamespaceContext }
         * 
         * 
         */
        public List<NamespaceContext> getNamespaceContext() {
            if (namespaceContext == null) {
                namespaceContext = new ArrayList<NamespaceContext>();
            }
            return this.namespaceContext;
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
     *       &lt;sequence>
     *         &lt;element name="simpleDatatype" type="{http://www.ct.siemens.com/exi/2017/SchemaForGrammars}Datatype" maxOccurs="unbounded" minOccurs="0"/>
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
        "simpleDatatype"
    })
    public static class SimpleDatatypes {

        protected List<Datatype> simpleDatatype;

        /**
         * Gets the value of the simpleDatatype property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the simpleDatatype property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSimpleDatatype().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Datatype }
         * 
         * 
         */
        public List<Datatype> getSimpleDatatype() {
            if (simpleDatatype == null) {
                simpleDatatype = new ArrayList<Datatype>();
            }
            return this.simpleDatatype;
        }

    }

}
