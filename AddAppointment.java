public class AddAppointment {

    // Instance variables
    private AppointmentManagement appointmentManagement;

    // Constructor
    public AddAppointment(AppointmentManagement appointmentManagement) {
        this.appointmentManagement = appointmentManagement;
    }

    // Method to add a new appointment
    public void addNewAppointment(String customerName, String customerNumber, String customerAddress, String date, String time) {
        // Create a new Appointment object with the provided data
        Appointment newAppointment = new Appointment(customerName, customerNumber, customerAddress, date, time);

        // Add the new appointment to the appointment management system
        appointmentManagement.addAppointment(newAppointment);
    }
}
