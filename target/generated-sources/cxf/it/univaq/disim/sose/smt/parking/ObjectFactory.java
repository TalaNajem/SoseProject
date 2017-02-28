
package it.univaq.disim.sose.smt.parking;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.smt.parking package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ParkingRequest_QNAME = new QName("http://it.univaq.disim.sose.smt/parking", "parkingRequest");
    private final static QName _ParkingResponse_QNAME = new QName("http://it.univaq.disim.sose.smt/parking", "parkingResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.smt.parking
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ParkingRequest }
     * 
     */
    public ParkingRequest createParkingRequest() {
        return new ParkingRequest();
    }

    /**
     * Create an instance of {@link ParkingResponse }
     * 
     */
    public ParkingResponse createParkingResponse() {
        return new ParkingResponse();
    }

    /**
     * Create an instance of {@link ParkingType }
     * 
     */
    public ParkingType createParkingType() {
        return new ParkingType();
    }

    /**
     * Create an instance of {@link ParkingInfoType }
     * 
     */
    public ParkingInfoType createParkingInfoType() {
        return new ParkingInfoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParkingRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.smt/parking", name = "parkingRequest")
    public JAXBElement<ParkingRequest> createParkingRequest(ParkingRequest value) {
        return new JAXBElement<ParkingRequest>(_ParkingRequest_QNAME, ParkingRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParkingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.smt/parking", name = "parkingResponse")
    public JAXBElement<ParkingResponse> createParkingResponse(ParkingResponse value) {
        return new JAXBElement<ParkingResponse>(_ParkingResponse_QNAME, ParkingResponse.class, null, value);
    }

}
