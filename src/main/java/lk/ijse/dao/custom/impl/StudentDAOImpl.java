package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.entity.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String pid) {
        return false;
    }

    @Override
    public boolean update(Student entity) {
        return false;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }
}
