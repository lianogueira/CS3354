package shippingstore;

public class PackageEnvelope extends Package{

    private int height;
    private int width;

    public PackageEnvelope() {
    }

    public PackageEnvelope(String trackingNumber, String type, String specification, String mailingClass,int height, int width) {
        super(trackingNumber, type, specification, mailingClass);
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return getTrackingNumber() + " " + getType() + " " + getSpecification() + " " + getMailingClass() + " "
                +  height + " " + width + "\n";
    }

}

