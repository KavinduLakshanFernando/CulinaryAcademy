package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.bo.custom.UserBO;
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

//    UserBO userBO = (UserBO) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.USER);
//    StudentBO studentBO = (StudentBO) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.STUDENT);


    public void initialize() {
        System.out.println(role);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

//        UserDTO userDto = userBO.getdatabyRole(role);
//
//        String id = txtId.getText();
//        String name = txtName.getText();
//        String address = txtAddress.getText();
//        String tel = txtNumber.getText();
//        String regDate = registerDate.getValue().toString();
//
//        StudentDto studentDto = new StudentDto(id, name, email, tel, address, dob);
//        boolean result = studentBo.addStudent(studentDto,userDto);
//        if (result){
//            getallStudent();
//            new Alert(Alert.AlertType.CONFIRMATION, "Add Successful").show();
//        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
