package shippingstore;

public class PackageEnvelope extends Package{

    private int height;
    private int width;

    public PackageEnvelope() {
    }

    public PackageEnvelope(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}

