import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Scanner;

public class CRUD {

    static String url = "jdbc:mysql://localhost:3306/collegedb";
    static String user = "root";
    static String pass = "";

    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);

        try{
            Connection con = DriverManager.getConnection (url, user, pass);

            System.out.println("1.Insert");
            System.out.println("2.Update");
            System.out.println("3.Dispaly");
            System.out.println("4.Delete");
            System.out.println("Enter choice");

            int ch = sc.nextInt();
            sc.nextInt();

            switch (ch){
                case 1:

                    System.out.print("Enter First Name: ");
                    String fname = sc.nextLine();

                    System.out.print("Enter Last Name: ");
                    String lname = sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
                    String dob = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Semester: ");
                    int semester = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Registration Date (yyyy-mm-dd): ");
                    String regDate = sc.nextLine();


                    PreparedStatement ps1 = con.prepareStatement("INSERT INTO student(first_name, last_name, gender, date_of_birth, address, phone, email, course, semester, registration_date)VALUES(,?,?,?,?,?,?,?,?,?,?)");

                    ps1.setString(1, fname);
                    ps1.setString(2, lname);
                    ps1.setString(3, gender);
                    ps1.setDate(4, Date.valueOf(dob));
                    ps1.setString(5, address);
                    ps1.setString(6, phone);
                    ps1.setString(7, email);
                    ps1.setString(8, course);
                    ps1.setInt(9, semester);
                    ps1.setDate(10, Date.valueOf(regDate));

                    ps1.executeUpdate();

                    System.out.println("Record Inserted");
                    break;


                case 2:
                    System.out.print("Enter Student ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New First Name: ");
                     fname = sc.nextLine();

                    System.out.print("Enter New Last Name: ");
                     lname = sc.nextLine();

                    System.out.print("Enter Gender: ");
                    gender = sc.nextLine();

                    System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
                     dob = sc.nextLine();

                    System.out.print("Enter New Address: ");
                     address = sc.nextLine();

                    System.out.print("Enter  New Phone: ");
                     phone = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    email = sc.nextLine();

                    System.out.print("Enter Course: ");
                     course = sc.nextLine();

                    System.out.print("Enter Semester: ");
                     semester = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Registration Date (yyyy-mm-dd): ");
                     regDate = sc.nextLine();

                    PreparedStatement ps2 = con.prepareStatement("UPDATE student SET first_name=?, last_name=?, gender=?, date_of_birth=?, address=?, phone=?, email=?, course=?, semester=?, registration_date=? WHERE student_id=? ");


                    ps2.setString(1, fname);
                    ps2.setString(2, lname);
                    ps2.setString(3, gender);
                    ps2.setDate(4, Date.valueOf(dob));
                    ps2.setString(5, address);
                    ps2.setString(6, phone);
                    ps2.setString(7, email);
                    ps2.setString(8, course);
                    ps2.setInt(9, semester);
                    ps2.setDate(10, Date.valueOf(regDate));
                    ps2.setInt(11, id);
                    ps2.executeUpdate();

                    System.out.println("Record Updated");
                    break;


                case 3:
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM student");

                    System.out.println("\nID\tfname\tlname\tgender\tDate.valueOf(dob)\taddress\tphone\temail\tcourse\tsemester\tDate.valueOf(regDate)");
                    while (rs.next()){
                        System.out.println(
                                 rs.getInt("student_id") + "\t"+
                         rs.getString("first_name") + "\t"+
                         rs.getString("last_name") + "\t"+
                         rs.getString("gender") + "\t"+
                         rs.getDate("date_of_birth") + "\t"+
                         rs.getString("address") + "\t"+
                         rs.getString("phone") + "\t"+
                         rs.getString("email") + "\t"+
                         rs.getString("course") + "\t"+
                         rs.getInt("semester") + "\t"+
                         rs.getDate("registration_date")
                        );


                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();



                    PreparedStatement ps3 = con.prepareStatement("DELETE FROM student WHERE student_id = ?");

                    ps3.setInt( 1,id);
                    ps3.executeUpdate();

                    System.out.println("Record Delected");
                    break;

                default:
                    System.out.println("Invalid Choice");




            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}
