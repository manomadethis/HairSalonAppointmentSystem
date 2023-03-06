package hairforyouappointmentsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class RemoveAppointmentDialog extends JDialog {

    public RemoveAppointmentDialog(JFrame parent, AppointmentDao appointmentDao) throws SQLException {
        super(parent, "Remove Appointment", true);
        // Create GUI components
        JLabel customerLabel = new JLabel("Customer ID:");
        JTextField customerField = new JTextField(10);

        JButton removeButton = new JButton("Remove");
        JButton cancelButton = new JButton("Cancel");

        // Add action listeners
        removeButton.addActionListener(e -> {
            int customerId = Integer.parseInt(customerField.getText());
            appointmentDao.removeAppointment(customerId);
            JOptionPane.showMessageDialog(this, "Appointment removed successfully.");
            dispose();
        });

        cancelButton.addActionListener(e -> {
            dispose();
        });

        // Layout components
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(customerLabel, constraints);

        constraints.gridx = 1;
        panel.add(customerField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(removeButton, constraints);

        constraints.gridy = 2;
        panel.add(cancelButton, constraints);

        add(panel);
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public static void showDialog(JFrame parent, AppointmentDao appointmentDao) {
        try {
            RemoveAppointmentDialog dialog = new RemoveAppointmentDialog(parent, appointmentDao);
            dialog.setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parent, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
