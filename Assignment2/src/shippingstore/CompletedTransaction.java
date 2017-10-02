package shippingstore;
import java.io.Serializable;
import java.util.Date;

public class CompletedTransaction implements Serializable {

    private Integer customerID;
    private String trackingNumber;
    private String shippingDate;
    private String deliveryDate;
    private float costShipping;
    private Integer employeeID;


    public CompletedTransaction(Integer customerID, String trackingNumber, String shippingDate, String deliveryDate, float costShipping, Integer employeeID){
        this.customerID=customerID;
        this.trackingNumber=trackingNumber;
        this.shippingDate=shippingDate;
        this.deliveryDate=deliveryDate;
        this.costShipping=costShipping;
        this.employeeID=employeeID;
    }


    public Integer getCustomerID() {
        return customerID;
    }
    public String getTrackingNumber() {
        return trackingNumber;
    }
    public String getShippingDate() {
        return shippingDate;
    }
    public String getDeliveryDate() { return deliveryDate; }
    public float getCostShipping() {
        return costShipping;
    }
    public Integer getEmployeeID() {
        return employeeID;
    }


}
