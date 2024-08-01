package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import dao.custom.BorrowingsDao;
import dto.BorrowingsDto;
import dto.MemberDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.BorrowingService;

public class BorrowingsController {

    @FXML
    private Button btnBack;
     
    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<BorrowingsDto, Long> colBookId;

    @FXML
    private TableColumn<BorrowingsDto, LocalDate> colBorrowingDate;

    @FXML
    private TableColumn<BorrowingsDto, Long> colBorrowingId;

    @FXML
    private TableColumn<BorrowingsDto, LocalDate> colDueDate;

    @FXML
    private TableColumn<BorrowingsDto, Integer> colMemberId;

    @FXML
    private TableColumn<BorrowingsDto, LocalDate> colReturnDate;

    @FXML
    private TextField dpBorrowingDate;

    @FXML
    private TextField dpDueDate;

    @FXML
    private TextField dpReturnDate;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblBorrowingDate;

    @FXML
    private Label lblBorrowingId;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblMemberId;

    @FXML
    private Label lblReturnDate;

    @FXML
    private TableView<BorrowingsDto> tableBorrowings;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBorrowingId;

    @FXML
    private TextField txtMemberId;



    //Use the dates as yyyy-mm-dd
    private BorrowingService borrowingService;
    public BorrowingsController(){
        this.borrowingService = (BorrowingService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BORROWINGS);
    }

     @FXML
    public void initialize(){
        colBorrowingId.setCellValueFactory(new PropertyValueFactory<>("borrowingId"));
        colBookId.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colBorrowingDate.setCellValueFactory(new PropertyValueFactory<>("borrowing_date"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("due_date"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("return_date"));
        
        loadBorrowings();
    }
     
    private void loadBorrowings() {
         try {
            ArrayList<BorrowingsDto> borrowings = (ArrayList<BorrowingsDto>) borrowingService.getAllBorrowings();
            ObservableList<BorrowingsDto> borrowingList = FXCollections.observableArrayList(borrowings);
            tableBorrowings.setItems(borrowingList);
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load borrowings");
        }
    }

    private void showAlert(AlertType error, String title, String message) {
        Alert alert = new Alert(error);
      alert.setTitle(title);
      alert.setHeaderText(null);
      alert.setContentText(message);
      alert.showAndWait();
    }

    @FXML
    void btnClearBorrowingOnAction(ActionEvent event) {
    cleaeFields();
    }
    private void cleaeFields() {
        txtBorrowingId.clear();
        txtBookId.clear();
        txtMemberId.clear();
        dpBorrowingDate.clear();
        dpDueDate.clear();
        dpReturnDate.clear();
    }

 
   

    @FXML
    void btnDeleteBorrowingOnAction(ActionEvent event) {
        try{
            Long borrowingId =Long.parseLong(txtBorrowingId.getText());
            String result = borrowingService.delete(borrowingId);
            showAlert(AlertType.INFORMATION, "Success", "Borrowed Book deleted successfully: " + result);
        loadBorrowings();
    } catch (Exception e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Error", "Failed to delete Borrowed Book");
    }
    }
    
    @FXML
    void btnSaveBorrowingOnAction(ActionEvent event) {
try{
    long borrowingId = Long.parseLong(txtBorrowingId.getText());
    long bookId = Long.parseLong(txtBookId.getText());
    int memberId = Integer.parseInt(txtMemberId.getText());
    LocalDate borrowingDate = LocalDate.parse(dpBorrowingDate.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
    LocalDate dueDate = LocalDate.parse(dpDueDate.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
    LocalDate returnDate = dpReturnDate.getText().isEmpty() ? null : LocalDate.parse(dpReturnDate.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
  


    BorrowingsDto borrowingsDto = new BorrowingsDto(borrowingId,bookId,memberId, borrowingDate, dueDate, returnDate);
    borrowingService.save(borrowingsDto);
loadBorrowings();
showAlert(Alert.AlertType.INFORMATION, "Success", "Borrowing Book saved successfully.");
    } catch (DateTimeParseException e){
        showAlert(Alert.AlertType.ERROR, "Error", "Invalid date format. Please use yyyy-mm-dd.");
    } catch (Exception e) {
        e.printStackTrace();
        showAlert(Alert.AlertType.ERROR, "Error", "Failed to save Borrowing Book.");

    }
}

    @FXML
    
    void btnSearchBorrowingOnAction(ActionEvent event) {
      
    }

    @FXML
    void btnUpdateBorrowingOnAction(ActionEvent event) throws Exception {
        try{
        long borrowingId = Long.parseLong(txtBorrowingId.getText());
        long bookId = Long.parseLong(txtBookId.getText());
        int memberId = Integer.parseInt(txtMemberId.getText());
        LocalDate borrowingDate = LocalDate.parse(dpBorrowingDate.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate dueDate = LocalDate.parse(dpDueDate.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate returnDate = dpReturnDate.getText().isEmpty() ? null : LocalDate.parse(dpReturnDate.getText(), DateTimeFormatter.ISO_LOCAL_DATE);

        BorrowingsDto borrowingsDto = new BorrowingsDto(borrowingId,bookId,memberId, borrowingDate, dueDate, returnDate);
         borrowingService.update(borrowingsDto);

         loadBorrowings();
         showAlert(Alert.AlertType.INFORMATION, "Success", "Borrowing Book updated successfully.");
    } catch (DateTimeParseException e){
        showAlert(Alert.AlertType.ERROR, "Error", "Invalid date format. Please use yyyy-MM-dd.");
    } catch (Exception e) {
        e.printStackTrace();
        showAlert(Alert.AlertType.ERROR, "Error", "Failed to update Borrowing Book.");

    }
    }
    @FXML
    void btnBackBorrowingOnAction(ActionEvent event) {
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

    
