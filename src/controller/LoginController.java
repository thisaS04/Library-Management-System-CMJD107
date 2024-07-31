package controller;

import java.io.IOException;

import dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import service.custom.UserService;
import service.custom.Impl.UserServiceImpl;

public class LoginController {
    
    @FXML
    private Button btnLogin;

    @FXML
    private Hyperlink hprSignUp;

    @FXML
    private PasswordField txtPW;

    @FXML
    private TextField txtusername;

    public UserService userService;
    public LoginController() {
        
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    
    @FXML
    void btnLoginOnAction(ActionEvent event) {
try{
    String username = txtusername.getText();
    String password = txtPW.getText();
    UserDto user = userService.getUserByUsername(username);

    if(user != null && user.getPassword().equals(password)){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Successful");
        alert.setHeaderText(null);
        alert.setContentText("Welcome"+user.getName()+"!");
        alert.showAndWait();


        Stage loginStage =(Stage) txtusername.getScene().getWindow();
        loginStage.close();

        //DashBoard.fxml

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashBoard.fxml"));
        Parent root = loader.load();
        Stage dashboardStage = new Stage();
        dashboardStage.setTitle("DashBoard");
        dashboardStage.setScene(new Scene(root));
        dashboardStage.show(); 
    } else {
        throw new Exception("Invalid username or password!");
    }
} catch (Exception e) {
    
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Login Error");
    alert.setHeaderText(null);
    alert.setContentText(e.getMessage());
    alert.showAndWait();
}
    }

    @FXML
    void hprSignUpOnAction(ActionEvent event) {
try {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignUp.fxml"));
    Parent root = loader.load();
    Stage signUpStage = new Stage();
    signUpStage.setTitle("Admin");
    signUpStage.setScene(new Scene(root));
   signUpStage.show(); 

} catch (IOException e) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Sign Up Error");
    alert.setHeaderText(null);
    alert.setContentText("Failed to open Sign Up page: " + e.getMessage());
    alert.showAndWait();
}
}
    

    }
   

