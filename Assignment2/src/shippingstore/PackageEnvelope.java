package shippingstore;

/**
 * Class to describe the information of a PackageEnvelope (Extends package) <br><br>
 * <b>Data: </b><br>
 * Height<br>
 * Width<br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/02/2017
 */
public class PackageEnvelope extends Package{

    private int height;
    private int width;

    /** Constructs a PackageBox object. Initializes data using input
     *
     * @param trackingNumber tracking number to initialize the package
     * @param type Type to initialize the package
     * @param specification Specification to initialize the package
     * @param mailingClass Mailing Class to initialize the package
     * @param height height to initialize the Envelope
     * @param width width to initialize the Envelope
     * */
    public PackageEnvelope(String trackingNumber, String type, String specification, String mailingClass,int height, int width) {
        super(trackingNumber, type, specification, mailingClass);
        this.height = height;
        this.width = width;
    }

    /** Get Height
     * @return Envelope Height
     */
    public int getHeight() {
        return height;
    }

    /** Get Width
     * @return Envelope Width
     */
    public int getWidth() {
        return width;
    }


    /**
     * Prints out the a line with package variables <br>
     * Order of printing: Tracking #, Type, Specification, Class, Height, width
     * @param format format for printing the values. e.g. | %-11s| %-8s| %-17s| %-14s| %-26s| %-30s|
     */
    public void print(String format){

        System.out.println(String.format(format,
                getTrackingNumber(),
                getType(),
                getSpecification(),
                getMailingClass(),
                "Height: " + Integer.toString(height),
                "Width: " + Integer.toString(width)));
    }


}

