package ir.maktab.dao;

import ir.maktab.entities.Student;

import java.sql.SQLException;

public interface Dao {
    public Boolean save(Student student) throws SQLException;

    public Student load(Integer id) throws SQLException;

    public Boolean update(Student student) throws SQLException;

    public Boolean delete(Integer id) throws SQLException;

    public Student[] findAll() throws SQLException;

    public abstract void logException(String msg, String type);
}
