package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.ProgramBO;
import lk.ijse.dto.ProgramDTO;

public class ManageProgramController {

    @FXML
    private TableColumn<?, ?> ColAddress;

    @FXML
    private TableColumn<?, ?> ColDuration;

    @FXML
    private TableColumn<?, ?> ColFee;

    @FXML
    private TableColumn<?, ?> ColId;

    @FXML
    private TableColumn<?, ?> ColName;

    @FXML
    private TableColumn<?, ?> ColNumber;

    @FXML
    private TableColumn<?, ?> ColPId;

    @FXML
    private TableColumn<?, ?> ColPName;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<?> tblProgram;

    @FXML
    private TableView<?> tblStudent;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtPId;

    @FXML
    private TextField txtPName;

    @FXML
    private TextField txtfee;

    ProgramBO programBO = (ProgramBO) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.PROGRAM);

    private void initialize() {
    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String pid = txtPId.getText();

            try {
                boolean isDeleted = programBO.deleteProgram(pid);
                if (isDeleted) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User deleted!").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        String pid = txtPId.getText();
        String pName = txtPName.getText();
        String duration = txtDuration.getText();
        Double fee = Double.valueOf(txtfee.getText());

        if (pid.isEmpty() || pName.isEmpty() || duration.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill all fields").show();
        }else {
            ProgramDTO programDTO = new ProgramDTO(pid,pName,duration,fee);
            try {
                boolean isSaved = programBO.saveprogram(programDTO);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User saved!").show();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }




    @FXML
    void btnSearchOnAction(ActionEvent event) {


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String pid = txtPId.getText();
        String pName = txtPName.getText();
        String duration = txtDuration.getText();
        Double fee = Double.valueOf(txtfee.getText());

        if (pid.isEmpty() || pName.isEmpty() || duration.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill all fields").show();
        }else {
            ProgramDTO programDTO = new ProgramDTO(pid,pName,duration,fee);

            try {
                boolean isSaved = programBO.updateprogram(programDTO);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Program Updated!").show();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

}
