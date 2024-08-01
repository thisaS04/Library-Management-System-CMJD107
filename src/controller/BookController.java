package controller;

import java.io.IOException;

import dto.BookDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import service.custom.BookService;
import service.custom.Impl.BookServiceImpl;


public class BookController {
    private BookService bookService = new BookServiceImpl();

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<BookDto, String> colAuthor;

    @FXML
    private TableColumn<BookDto, Boolean> colAvailable;

    @FXML
    private TableColumn<BookDto, Long> colCategoryId;

    @FXML
    private TableColumn<BookDto, Long> colId;

    @FXML
    private TableColumn<BookDto, String> colTitle;

    @FXML
    private Label lblId;

    @FXML
    private TableView<BookDto> tblBooks;

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
    void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colCategoryId.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        colAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));

        loadTableData();

    }

    private void loadTableData() {
        try{
            ObservableList<BookDto> bookList = FXCollections.observableArrayList(bookService.getAll());
            tblBooks.setItems(bookList);
          }catch (Exception e){
              showAlert(AlertType.ERROR,"Error","Failed to load book data");
              e.printStackTrace();
          }
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void btnDeleteBookOnAction(ActionEvent event) {
     try {
        Long id = Long.parseLong(txtId.getText());
        String result = bookService.delete(id);
        showAlert(AlertType.INFORMATION, "info", result);
        loadTableData();
        clearFields();
     } catch (Exception e){
        showAlert(AlertType.ERROR, "Error","Failed to delete the book");
        e.printStackTrace();
     }
    }
   
    @FXML
    void btnSaveBookOnAction(ActionEvent event) {
        try {
            if (txtBookTitle.getText().isEmpty() || txtAuthor.getText().isEmpty() ||
                txtCategoryID.getText().isEmpty() || txtAvailability.getText().isEmpty()) {
                showAlert(AlertType.ERROR, "Validation Error", "Please fill in all fields.");
                return;
            }

            String title = txtBookTitle.getText();
            String author = txtAuthor.getText();
            Long categoryId = Long.parseLong(txtCategoryID.getText());
            boolean isAvailable = Boolean.parseBoolean(txtAvailability.getText());

            BookDto bookDto = new BookDto(null, title, author, categoryId, isAvailable);

            String result = bookService.save(bookDto);
            showAlert(AlertType.INFORMATION, "Info", result);
            loadTableData();
            clearFields();
        } catch (Exception e) {
            showAlert(AlertType.ERROR, "Error", "Failed to save the book.");
            e.printStackTrace();
        }
}

    @FXML
    void btnUpdateBookOnAction(ActionEvent event) {
        try {
            if (txtBookTitle.getText().isEmpty() || txtAuthor.getText().isEmpty() ||
                txtCategoryID.getText().isEmpty() || txtAvailability.getText().isEmpty()) {
                showAlert(AlertType.ERROR, "Validation Error", "Please fill in all fields.");
                return;
            }
            Long id = Long.parseLong(txtId.getText());
            String title = txtBookTitle.getText();
            String author = txtAuthor.getText();
            Long categoryId = Long.parseLong(txtCategoryID.getText());
            boolean isAvailable = Boolean.parseBoolean(txtAvailability.getText());

            BookDto bookDto = new BookDto(null, title, author, categoryId, isAvailable);
             
            String result = bookService.update(bookDto);
            showAlert(AlertType.INFORMATION, "Info", result);
            loadTableData();
            clearFields();
        } catch (Exception e) {
            showAlert(AlertType.ERROR, "Error", "Failed to Update the book.");
            e.printStackTrace();
        }
  
    }


    private void clearFields() {
        txtId.clear();
        txtBookTitle.clear();
        txtAuthor.clear();
        txtCategoryID.clear();
        txtAvailability.clear();
    }

    @FXML
    void btnBackBookOnAction(ActionEvent event) {
       try {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashBoard.fxml"));
            Parent root = loader.load();
            Stage dashBoardStage = new Stage();
            dashBoardStage.setTitle("Back");
            dashBoardStage.setScene(new Scene(root));
            dashBoardStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        }
    }









