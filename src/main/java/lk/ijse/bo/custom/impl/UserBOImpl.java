package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;


public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean saveUser(UserDTO e) {
        return userDAO.saveUser(new User(e.getUserId(),e.getPassword(),e.getRole(),e.getUsername()));
    }

    @Override
    public UserDTO getdata(String uName) {
        User user = userDAO.getdata(uName);
        if (user == null) {
            return null;

        } else {
            return new UserDTO(user.getU_id(), user.getPassword(), user.getRole(), user.getU_name());
        }
    }
}
