package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.UserDTO;

import java.sql.Date;

public class ManageStudentController {

    @FXML
    private TableColumn<?, ?> ColAddress;

    @FXML
    private TableColumn<?, ?> ColId;

    @FXML
    private TableColumn<?, ?> ColName;

    @FXML
    private TableColumn<?, ?> ColNumber;

    @FXML
    private DatePicker registerDate;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<?> tblStudent;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNumber;

    static String role;

StudentBO studentBO = (StudentBO) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.STUDENT);


    public void initialize() {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtNumber.getText();
        String regDate = String.valueOf(registerDate.getValue());

        StudentDTO studentDto = new StudentDTO(id, name, address, tel, regDate);
        boolean result = studentBO.addStudent(studentDto);
        if (result){
            new Alert(Alert.AlertType.CONFIRMATION, "Add Successful").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
