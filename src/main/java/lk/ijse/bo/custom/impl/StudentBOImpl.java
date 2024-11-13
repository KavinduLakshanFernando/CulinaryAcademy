package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.dto.StudentDTO;


public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean addStudent(StudentDTO se) {
//        return studentDAO.save(new Student(se.getId(), se.getName(), se.getAddress(), se.getTel(), se.getRegDate()));
    return true;
    }
}
