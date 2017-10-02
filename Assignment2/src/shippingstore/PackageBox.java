package shippingstore;

public class PackageBox extends Package{

    private int largestDimension;
    private int volume;

    public PackageBox() {
    }

    public PackageBox(String trackingNumber, String type, String specification, String mailingClass, int largestDimension, int volume) {
        super(trackingNumber, type, specification, mailingClass);
        this.largestDimension = largestDimension;
        this.volume = volume;
    }

    public int getLargestDimension() {
        return largestDimension;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return getTrackingNumber() + " " + getType() + " " + getSpecification() + " " + getMailingClass() + " "
                +  largestDimension + " " + volume + "\n";
    }

}

