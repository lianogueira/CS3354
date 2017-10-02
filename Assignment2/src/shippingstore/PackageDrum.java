
package shippingstore;

public class PackageDrum extends Package{

    private String material;
    private int diameter;

    public PackageDrum() {
    }

    public PackageDrum(String trackingNumber, String type, String specification, String mailingClass, String material, int diameter) {
        super(trackingNumber, type, specification, mailingClass);
        this.material = material;
        this.diameter = diameter;
    }

    public String getMaterial() {
        return material;
    }

    public int getDiameter() {
        return diameter;
    }


    @Override
    public String toString() {
        return getTrackingNumber() + " " + getType() + " " + getSpecification() + " " + getMailingClass() + " "
                + material + " " + diameter + "\n";
    }


}
