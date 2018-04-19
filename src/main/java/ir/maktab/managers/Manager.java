package ir.maktab.managers;

import ir.maktab.entities.Student;

import java.sql.SQLException;

public interface Manager {
	public String save(Student student) throws SQLException;

	public Student load(Integer id) throws SQLException;

	public String update(Student student) throws SQLException;

	public String delete(Integer id) throws SQLException;

	public Student[] findAll() throws SQLException;
}
