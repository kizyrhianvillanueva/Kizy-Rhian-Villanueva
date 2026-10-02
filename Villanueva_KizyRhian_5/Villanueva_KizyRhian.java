import java.awt.*;
import javax.swing.*;

public class Villanueva_KizyRhian{
    public static void main(String[] args){
        JFrame frame = new JFrame("Campus Event Registration System");
        frame.setSize(1000,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));

        JLabel lblName = new JLabel("Participant Name: ");
        JTextField txtName = new JTextField(20);
        
        JLabel lblage = new JLabel("Age: ");
        JTextField txtage = new JTextField(20);

        JLabel lblCollegeDepartment= new JLabel("College/Department: ");
        JTextField txtCollegeDepartment = new JTextField(20);
        
        
        //isa ra ang ma pili
        JLabel lblevent = new JLabel("Event Category: ");
        String[] EventCategory = {"Select Event","Programming Competition ","Web Design Challenge", "Cybersecurity Seminar", "AI and Emerging Technologies", "IT Quiz Bowl"};
        JComboBox<String> cmbevent = new JComboBox<>(EventCategory);

        //daghan ang imong mga pili
        JLabel lblAttendanceType = new JLabel("Attendance Type: ");
        JRadioButton a = new JRadioButton("Student Participant");
        JRadioButton b = new JRadioButton("Student Audience");
        JRadioButton c = new JRadioButton("Faculty/Staff");
        
        //isa ra ang need pilion
        ButtonGroup AttendanceType = new ButtonGroup();
        AttendanceType.add(a);
        AttendanceType.add(b);
        AttendanceType.add(c);
        
        JLabel lblWorkshop = new JLabel("Workshops to Attend: ");
        JCheckBox v1 = new JCheckBox("Java Programming");
        JCheckBox v2 = new JCheckBox("Web Development ");
        JCheckBox v3 = new JCheckBox("Cybersecurity");
        JCheckBox v4 = new JCheckBox("Artificial Intelligence ");
        JCheckBox v5 = new JCheckBox("Database Management");

        JLabel lblSpecialRequest = new JLabel("SpecialRequest:");
        JTextArea txtSpecialRequest = new JTextArea(5,30);

        //mo down pagmotype
        txtSpecialRequest.setLineWrap(true);
        txtSpecialRequest.setWrapStyleWord(true);

        // naay button na
        JButton btnREGISTER= new JButton("REGISTER");
        JButton btnCLEAR = new JButton("CLEAR");
        

        



        //components
        frame.add(lblName);
        frame.add(txtName);
        frame.add(lblage);
        frame.add(txtage);
        frame.add(lblCollegeDepartment);
        frame.add(txtCollegeDepartment);
        frame.add(lblevent);
        frame.add(cmbevent);
        frame.add(lblAttendanceType);
        frame.add(a);
        frame.add(b);
        frame.add(c);
        frame.add(lblWorkshop);
        frame.add(v1);
        frame.add(v2);
        frame.add(v3);
        frame.add(v4);
        frame.add(v5);
        frame.add(lblSpecialRequest);
        frame.add(txtSpecialRequest);
        frame.add(btnREGISTER);
        frame.add(btnCLEAR);
       

        btnREGISTER.addActionListener(e ->{
            String Name = txtName.getText().trim();
            String ageText = txtage.getText().trim();
            String CollegeDepartment= txtCollegeDepartment.getText().trim();
            String event= cmbevent.getSelectedItem().toString();
            String choice = AttendanceType.toString();

            if (Name.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please enter the participant name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (ageText.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please enter the age.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int age;

            try {

                age = Integer.parseInt(ageText);

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a valid whole number for age.",
                        "Invalid Age",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            if (age <= 0) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Age must be greater than zero.",
                        "Invalid Age",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            if (CollegeDepartment.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter the college/department.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            if (cmbevent.getSelectedIndex() == 0) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select an event category.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }



            if (a.isSelected()) {
                choice = "Student Participant";
                
            }else if (b.isSelected()){
                choice = "Student Audience";
            }else if (c.isSelected()){
                choice = "Faculty/Staff";
            }
            

            String Workshop = "";
            if(v1.isSelected()){
                Workshop += "Java Programming, ";
            }if (v2.isSelected()){
                Workshop += "Web Development, ";
            }if(v3.isSelected()){
                Workshop += "Cybersecurity, ";
            }if(v4.isSelected()){
               Workshop += "Artificial Intelligence, ";
            }if(v5.isSelected()){
                Workshop += "Database Management, ";
            }

            if (!Workshop.isEmpty()) {
                Workshop = Workshop.substring(0, Workshop.length() - 2);
            } else {
                Workshop = "None";
            }

            
            String SpecialRequest = txtSpecialRequest.getText().trim();


            String message = "DATA ENTRY\n\n" + "NAME: " + Name + "\nAge: " + age + "\nCollegeDepartment: " + CollegeDepartment +"\nEvent Category: " + event + "\nAttendanceType:" + choice + "\nWorkshops to Attend: " + Workshop+ "\nSpecialRequest: " + SpecialRequest;
            JOptionPane.showMessageDialog(frame,message);

        });


        // CLEAR BUTTON
        btnCLEAR.addActionListener(e ->{
            txtName.setText("");
            txtage.setText("");
            txtCollegeDepartment.setText("");
            txtSpecialRequest.setText("");

            cmbevent.setSelectedIndex(0);

            AttendanceType.clearSelection();

            v1.setSelected(false);
            v2.setSelected(false);
            v3.setSelected(false);
            v4.setSelected(false);
            v5.setSelected(false);
        });
        
        
        
        frame.setLocationRelativeTo(null);
        

        frame.setVisible(true);

        
    }
}


