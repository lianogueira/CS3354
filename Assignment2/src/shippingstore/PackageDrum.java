
package shippingstore;

public class PackageDrum extends Package{

    private String material;
    private int diameter;

    public PackageDrum() {
    }

    public PackageDrum(String material, int diameter) {
        this.material = material;
        this.diameter = diameter;
    }

    public String getMaterial() {
        return material;
    }

    public int getDiameter() {
        return diameter;
    }

}
