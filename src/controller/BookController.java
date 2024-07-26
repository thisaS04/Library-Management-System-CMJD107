package controller;

import dto.BookDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import service.custom.BookService;
import service.custom.Impl.BookServiceImpl;


public class BookController {
     private BookService bookService = new BookServiceImpl();
   @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Label lblId;

    @FXML
    private TableView<?> tblBooks;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtAvailability;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtCategoryID;

    @FXML
    private TextField txtId;

   

    @FXML
    void btnDeleteBookOnAction(ActionEvent event) {
    System.out.println("delete book");
    }

    @FXML
    void btnSaveBookOnAction(ActionEvent event) {
       try{

 if (txtId.getText().isEmpty() || txtBookTitle.getText().isEmpty() || 
                txtAuthor.getText().isEmpty() || txtCategoryID.getText().isEmpty() || 
                txtAvailability.getText().isEmpty()) {
                showAlert(AlertType.ERROR, "Validation Error", "Please fill in all fields.");
                return;
            }


        Long id = Long.parseLong(txtId.getText());
        String title = txtBookTitle.getText();
        String author =txtAuthor.getText();
        Long categoryId = Long.parseLong(txtCategoryID.getText());
        boolean isAvailable = Boolean.parseBoolean(txtAvailability.getText());

        //Creating bookdto object
        BookDto bookDto = new BookDto(id , title , author ,categoryId, isAvailable);


        //calling the service to save the book
        String result = bookService.save(bookDto);

      System.out.println("Book saved successfully: "+result);
} catch (Exception e){
    e.printStackTrace();;
    System.out.println("Failed to save the book: "+e.getMessage());
}
    }
    
    

    private void showAlert(AlertType alterType, String title, String message) {
        Alert alert = new Alert(alterType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void btnUpdateBookOnAction(ActionEvent event) {

    }
}





