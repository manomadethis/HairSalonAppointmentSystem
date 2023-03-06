import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AppointmentGUI extends JFrame {

    // Instance variables
    private JLabel titleLabel;
    private JTable appointmentTable;
    private JScrollPane tableScrollPane;
    private JButton addButton;
    private JButton updateButton;
    private JButton removeButton;

    // Constructor
    public AppointmentGUI(ArrayList<Appointment> appointments) {

        // Set the window properties
        setTitle("Hair Salon Appointment Management System");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the GUI components
        titleLabel = new JLabel("Appointments");
        appointmentTable = new JTable(new AppointmentTableModel(appointments));
        tableScrollPane = new JScrollPane(appointmentTable);
        addButton = new JButton("Add Appointment");
        updateButton = new JButton("Update Appointment");
        removeButton = new JButton("Remove Appointment");

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
    }

    // Inner class for the table model
    public class AppointmentTableModel extends AbstractTableModel {
      

        // Instance variables
        private static final int ID_COL = 0;
        private static final int NAME_COL = 1;
        private static final int NUMBER_COL = 2;
        private static final int ADDRESS_COL = 3;
        private static final int DATE_COL = 4;
        private static final int TIME_COL = 5;
        private String[] columnNames = { "ID", "Customer Name", "Customer Number", "Customer Address", "Date", "Time" };
        private ArrayList<Appointment> appointments;
    
        // Constructor
        public AppointmentTableModel(ArrayList<Appointment> appointments) {
            this.appointments = appointments;
        }
    
        // Getters and setters
        @Override
        public int getColumnCount() {
            return columnNames.length;
        }
    
        @Override
        public int getRowCount() {
            return appointments.size();
        }
    
        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }
    
        @Override
        public Object getValueAt(int row, int col) {
            Appointment appointment = appointments.get(row);
    
            switch (col) {
            case ID_COL:
                return appointment.hashCode();
            case NAME_COL:
                return appointment.getCustomerName();
            case NUMBER_COL:
                return appointment.getCustomerNumber();
            case ADDRESS_COL:
                return appointment.getCustomerAddress();
            case DATE_COL:
                return appointment.getDate();
            case TIME_COL:
                return appointment.getTime();
            default:
                return null;
            }
        }
    
        // Override getColumnClass method to display the correct class for each column
        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
    }
}
