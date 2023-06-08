
package hr.algebra.iis_validation.models.jaxb;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="meme" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="memeName"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;minLength value="5"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="top" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="bottom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "meme"
})
@XmlRootElement(name = "generatedMemes")
public class GeneratedMemes {

    protected List<GeneratedMemes.Meme> meme;

    /**
     * Gets the value of the meme property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the meme property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeme().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeneratedMemes.Meme }
     * 
     * 
     */
    public List<GeneratedMemes.Meme> getMeme() {
        if (meme == null) {
            meme = new ArrayList<GeneratedMemes.Meme>();
        }
        return this.meme;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="memeName"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="5"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="top" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="bottom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "memeName",
        "top",
        "bottom"
    })
    public static class Meme {

        @XmlElement(required = true)
        protected String memeName;
        @XmlElement(required = true)
        protected String top;
        @XmlElement(required = true)
        protected String bottom;
        @XmlAttribute(name = "id")
        protected BigInteger id;

        /**
         * Gets the value of the memeName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMemeName() {
            return memeName;
        }

        /**
         * Sets the value of the memeName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMemeName(String value) {
            this.memeName = value;
        }

        /**
         * Gets the value of the top property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTop() {
            return top;
        }

        /**
         * Sets the value of the top property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTop(String value) {
            this.top = value;
        }

        /**
         * Gets the value of the bottom property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBottom() {
            return bottom;
        }

        /**
         * Sets the value of the bottom property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBottom(String value) {
            this.bottom = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setId(BigInteger value) {
            this.id = value;
        }

    }

}
