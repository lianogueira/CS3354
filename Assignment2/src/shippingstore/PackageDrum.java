package shippingstore;


/**
 * Class to describe the information of a PackageDrum (Extends package) <br><br>
 * <b>Data: </b><br>
 * Material<br>
 * Diameter<br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/02/2017
 */
public class PackageDrum extends Package{

    private String material;
    private int diameter;

    /** Constructs a PackageBox object. Initializes data using input
     *
     * @param trackingNumber tracking number to initialize the package
     * @param type Type to initialize the package
     * @param specification Specification to initialize the package
     * @param mailingClass Mailing Class to initialize the package
     * @param material Material to initialize the Drum
     * @param diameter Diameter to initialize the Drum
     * */
    public PackageDrum(String trackingNumber, String type, String specification, String mailingClass, String material, int diameter) {
        super(trackingNumber, type, specification, mailingClass);
        this.material = material;
        this.diameter = diameter;
    }

    /** Get Material
     * @return Drum Material
     */
    public String getMaterial() {
        return material;
    }


    /** Get Diameter
     * @return Drum Diameter
     */
    public int getDiameter() {
        return diameter;
    }


    /**
     * Prints out the a line with package variables <br>
     * Order of printing: Tracking #, Type, Specification, Class, Material, Diameter
     * @param format format for printing the values. e.g. | %-11s| %-8s| %-17s| %-14s| %-26s| %-30s|
     */
    public void print(String format){

        System.out.println(String.format(format,
                getTrackingNumber(),
                getType(),
                getSpecification(),
                getMailingClass(),
                "Material: " + material,
                "Diameter: " + Integer.toString(diameter)));
    }


}
