package shippingStoreAssignment1;


/**
 * Class to describe the information of a package <br><br>
 * <b>Data: </b><br>
 * Tracking Number<br>
 * Type<br>
 * Specification<br>
 * MailingClass<br>
 * Weight<br>
 * Volume<br>
 *
 * @author Lia Nogueira de Moura
 * @version 09/19/2017
 */
public class Package {

    /** Constructs a Package object. Initializes data using input
     *
     * @param aTrackingNumber tracking number to initialize the package
     * @param aType Type to initialize the package
     * @param aSpecification Specification to initialize the package
     * @param aMailingClass Mailing Class to initialize the package
     * @param aWeight Weight to initialize the package
     * @param aVolume Volume to initialize the package
     * */
    public Package(String aTrackingNumber, String aType, String aSpecification, String aMailingClass, Float aWeight, Integer aVolume ){
        trackingNumber = aTrackingNumber;
        type = aType;
        specification = aSpecification;
        mailingClass = aMailingClass;
        weight = aWeight;
        volume = aVolume;
    };

    /** Default constructor of a Package object */
    public Package(){
        trackingNumber = "";
        type = "";
        specification = "";
        mailingClass = "";
        weight = 0.1f;
        volume = 0;
    };


    /** Get Tracking Number
     * @return Package Tracking number
     */
    public String getTrackingNumber(){
        return trackingNumber;
    }

    /** Get type
     * @return Package Type
     */
    public String getType(){
        return type;
    }

    /** Get specification
     * @return Package Specification
     */
    public String getSpecification(){
        return specification;
    }

    /** Get Mailing Class
     * @return Package Mailing Class
     */
    public String getMailingClass(){
        return mailingClass;
    }

    /** Get Weight
     * @return Package Weight
     */
    public Float getWeight(){ return weight; }

    /** Get Volume
     * @return Package Volume
     */
    public Integer getVolume(){
        return volume;
    }


    //Variables to save the package data
    private String trackingNumber;
    private String type;
    private String specification;
    private String mailingClass;
    private Float weight;
    private Integer volume;

}
