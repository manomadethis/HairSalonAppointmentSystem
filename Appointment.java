public class Appointment {

    // Instance variables
    private String customerName;
    private String customerNumber;
    private String customerAddress;
    private String date;
    private String time;

    // Constructor
    public Appointment(String customerName, String customerNumber, String customerAddress, String date, String time) {
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerAddress = customerAddress;
        this.date = date;
        this.time = time;
    }

    // Getters and setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // Override toString() method to display appointment information
    @Override
    public String toString() {
        return "ID: " + hashCode() + "\n" +
                "Customer Name: " + customerName + "\n" +
                "Customer Number: " + customerNumber + "\n" +
                "Customer Address: " + customerAddress + "\n" +
                "Date: " + date + "\n" +
                "Time: " + time + "\n";
    }
}
