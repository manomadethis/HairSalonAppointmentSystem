public class UpdateAppointment {

    // Instance variables
    private AppointmentManagement appointmentManagement;

    // Constructor
    public UpdateAppointment(AppointmentManagement appointmentManagement) {
        this.appointmentManagement = appointmentManagement;
    }

    // Method to update an existing appointment
    public void updateExistingAppointment(int appointmentIndex, String customerName, String customerNumber, String customerAddress, String date, String time) {
        // Get the appointment object at the specified index
        Appointment existingAppointment = appointmentManagement.getAppointments().get(appointmentIndex);

        // Update the appointment object with the provided data
        existingAppointment.setCustomerName(customerName);
        existingAppointment.setCustomerNumber(customerNumber);
        existingAppointment.setCustomerAddress(customerAddress);
        existingAppointment.setDate(date);
        existingAppointment.setTime(time);

        // Update the appointment in the appointment management system
        appointmentManagement.updateAppointment(appointmentIndex, existingAppointment);
    }
}
