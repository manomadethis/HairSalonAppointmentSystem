package hairforyouappointmentsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDaoImpl implements AppointmentDao {

    private Connection conn;

    public AppointmentDaoImpl() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:appointments.db");
            createTableIfNotExists();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS appointments (" +
                     "id INTEGER PRIMARY KEY," +
                     "name TEXT," +
                     "number TEXT," +
                     "address TEXT," +
                     "date TEXT," +
                     "time TEXT)";
        stmt.executeUpdate(sql);
        stmt.close();
    }

    @Override
    public boolean addAppointment(Appointment appointment) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO appointments (name, number, address, date, time) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, appointment.getCustomerName());
            stmt.setString(2, appointment.getCustomerNumber());
            stmt.setString(3, appointment.getCustomerAddress());
            stmt.setString(4, appointment.getDate());
            stmt.setString(5, appointment.getTime());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAppointment(Appointment appointment) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE appointments SET name=?, number=?, address=?, date=?, time=? WHERE id=?");
            stmt.setString(1, appointment.getCustomerName());
            stmt.setString(2, appointment.getCustomerNumber());
            stmt.setString(3, appointment.getCustomerAddress());
            stmt.setString(4, appointment.getDate());
            stmt.setString(5, appointment.getTime());
            stmt.setInt(6, appointment.hashCode());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeAppointment(int id) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM appointments WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
    public void removeAppointment(int id) throws SQLException {
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM appointments WHERE id = ?")) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected != 1) {
                throw new SQLException("Unexpected rows affected: " + rowsAffected);
            }
    }
     */

    public List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM appointments");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String number = rs.getString("number");
                String address = rs.getString("address");
                String date = rs.getString("date");
                String time = rs.getString("time");
                appointments.add(new Appointment(id, name, number, address, date, time));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }
}
