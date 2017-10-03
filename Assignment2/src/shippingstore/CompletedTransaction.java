package shippingstore;
import java.io.Serializable;
import java.util.Date;


/**
 * Class to describe the information of a CompletedTransaction <br><br>
 * <b>Data: </b><br>
 * Customer ID<br>
 * Tracking #<br>
 * Shipping Date<br>
 * Delivery Date<br>
 * Cost Shipping<br>
 * Employee ID<br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/02/2017
 */
public class CompletedTransaction implements Serializable {

    private Integer customerID;
    private String trackingNumber;
    private Date shippingDate;
    private Date deliveryDate;
    private float costShipping;
    private Integer employeeID;

    /** Constructs a CompletedTransaction object. Initializes data using input
     *
     * @param customerID Customer ID to initialize the CompletedTransaction
     * @param trackingNumber Tracking number to initialize the CompletedTransaction
     * @param shippingDate Shipping Date to initialize the CompletedTransaction
     * @param deliveryDate Delivery DAte to initialize the CompletedTransaction
     * @param costShipping Cost of Shipping to initialize the CompletedTransaction
     * @param employeeID Employee Id to initialize the CompletedTransaction
     * */
    public CompletedTransaction(Integer customerID, String trackingNumber, Date shippingDate, Date deliveryDate, float costShipping, Integer employeeID){
        this.customerID=customerID;
        this.trackingNumber=trackingNumber;
        this.shippingDate=shippingDate;
        this.deliveryDate=deliveryDate;
        this.costShipping=costShipping;
        this.employeeID=employeeID;
    }

    /** Get Customer ID
     * @return Completed Transaction Customer ID
     */
    public Integer getCustomerID() {return customerID;}

    /** Get Tracking Number
     * @return Completed Transaction Tracking number
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /** Get Shipping Date
     * @return Completed Transaction Shipping Date
     */
    public Date getShippingDate() {
        return shippingDate;
    }

    /** Get Delivery DAte
     * @return Completed Transaction Delivery DAte
     */
    public Date getDeliveryDate() { return deliveryDate; }

    /** Get Cost of Shipping
     * @return Completed Transaction Cost of Shipping
     */
    public float getCostShipping() {
        return costShipping;
    }

    /** Get Employee ID
     * @return Completed Transaction Employee ID
     */
    public Integer getEmployeeID() {
        return employeeID;
    }


}
