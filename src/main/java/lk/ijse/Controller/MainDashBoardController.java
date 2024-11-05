package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainDashBoardController {

    @FXML
    private AnchorPane nodePane;

    @FXML
    private AnchorPane rootNode;

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        try {
            FXMLLoader customerLoader = new FXMLLoader(getClass().getResource("/view/DashBoard.fxml"));
            Parent customerRoot = customerLoader.load();
            rootNode.getChildren().clear();
            rootNode.getChildren().add(customerRoot);

            Stage stage = (Stage) rootNode.getScene().getWindow();
            stage.setTitle("dashboard");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnProgramsOnAction(ActionEvent event) throws IOException {
        FXMLLoader productLoader = new FXMLLoader(getClass().getResource("/view/ManageProgram.fxml"));
        Parent productRoot = productLoader.load();
        rootNode.getChildren().clear();
        rootNode.getChildren().add(productRoot);

        Stage stage = (Stage) rootNode.getScene().getWindow();
        stage.setTitle("");
    }

    @FXML
    void btnRegistrationOnAction(ActionEvent event) {
    }

    @FXML
    void btnStudentsOnAction(ActionEvent event) throws IOException {
        FXMLLoader productLoader = new FXMLLoader(getClass().getResource("/view/ManageStudent.fxml"));
        Parent productRoot = productLoader.load();
        rootNode.getChildren().clear();
        rootNode.getChildren().add(productRoot);

        Stage stage = (Stage) rootNode.getScene().getWindow();
        stage.setTitle("");
    }

    @FXML
    void btnUserOnAction(ActionEvent event) {
        try {
            FXMLLoader customerLoader = new FXMLLoader(getClass().getResource("/view/ManageUsers.fxml"));
            Parent customerRoot = customerLoader.load();
            rootNode.getChildren().clear();
            rootNode.getChildren().add(customerRoot);

            Stage stage = (Stage) rootNode.getScene().getWindow();
            stage.setTitle("UserForm");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

