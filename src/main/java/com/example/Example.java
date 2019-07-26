package com.example;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "example", namespace = Example.NAMESPACE)
public final class Example implements Serializable {

    /**
     * The XML namespace.
     */
    static final String NAMESPACE =
        "http://www.example.com/example/1.0.0";

    /**
     * A serial version UID.
     */
    private static final long serialVersionUID = 6108711703700072578L;

    /**
     * Example elements.
     */
    @XmlElementWrapper(name = "elements")
    @XmlElements({
        @XmlElement(
            name = "typeone",
            namespace = Example.NAMESPACE,
            type = Example.ElementTypeOne.class
        ),
        @XmlElement(
            name = "typetwo",
            namespace = Example.NAMESPACE,
            type = Example.ElementTypeTwo.class
        )
    })
    private Set<Example.Element> elements;

    /**
     * Example references.
     */
    @XmlElementWrapper(name = "references")
    @XmlElement(name = "reference")
    private Set<Example.Reference> references;

    /**
     * Empty constructor.
     */
    public Example() {
        this.elements = new HashSet<>(0);
        this.references = new HashSet<>(0);
    }

    /**
     * Default constructor.
     * @param elements The elements
     */
    public Example(final Set<Element> elements,
        final Set<Reference> references) {
        this.elements = elements;
        this.references = references;
    }

    @XmlTransient
    @XmlType(namespace = Example.NAMESPACE)
    public static abstract class Element implements Serializable {

        /**
         * A serial version UID.
         */
        private static final long serialVersionUID = 7206583134109784056L;

        /**
         * A name.
         */
        @XmlID
        @XmlAttribute(required = true)
        protected String name;

        /**
         * Empty constructor.
         */
        public Element() {
            this.name = "";
        }

        /**
         * Default constructor.
         * @param name The name
         */
        public Element(final String name) {
            this.name = name;
        }

    }

    @XmlType(namespace = Example.NAMESPACE)
    public static final class ElementTypeOne extends Element {

        public ElementTypeOne() {
            this("");
        }

        public ElementTypeOne(final String name) {
            super(name);
        }

    }

    @XmlType(namespace = Example.NAMESPACE, propOrder = {"name", "value"})
    public static final class ElementTypeTwo extends Element {

        /**
         * A value.
         */
        @XmlAttribute(required = true)
        protected String value;

        public ElementTypeTwo() {
            this("", "");
        }

        public ElementTypeTwo(final String name, final String value) {
            super(name);
            this.value = value;
        }

    }

    @XmlType(namespace = Example.NAMESPACE)
    public static final class Reference implements Serializable {

        /**
         * A serial version UID.
         */
        private static final long serialVersionUID = 7206583134109784056L;

        /**
         * A name.
         */
        @XmlIDREF
        @XmlAttribute(required = true)
        private Example.Element elementOne;

        /**
         * A name.
         */
        @XmlIDREF
        @XmlAttribute(required = true)
        private Example.Element elementTwo;

        /**
         * Empty constructor.
         */
        public Reference() {
        }

        /**
         * Default constructor.
         * @param element The referenced element
         */
        public Reference(final Element elementOne,
            final Element elementTwo) {
            this.elementOne = elementOne;
            this.elementTwo = elementTwo;
        }

    }

}
