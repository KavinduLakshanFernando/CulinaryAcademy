package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.UserDTO;

public interface UserBO extends SuperBo {
    boolean saveUser(UserDTO userDTO);

    UserDTO getdata(String uName);
}
