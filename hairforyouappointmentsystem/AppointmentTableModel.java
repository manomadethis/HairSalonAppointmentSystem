package hairforyouappointmentsystem;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AppointmentTableModel extends AbstractTableModel {
    
    private static final String[] COLUMN_NAMES = {"ID", "Name", "Number", "Address", "Date", "Time"};
    private static final int ID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int NUMBER_COL = 2;
    private static final int ADDRESS_COL = 3;
    private static final int DATE_COL = 4;
    private static final int TIME_COL = 5;
    
    private List<Appointment> appointments;
    
    public AppointmentTableModel(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public int getRowCount() {
        return appointments.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Appointment appointment = appointments.get(rowIndex);
        switch (columnIndex) {
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
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Appointment appointment = appointments.get(rowIndex);
        switch (columnIndex) {
            case ID_COL:
                // Do nothing, ID is read-only
                break;
            case NAME_COL:
                appointment.setCustomerName((String) value);
                break;
            case NUMBER_COL:
                appointment.setCustomerNumber((String) value);
                break;
            case ADDRESS_COL:
                appointment.setCustomerAddress((String) value);
                break;
            case DATE_COL:
                appointment.setDate((String) value);
                break;
            case TIME_COL:
                appointment.setTime((String) value);
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != ID_COL;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    //Getters
    public Appointment getAppointmentAt(int rowIndex) {
        return appointments.get(rowIndex);
    }
}
