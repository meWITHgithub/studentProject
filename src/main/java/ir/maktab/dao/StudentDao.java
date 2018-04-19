package ir.maktab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import ir.maktab.entities.Student;

public class StudentDao extends DaoImp {
    private static StudentDao instance;

    private StudentDao() {
        super();
    }

    public static StudentDao getInstace() {
        if (instance == null) {
            instance = new StudentDao();
        }
        return instance;
    }

    @Override
    public Boolean save(Student student) throws SQLException {
        String query = "INSERT INTO student(id,fname,lname,department,teacher_id) VALUES(?,?,?,?,?)";
        ps = connection.prepareStatement(query);
        ps.setInt(1, student.getId());
        ps.setString(2, student.getfName());
        ps.setString(3, student.getlName());
        ps.setString(4, student.getDept());
        ps.setInt(5, student.getTeacherId());
        ps.executeUpdate();
        return true;
    }

    @Override
    public Student load(Integer id) throws SQLException {
        String query = "SELECT * FROM student WHERE id=?";
        ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setfName(rs.getString("fname"));
        student.setlName(rs.getString("lname"));
        student.setDept(rs.getString("department"));
        student.setTeacherId(rs.getInt("teacher_id"));
        return student;
    }

    @Override
    public Boolean update(Student student) throws SQLException {
        String query = "UPDATE student SET fname=?, lname=?, department=?, teachdr_id=? WHERE id=?";
        ps = connection.prepareStatement(query);
        ps.setString(1, student.getfName());
        ps.setString(2, student.getlName());
        ps.setString(3, student.getDept());
        ps.setInt(4,student.getTeacherId());
        ps.setInt(5, student.getId());
        ps.executeUpdate();
        return true;
    }

    @Override
    public Boolean delete(Integer id) throws SQLException {
        String query = "DELETE FROM student WHERE id=?";
        ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        return true;
    }

    @Override
    public Student[] findAll() throws SQLException {
        String query = "SELECT * FROM student";
        ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.last();
        int length = rs.getRow();
        rs.beforeFirst();
        Student[] students = new Student[length];
        int i = 0;
        while (rs.next()) {
            students[i] = new Student();
            students[i].setId(rs.getInt("id"));
            students[i].setfName(rs.getString("fname"));
            students[i].setlName(rs.getString("lname"));
            students[i].setDept(rs.getString("department"));
            students[i].setTeacherId(rs.getInt("teacher_id"));
            i++;
        }
        return students;
    }

    @Override
    public void logException(String msg, String type) {
        try {
            String query = "INSERT INTO logs(msg,type) VALUES(?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, msg);
            ps.setString(2, type);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

}
