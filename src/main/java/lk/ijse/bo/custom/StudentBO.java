package lk.ijse.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.bo.SuperBo;
import lk.ijse.dao.SuperDAO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.UserDTO;

import java.sql.SQLException;

public interface StudentBO extends SuperBo {

    boolean addStudent(StudentDTO studentDto, UserDTO activeUser) throws SQLException, ClassNotFoundException;

    boolean deleteStudent(String id);

    ObservableList<StudentDTO> getAllStudent();
}
