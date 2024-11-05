package lk.ijse.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.UserDTO;
import org.mindrot.jbcrypt.BCrypt;

public class ManageUsersController {

    @FXML
    private TableColumn<?, ?> ColRole;

    @FXML
    private TableColumn<?, ?> ColUId;

    @FXML
    private TableColumn<?, ?> ColUName;

    @FXML
    private ComboBox<String> cmbRole;

    @FXML
    private TextField txtUid;

    @FXML
    private TableView<?> tblUsers;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    UserBO userBO = (UserBO) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.USER);

    public void initialize() {
        setValuesCmb();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        long id = Long.parseLong(txtUid.getText());
        String uName = txtUserName.getText();
        String password = txtPassword.getText();
        String role = cmbRole.getValue();

        String encryptpw = null;
        try {
            encryptpw = BCrypt.hashpw(password, BCrypt.gensalt());
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error while encrypting password").show();
            return;
        }

        UserDTO userDTO = new UserDTO(id,encryptpw,role, uName);
        try {
            boolean isSaved = userBO.saveUser(userDTO);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "User saved!").show();
                initialize();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    void setValuesCmb() {
        ObservableList<String> role = FXCollections.observableArrayList();

        role.add("admin");
        role.add("admissions coordinator");

        cmbRole.setItems(role);
    }

}
