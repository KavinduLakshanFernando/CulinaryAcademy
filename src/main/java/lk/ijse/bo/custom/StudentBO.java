package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dao.SuperDAO;
import lk.ijse.dto.StudentDTO;

public interface StudentBO extends SuperBo {
    boolean addStudent(StudentDTO studentDto);
}
