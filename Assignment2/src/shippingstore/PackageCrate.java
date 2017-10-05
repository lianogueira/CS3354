package shippingstore;

/**
 * Class to describe the information of a PackageCrate (Extends package) <br><br>
 * <b>Data: </b><br>
 * Maximum Weight<br>
 * Content<br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/04/2017
 */
public class PackageCrate extends Package{

    private float maxWeight;
    private String content;


    /** Constructs a PackageBox object. Initializes data using input
     *
     * @param trackingNumber tracking number to initialize the package
     * @param type Type to initialize the package
     * @param specification Specification to initialize the package
     * @param mailingClass Mailing Class to initialize the package
     * @param maxWeight Maximum Weight to initialize the Crate
     * @param content Content to initialize the Crate
     * */
    public PackageCrate(String trackingNumber, String type, String specification, String mailingClass, float maxWeight, String content) {
        super(trackingNumber, type, specification, mailingClass);
        this.maxWeight = maxWeight;
        this.content = content;
    }

    /** Get Maximum Weight
     * @return Crate Maximum Weight
     */
    public float getMaxWeight() {
        return maxWeight;
    }

    /** Get Content
     * @return Crate Content
     */
    public String getContent() {return content;}


    /**
     * Prints out the a line with package variables <br>
     * Order of printing: Tracking #, Type, Specification, Class, Maximum Weight, Content
     * @param format format for printing the values. e.g. | %-11s| %-8s| %-17s| %-14s| %-26s| %-30s|
     */
    public void print(String format){
        int MAX_CONTENT_LEN = 19;

        System.out.println(String.format(format,
                getTrackingNumber(),
                getType(),
                getSpecification(),
                getMailingClass(),
                "Max Weight: " + String.format("%.2f",maxWeight),
                "Content: " + content.substring(0,(content.length() < MAX_CONTENT_LEN)?content.length():MAX_CONTENT_LEN))); //truncates to MAX_CONTENT_LEN));
    }

}

