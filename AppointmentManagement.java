import java.util.ArrayList;

public class AppointmentManagement {

    // Instance variables
    private ArrayList<Appointment> appointments;

    // Constructor
    public AppointmentManagement() {
        this.appointments = new ArrayList<Appointment>();
    }

    // Method to add a new appointment
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Method to update an existing appointment
    public void updateAppointment(int index, Appointment updatedAppointment) {
        appointments.set(index, updatedAppointment);
    }

    // Method to remove an appointment
    public void removeAppointment(int index) {
        appointments.remove(index);
    }

    // Getter for the appointments list
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
}
