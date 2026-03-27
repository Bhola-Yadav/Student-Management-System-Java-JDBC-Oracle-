package dao;

import java.sql.*;
import Model.Student;
import util.DBConnection;

public class StudentDAO {

    public void addStudent(Student s) throws Exception {
        Connection con = DBConnection.getConnection();

        String query = "INSERT INTO students(name, age, course) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, s.getName());
        ps.setInt(2, s.getAge());
        ps.setString(3, s.getCourse());

        ps.executeUpdate();
        System.out.println("Student Added!");
    }

    public void viewStudents() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM students");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " " +
                            rs.getString("name") + " " +
                            rs.getInt("age") + " " +
                            rs.getString("course")
            );
        }
    }

    public void deleteStudent(int id) throws Exception {
        Connection con = DBConnection.getConnection();

        String query = "DELETE FROM students WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Deleted!");
    }

    public void updateStudent(int id, String name) throws Exception {
        Connection con = DBConnection.getConnection();

        String query = "UPDATE students SET name=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, name);
        ps.setInt(2, id);

        ps.executeUpdate();
        System.out.println("Updated!");
    }
}
