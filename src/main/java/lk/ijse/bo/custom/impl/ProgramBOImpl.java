package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ProgramBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ProgramDAO;
import lk.ijse.dto.ProgramDTO;
import lk.ijse.entity.Program;

import java.sql.SQLException;

public class ProgramBOImpl implements ProgramBO {

    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PROGRAM);

    @Override
    public boolean saveprogram(ProgramDTO e) throws SQLException, ClassNotFoundException {
        return programDAO.save(new Program(e.getP_id(), e.getP_name(), e.getDuration(), e.getFee()));
    }

    @Override
    public boolean deleteProgram(String pid) {
        return programDAO.delete(pid);
    }

    @Override
    public boolean updateprogram(ProgramDTO e) {
        return programDAO.update(new Program(e.getP_id(), e.getP_name(), e.getDuration(), e.getFee()));
    }
}
