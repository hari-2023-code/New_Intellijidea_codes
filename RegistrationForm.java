import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegistrationForm extends JFrame implements ActionListener {

    JLabel lblTitle;
    JLabel lblFName, lblLName, lblGender, lblDOB, lblAddress;
    JLabel lblPhone, lblEmail, lblCourse, lblSemester, lblRegDate;

    JTextField txtFName, txtLName, txtGender, txtDOB, txtAddress;
    JTextField txtPhone, txtEmail, txtCourse, txtSemester, txtRegDate;

    JButton btnRegister, btnClear;

    public RegistrationForm() {

        setTitle("Student Registration Form");
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(12, 2, 10, 10));

        lblTitle = new JLabel("STUDENT REGISTRATION FORM");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        lblFName = new JLabel("First Name");
        lblLName = new JLabel("Last Name");
        lblGender = new JLabel("Gender");
        lblDOB = new JLabel("Date of Birth (yyyy-mm-dd)");
        lblAddress = new JLabel("Address");
        lblPhone = new JLabel("Phone");
        lblEmail = new JLabel("Email");
        lblCourse = new JLabel("Course");
        lblSemester = new JLabel("Semester");
        lblRegDate = new JLabel("Registration Date (yyyy-mm-dd)");

        txtFName = new JTextField();
        txtLName = new JTextField();
        txtGender = new JTextField();
        txtDOB = new JTextField();
        txtAddress = new JTextField();
        txtPhone = new JTextField();
        txtEmail = new JTextField();
        txtCourse = new JTextField();
        txtSemester = new JTextField();
        txtRegDate = new JTextField();

        btnRegister = new JButton("Register");
        btnClear = new JButton("Clear");

        add(lblTitle);
        add(new JLabel(""));

        add(lblFName);
        add(txtFName);

        add(lblLName);
        add(txtLName);

        add(lblGender);
        add(txtGender);

        add(lblDOB);
        add(txtDOB);

        add(lblAddress);
        add(txtAddress);

        add(lblPhone);
        add(txtPhone);

        add(lblEmail);
        add(txtEmail);

        add(lblCourse);
        add(txtCourse);

        add(lblSemester);
        add(txtSemester);

        add(lblRegDate);
        add(txtRegDate);

        add(btnRegister);
        add(btnClear);

        btnRegister.addActionListener(this);
        btnClear.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRegister) {

            if (txtFName.getText().trim().isEmpty()
                    || txtLName.getText().trim().isEmpty()
                    || txtEmail.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please fill all required fields.");
                return;
            }

            try {

                Connection con = DBConnection.getConnection();

                if (con == null) {
                    JOptionPane.showMessageDialog(null,
                            "Database Connection Failed.");
                    return;
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "Database Connection .");

                }

                String sql = "INSERT INTO student(first_name,last_name,gender,date_of_birth,address,phone,email,course,semester,registration_date)"
                        + " VALUES(?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, txtFName.getText());
                ps.setString(2, txtLName.getText());
                ps.setString(3, txtGender.getText());
                ps.setDate(4, Date.valueOf(txtDOB.getText()));
                ps.setString(5, txtAddress.getText());
                ps.setString(6, txtPhone.getText());
                ps.setString(7, txtEmail.getText());
                ps.setString(8, txtCourse.getText());
                ps.setInt(9, Integer.parseInt(txtSemester.getText()));
                ps.setDate(10, Date.valueOf(txtRegDate.getText()));

                int result = ps.executeUpdate();

                if (result > 0) {
                    JOptionPane.showMessageDialog(this,
                            "Student Registered Successfully.");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Registration Failed.");
                }

                ps.close();
                con.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage());
            }
        }

        if (e.getSource() == btnClear) {
            clearFields();
        }
    }

    private void clearFields() {

        txtFName.setText("");
        txtLName.setText("");
        txtGender.setText("");
        txtDOB.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtCourse.setText("");
        txtSemester.setText("");
        txtRegDate.setText("");

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationForm());
    }
}