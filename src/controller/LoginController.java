package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
     @FXML
    private Button btnLogin;

    @FXML
    private Hyperlink hprSignUp;

    @FXML
    private AnchorPane root;

    @FXML
    private PasswordField txtPW;

    @FXML
    private TextField txtusername;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
    Stage stage = (Stage) root.getScene().getWindow();
    stage.setTitle("Welcome to Library Management");
    stage.centerOnScreen();
    stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/DashBoard.fxml"))));
    }

    @FXML
    void hprSignUpOnAction(ActionEvent event) throws IOException {
    Stage stage = (Stage) root.getScene().getWindow();
    stage.setTitle("Admin");
    stage.centerOnScreen();
    stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/SignUp.fxml"))));
    }
   
}
