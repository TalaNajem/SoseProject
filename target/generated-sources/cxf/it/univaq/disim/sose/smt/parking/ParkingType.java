
package it.univaq.disim.sose.smt.parking;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParkingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParkingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="lon" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="parkingInfo" type="{http://it.univaq.disim.sose.smt/parking}parkingInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParkingType", propOrder = {
    "lat",
    "lon",
    "parkingInfo"
})
public class ParkingType {

    protected double lat;
    protected double lon;
    protected ParkingInfoType parkingInfo;

    /**
     * Gets the value of the lat property.
     * 
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets the value of the lat property.
     * 
     */
    public void setLat(double value) {
        this.lat = value;
    }

    /**
     * Gets the value of the lon property.
     * 
     */
    public double getLon() {
        return lon;
    }

    /**
     * Sets the value of the lon property.
     * 
     */
    public void setLon(double value) {
        this.lon = value;
    }

    /**
     * Gets the value of the parkingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ParkingInfoType }
     *     
     */
    public ParkingInfoType getParkingInfo() {
        return parkingInfo;
    }

    /**
     * Sets the value of the parkingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParkingInfoType }
     *     
     */
    public void setParkingInfo(ParkingInfoType value) {
        this.parkingInfo = value;
    }

}
