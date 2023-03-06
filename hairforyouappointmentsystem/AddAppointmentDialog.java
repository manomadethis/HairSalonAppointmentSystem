package hairforyouappointmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAppointmentDialog extends JDialog {

    private JTextField idField;
    private JTextField nameField;
    private JTextField numberField;
    private JTextField addressField;
    private JTextField dateField;
    private JTextField timeField;
    private JButton okButton;
    private JButton cancelButton;

    private AppointmentDao appointmentDao;

    private Appointment appointment;

    public AddAppointmentDialog(JFrame parent, AppointmentDao appointmentDao) {
        super(parent, "Add Appointment", true);
        this.appointmentDao = appointmentDao;

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        //ID field
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("ID:"), constraints);

        constraints.gridx = 1;
        idField = new JTextField(20);
        panel.add(idField, constraints);

        // Name field
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Name:"), constraints);

        constraints.gridx = 1;
        nameField = new JTextField(20);
        panel.add(nameField, constraints);

        // Number field
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Number:"), constraints);

        constraints.gridx = 1;
        numberField = new JTextField(20);
        panel.add(numberField, constraints);

        // Address field
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Address:"), constraints);

        constraints.gridx = 1;
        addressField = new JTextField(20);
        panel.add(addressField, constraints);

        // Date field
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(new JLabel("Date:"), constraints);

        constraints.gridx = 1;
        dateField = new JTextField(20);
        panel.add(dateField, constraints);

        // Time field
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(new JLabel("Time:"), constraints);

        constraints.gridx = 1;
        timeField = new JTextField(20);
        panel.add(timeField, constraints);

        // Buttons
        constraints.gridx = 0;
        constraints.gridy = 6;
        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                appointment = new Appointment(
                        id,
                        nameField.getText(),
                        numberField.getText(),
                        addressField.getText(),
                        dateField.getText(),
                        timeField.getText()
                );
                boolean success = appointmentDao.addAppointment(appointment);
                if (success) {
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(AddAppointmentDialog.this,
                            "Unable to add appointment.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(okButton, constraints);

        constraints.gridx = 1;
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appointment = null;
                dispose();
            }
        });
        panel.add(cancelButton, constraints);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(parent);
    }

    public Appointment getAppointment() {
        return appointment;
    }
}
