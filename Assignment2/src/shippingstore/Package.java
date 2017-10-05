package shippingstore;
import java.io.Serializable;


/**
 * Class to describe the information of a package <br><br>
 * <b>Data: </b><br>
 * Tracking Number<br>
 * Type<br>
 * Specification<br>
 * MailingClass<br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/02/2017
 */
public class Package implements Serializable, Comparable<Package>{

    private String trackingNumber;
    private String type;
    private String specification;
    private String mailingClass;

    /** Default constructor */
    public Package() {}

    /** Constructs a Package object. Initializes data using input
     *
     * @param trackingNumber tracking number to initialize the package
     * @param type Type to initialize the package
     * @param specification Specification to initialize the package
     * @param mailingClass Mailing Class to initialize the package
     * */
    public Package(String trackingNumber, String type, String specification, String mailingClass) {
        this.trackingNumber = trackingNumber;
        this.type = type;
        this.specification = specification;
        this.mailingClass = mailingClass;
    }


    /** Get Tracking Number
     * @return Package Tracking number
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }


    /** Get type
     * @return Package Type
     */
    public String getType() {
        return type;
    }


    /** Get specification
     * @return Package Specification
     */
    public String getSpecification() {
        return specification;
    }

    /** Get Mailing Class
     * @return Package Mailing Class
     */
    public String getMailingClass() {
        return mailingClass;
    }


    /**
     * Overwrites compareTo method. Comparison is based on tracking # <br>
     * Method created to be used in the sort of an ArrayList
     */
    @Override
    public int compareTo(Package c) {
        String rhsName = ((Package)c).getTrackingNumber().toUpperCase();
        return trackingNumber.toUpperCase().compareTo(rhsName);
    }

    /**
     * Prints out the a line with package variables <br>
     * Order of printing: Tracking #, Type, Specification, Class
     * @param format format for printing the values. e.g. | %-11s| %-8s| %-17s| %-14s| %-26s| %-30s|
     */
    public void print(String format){
        System.out.println(String.format(format,
                trackingNumber,
                type,
                specification,
                mailingClass, "", ""));
    }

}
