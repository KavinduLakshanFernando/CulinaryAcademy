package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.ProgramDTO;

import java.sql.SQLException;

public interface ProgramBO extends SuperBo {

    boolean saveprogram(ProgramDTO programDTO) throws SQLException, ClassNotFoundException;

    boolean deleteProgram(String pid);

    boolean updateprogram(ProgramDTO programDTO);
}
