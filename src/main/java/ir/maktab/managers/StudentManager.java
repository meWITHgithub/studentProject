package ir.maktab.managers;

import java.sql.SQLException;

import ir.maktab.dao.Dao;
import ir.maktab.dao.StudentDao;
import ir.maktab.entities.Student;

public class StudentManager implements Manager {
	private static StudentManager instance;
	private Dao studentDao = StudentDao.getInstace();

	private StudentManager() {

	}

	public static StudentManager getInstance() {
		if (instance == null) {
			instance = new StudentManager();
		}
		return instance;
	}

	@Override
	public String save(Student student) throws SQLException {
		if (studentDao.save(student)) {
			return "Student Added Successfully.";
		} else {
			return "Student Adding Rejected.";
		}
	}

	@Override
	public Student load(Integer id) throws SQLException {
		return studentDao.load(id);
	}

	@Override
	public String update(Student student) {
		try {
			if (studentDao.update(student)) {
				return "Student Updated Succesfully.";
			} else {
				return "Student Updating Rejected.";
			}
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public String delete(Integer id) throws SQLException {
		if (studentDao.delete(id)) {
			return "Student Deleted Succesfully.";
		} else {
			return "Student Deleting Rejected.";
		}
	}

	@Override
	public Student[] findAll() throws SQLException {
		Student[] students = studentDao.findAll();
		return students;
	}

	public void logException(String msg, String type) {
		studentDao.logException(msg, type);
	}
}
