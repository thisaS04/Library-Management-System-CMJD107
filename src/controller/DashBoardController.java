package controller;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class DashBoardController {
   @FXML
    private Button btnMembers;

    @FXML
    private Button btnbookCategories;

    @FXML
    private Button btnbooks;

    @FXML
    private Button btnborrowings;

    @FXML
    private Button btnfines;

    @FXML
    private Button btnsignUp;

    @FXML
    private Label lblWelcomeH;

    @FXML
    private AnchorPane main;


    private Stage stage;
    private Scene scene;


    @FXML
    void btnBookCategoriesOnAction(ActionEvent event) {
        loadView("BookCategories.fxml");
   
    }



    @FXML
    void btnBooksOnAction(ActionEvent event) {
        loadView("Books.fxml");
    }

    @FXML
    void btnBorrowingsOnAction(ActionEvent event) {
        loadView("Borrowings.fxml");
        
    }

    @FXML
    void btnFinesOnAction(ActionEvent event) {
        loadView("fines.fxml");
      
    }

    @FXML
    void btnMembersOnAction(ActionEvent event){
        loadView("Members.fxml");
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event)  {
        loadView("SignUp.fxml");
    }
    private void loadView(String fxmlFile) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/" + fxmlFile));
            stage = (Stage) main.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    

