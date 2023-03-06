package hairforyouappointmentsystem;

import javax.swing.*;

import java.awt.*;

public class UpdateAppointmentDialog extends JDialog {

    private Appointment appointment;
    public UpdateAppointmentDialog(JFrame parent, AppointmentDao appointmentDao, Appointment appointment) {
        super(parent, "Update Appointment", true);
        this.appointment = appointment;

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Appointment ID Label
        JLabel idLabel = new JLabel("Appointment ID:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(idLabel, constraints);

        // Appointment ID Field
        JTextField idField = new JTextField(String.valueOf(appointment.getCustomerID()), 20);
        idField.setEditable(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(idField, constraints);

        // Name Label
        JLabel nameLabel = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(nameLabel, constraints);

        // Name Field
        JTextField nameField = new JTextField(appointment.getCustomerName(), 20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(nameField, constraints);

        // Phone Number Label
        JLabel numberLabel = new JLabel("Phone Number:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(numberLabel, constraints);

        // Phone Number Field
        JTextField numberField = new JTextField(appointment.getCustomerNumber(), 20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(numberField, constraints);

        // Address Label
        JLabel addressLabel = new JLabel("Address:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(addressLabel, constraints);

        // Address Field
        JTextField addressField = new JTextField(appointment.getCustomerAddress(), 20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(addressField, constraints);

        // Date Label
        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(dateLabel, constraints);

        // Date Field
        JTextField dateField = new JTextField(appointment.getDate(), 20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(dateField, constraints);

        // Time Label
        JLabel timeLabel = new JLabel("Time (HH:MM):");
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(timeLabel, constraints);

        // Time Field
        JTextField timeField = new JTextField(appointment.getTime(), 20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(timeField, constraints);

        // OK Button
        JButton okButton = new JButton("OK");
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(okButton, constraints);

        // Cancel Button
        JButton cancelButton = new JButton("Cancel");
        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(cancelButton, constraints);

        // Action Listener for OK Button
        okButton.addActionListener(e -> {
            appointment.setCustomerName(nameField.getText());
            appointment.setCustomerNumber(numberField.getText());
            appointment.setCustomerAddress(addressField.getText());
            appointment.setDate(dateField.getText());
            appointment.setTime(timeField.getText());
            dispose();
        });

        // Action Listener for Cancel Button
        cancelButton.addActionListener(e -> {
            dispose();
        });

        add(panel);
        pack();
        setLocationRelativeTo(parent);
    }

    public Appointment getAppointment() {
        return appointment;
    }
}