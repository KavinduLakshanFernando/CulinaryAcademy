package lk.ijse.Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.ProgramBO;
import lk.ijse.dto.ProgramDTO;
import lk.ijse.tdm.ProgramTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageProgramController {

    @FXML
    private TableColumn<?, ?> ColDuration;

    @FXML
    private TableColumn<?, ?> ColFee;

    @FXML
    private TableColumn<?, ?> ColPId;

    @FXML
    private TableColumn<?, ?> ColPName;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<ProgramDTO> tblProgram;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtPId;

    @FXML
    private TextField txtPName;

    @FXML
    private TextField txtfee;

    ProgramBO programBO = (ProgramBO) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.PROGRAM);

    public void initialize() {
        setcellvaluefactory();
        getallProgram();
    }

    private void setcellvaluefactory() {
        ColPId.setCellValueFactory(new PropertyValueFactory<>("p_id"));
        ColDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        ColFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        ColPName.setCellValueFactory(new PropertyValueFactory<>("p_name"));

    }

    private void getallProgram() {
        ObservableList<ProgramDTO> programe = programBO.getAllProgram();
        tblProgram.setItems(programe);
    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String pid = txtPId.getText();

            try {
                boolean isDeleted = programBO.deleteProgram(pid);
                if (isDeleted) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User deleted!").show();
                    getallProgram();
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
                    getallProgram();
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
                    getallProgram();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

}
