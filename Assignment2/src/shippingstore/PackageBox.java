package shippingstore;


/**
 * Class to describe the information of a packageBox (Extends package) <br><br>
 * <b>Data: </b><br>
 * Largest Dimension<br>
 * Volume<br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/02/2017
 */
public class PackageBox extends Package{

    private int largestDimension;
    private int volume;

    /** Constructs a PackageBox object. Initializes data using input
     *
     * @param trackingNumber tracking number to initialize the package
     * @param type Type to initialize the package
     * @param specification Specification to initialize the package
     * @param mailingClass Mailing Class to initialize the package
     * @param largestDimension Largest Dimension to initialize the packageBox
     * @param volume volume to initialize the packageBox
     * */
    public PackageBox(String trackingNumber, String type, String specification, String mailingClass, int largestDimension, int volume) {
        super(trackingNumber, type, specification, mailingClass);
        this.largestDimension = largestDimension;
        this.volume = volume;
    }

    /** Get Largest Dimension
     * @return Box Largest Dimension
     */
    public int getLargestDimension() {
        return largestDimension;
    }

    /** Get Volume
     * @return Box Volume
     */
    public int getVolume() {return volume;}


    /**
     * Prints out the a line with package variables <br>
     * Order of printing: Tracking #, Type, Specification, Class, Largest Dimension, Volume
     * @param format format for printing the values. e.g. | %-11s| %-8s| %-17s| %-14s| %-26s| %-30s|
     */
    public void print(String format){

        System.out.println(String.format(format,
                getTrackingNumber(),
                getType(),
                getSpecification(),
                getMailingClass(),
                "Largest Dimension: " + Integer.toString(largestDimension),
                "Volume: " + Integer.toString(volume)));
    }

}

