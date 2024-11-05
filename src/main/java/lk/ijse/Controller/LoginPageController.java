package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDTO;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

public class LoginPageController {

    @FXML
    private AnchorPane rootNode;

    String liveUserRole = "";

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    UserBO userbo = (UserBO) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.USER);
    @FXML
    void LoginFormOnAction(ActionEvent event) throws IOException {
        String id = txtPassword.getText();
        String uName = txtUserName.getText();

        if (uName.isEmpty() || id.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill all the fields").show();
        } else {
            UserDTO userDto = userbo.getdata(uName);

            if (userDto == null) {
                new Alert(Alert.AlertType.ERROR, "Invalid username").show();

            } else {
                if (BCrypt.checkpw(id, userDto.getPassword())) {
                    if (userDto.getRole().equals("admin")) {
                        System.out.println("he is admin");
                        liveUserRole = "admin";
                    } else {
                        liveUserRole = "user";
                        System.out.println("he is user");
                    }
                    loadDashBoard();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Invalid password").show();
                }
            }
        }
    }
        void loadDashBoard() throws IOException {
            FXMLLoader customerLoader = new FXMLLoader(getClass().getResource("/view/MainDashBoard.fxml"));
            Parent customerRoot = customerLoader.load();
            rootNode.getChildren().clear();
            rootNode.getChildren().add(customerRoot);

            Stage stage = (Stage) rootNode.getScene().getWindow();
            stage.setTitle("Dashboard");
        }

    @FXML
    void regFormOnAction(ActionEvent event) throws IOException {
        if (userDAO.haveAdmin()) {
            new Alert(Alert.AlertType.ERROR,"have admin").show();
        }else{
            FXMLLoader customerLoader = new FXMLLoader(getClass().getResource("/view/ManageUsers.fxml"));
            Parent customerRoot = customerLoader.load();
            rootNode.getChildren().clear();
            rootNode.getChildren().add(customerRoot);

            Stage stage = (Stage) rootNode.getScene().getWindow();
            stage.setTitle("UserForm");
        }
    }
}