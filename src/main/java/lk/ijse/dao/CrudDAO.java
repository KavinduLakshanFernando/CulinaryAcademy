package lk.ijse.dao;

import lk.ijse.entity.Program;
import lk.ijse.entity.User;

import java.sql.SQLException;

public interface CrudDAO<T> extends SuperDAO {

    boolean save(T entity) throws SQLException, ClassNotFoundException;;

    boolean delete(String pid);

    boolean update(T entity);
}
