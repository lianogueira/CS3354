package shippingstore;

public class PackageCrate extends Package{

    private float maxWeight;
    private String content;

    public PackageCrate() {
    }

    public PackageCrate(String trackingNumber, String type, String specification, String mailingClass, float maxWeight, String content) {
        super(trackingNumber, type, specification, mailingClass);
        this.maxWeight = maxWeight;
        this.content = content;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return getTrackingNumber() + " " + getType() + " " + getSpecification() + " " + getMailingClass() + " "
                + maxWeight + " " + content + "\n";
    }

}

