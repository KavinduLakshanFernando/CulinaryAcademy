package lk.ijse.dao;

import lk.ijse.entity.User;

public interface CrudDAO<T> extends SuperDAO {

    boolean saveUser(User user);
}
