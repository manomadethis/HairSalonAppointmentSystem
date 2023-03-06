package hairforyouappointmentsystem;

public interface AppointmentDao {
    public boolean addAppointment(Appointment appointment);
    public boolean updateAppointment(Appointment appointment);
    public boolean removeAppointment(int id);
}
