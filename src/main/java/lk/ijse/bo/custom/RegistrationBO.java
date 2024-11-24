package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.PaymentDTO;
import lk.ijse.dto.RegistrationDTO;

public interface RegistrationBO extends SuperBo {
    String genarateNewId();

    boolean saveRegistration(RegistrationDTO registrationDTO, PaymentDTO paymentDTO);
}
