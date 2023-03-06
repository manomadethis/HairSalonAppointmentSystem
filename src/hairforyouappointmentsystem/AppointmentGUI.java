package hairforyouappointmentsystem;

import javax.swing.*;

import java.awt.*;
import java.util.List;

public class AppointmentGUI extends JFrame {

    // Instance variables
    private JLabel titleLabel;
    private JTable appointmentTable;
    private JScrollPane tableScrollPane;
    private JButton addButton;
    private JButton updateButton;
    private JButton removeButton;

    private AppointmentDaoImpl appointmentDao;

    // Constructor
    public AppointmentGUI() {

        // Set the window properties
        setTitle("Hair For You Appointment Management System");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        appointmentDao = new AppointmentDaoImpl();

        // Get the appointment data from the database
        List<Appointment> appointments = null;
        appointments = appointmentDao.getAppointments();

        // Create the GUI components
        titleLabel = new JLabel("Appointments");
        appointmentTable = new JTable(new AppointmentTableModel(appointments));
        tableScrollPane = new JScrollPane(appointmentTable);
        addButton = new JButton("Add Appointment");
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateButton = new JButton("Update Appointment");
        updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeButton = new JButton("Remove Appointment");
        removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Set the component properties
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        appointmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        appointmentTable.setAutoCreateRowSorter(true);
        addButton.setPreferredSize(new Dimension(150, 30));
        updateButton.setPreferredSize(new Dimension(150, 30));
        removeButton.setPreferredSize(new Dimension(150, 30));

        // Create the GUI layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(removeButton);

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listener for Add Appointment
        addButton.addActionListener(e -> {
            AddAppointmentDialog addAppointmentDialog = new AddAppointmentDialog(this, appointmentDao);
            addAppointmentDialog.setVisible(true);
            Appointment appointment = addAppointmentDialog.getAppointment();
            if (appointment != null) {
                ((AppointmentTableModel) appointmentTable.getModel()).addAppointment(appointment);
            }
        });

        // Action Listener for Update Appointment
        // Action Listener for Update Appointment
        updateButton.addActionListener(e -> {
            int selectedRow = appointmentTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select an appointment to update", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            Appointment appointment = ((AppointmentTableModel) appointmentTable.getModel()).getAppointmentAt(selectedRow);
            UpdateAppointmentDialog updateAppointmentDialog = new UpdateAppointmentDialog(this, appointmentDao, appointment);
            updateAppointmentDialog.setVisible(true);
            Appointment updatedAppointment = updateAppointmentDialog.getAppointment();
            if (updatedAppointment != null) {
                appointmentDao.updateAppointment(updatedAppointment);
                ((AppointmentTableModel) appointmentTable.getModel()).updateAppointment(updatedAppointment, selectedRow);
            }
        });
        
        // Action Listener for Remove Appointment
        removeButton.addActionListener(e -> {
            int selectedRow = appointmentTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select an appointment to remove", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this appointment?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.OK_OPTION) {
                    ((AppointmentTableModel) appointmentTable.getModel()).getAppointmentAt(selectedRow);
                    RemoveAppointmentDialog.showDialog(AppointmentGUI.this, appointmentDao);
                    ((AppointmentTableModel) appointmentTable.getModel()).removeAppointment(selectedRow);
                }
            }
        });
        


    }
}