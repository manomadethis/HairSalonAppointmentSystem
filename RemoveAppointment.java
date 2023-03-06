public class RemoveAppointment {

    // Instance variables
    private AppointmentManagement appointmentManagement;

    // Constructor
    public RemoveAppointment(AppointmentManagement appointmentManagement) {
        this.appointmentManagement = appointmentManagement;
    }

    // Method to remove an appointment
    public void removeExistingAppointment(int appointmentIndex) {
        // Remove the appointment from the appointment management system
        appointmentManagement.removeAppointment(appointmentIndex);
    }
}
