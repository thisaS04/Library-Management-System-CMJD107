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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.custom.UserService;


public class SignUpController {
      @FXML
    private Button btnBack;

    @FXML
    private Button btnRegister;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtUserName;


    private UserService userService;
   public void setUserService(UserService userService){
    this.userService =userService;
   }
@FXML

    void btnRegisterOnAction(ActionEvent event) {
    
 try{
    String name = txtName.getText();
    String username = txtUserName.getText();
    String phone = txtPhone.getText();
    String password = txtPassword.getText();

    UserDto user = new UserDto(name,username,phone,password);
    String result = userService.saveUser(user);


    if(result.equals("User saved Successfully.")){
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registration Successful");
                alert.setHeaderText(null);
                alert.setContentText("User registered successfully!");
                alert.showAndWait();
            Stage signUpStage = (Stage) txtName.getScene().getWindow();
                signUpStage.close();      
    } else {
        throw new Exception(result);
    }
 }catch (Exception e) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Registration Error");
    alert.setHeaderText(null);
    alert.setContentText(e.getMessage());
    alert.showAndWait();
    }
}

@FXML
    void btnBackOnAction(ActionEvent event) {
  try {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Parent root = loader.load();
            Stage loginStage = new Stage();
            loginStage.setTitle("Login");
            loginStage.setScene(new Scene(root));
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    










