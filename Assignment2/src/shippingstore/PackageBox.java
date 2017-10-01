package shippingstore;

public class PackageBox extends Package{

    private int largestDimension;
    private int width;

    public PackageBox() {
    }

    public PackageBox(int largestDimension, int width) {
        this.largestDimension = largestDimension;
        this.width = width;
    }

    public int getLargestDimension() {
        return largestDimension;
    }

    public int getWidth() {
        return width;
    }

}

