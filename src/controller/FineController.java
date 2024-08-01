package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import dto.FineDto;
import entity.Fine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.FineService;

public class FineController {
    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<Fine, Long> colBorrowingId;

    @FXML
    private TableColumn<Fine, BigDecimal> colFineAmount;

    @FXML
    private TableColumn<Fine, Date> colFineDate;

    @FXML
    private TableColumn<Fine, Integer> colFineId;

    @FXML
    private TableColumn<Fine, Boolean> colIsPaid;

    @FXML
    private Label lblFineAmount;

    @FXML
    private Label lblFineDate;

    @FXML
    private Label lblFineId;

    @FXML
    private Label lblIsPaid;

    @FXML
    private Label lblborrowingId;

    @FXML
    private TableView<FineDto> tblFines;

    @FXML
    private TextField txtBorrowingId;

    @FXML
    private TextField txtFineAmount;

    @FXML
    private TextField txtFineDate;

    @FXML
    private TextField txtFineId;

    @FXML
    private TextField txtIsPaid;

    private FineService fineService;
    public void initialize() {
        fineService = (FineService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.FINE);
        
        colFineId.setCellValueFactory(new PropertyValueFactory<>("fineId"));
        colBorrowingId.setCellValueFactory(new PropertyValueFactory<>("borrowingId"));
        colFineAmount.setCellValueFactory(new PropertyValueFactory<>("fine_amount"));
        colFineDate.setCellValueFactory(new PropertyValueFactory<>("fine_date"));
        colIsPaid.setCellValueFactory(new PropertyValueFactory<>("is_paid"));
        
        loadAllFines();
    }

    private void loadAllFines() {
        try{
            List<FineDto> fineList = fineService.getAllFines();
            ObservableList<FineDto> fines = FXCollections.observableArrayList(fineList);
            tblFines.setItems(fines);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    @FXML
    void btnFineBackOnAction(ActionEvent event) {
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
    

    @FXML
    void btnFineDeleteOnAction(ActionEvent event) {
try{
    int fineId = Integer.parseInt(txtFineId.getText());
    fineService.deleteFine(fineId);
    loadAllFines();
    clearFields();

} catch (Exception e){
    e.printStackTrace();
}

}

    @FXML
    void btnSaveFineOnAction(ActionEvent event) {
try{
    FineDto fine = new FineDto(Integer.parseInt(txtFineId.getText()),Long.parseLong(txtBorrowingId.getText()),new BigDecimal(txtFineAmount.getText()),Date.valueOf(txtFineDate.getText()),Boolean.parseBoolean(txtIsPaid.getText()));
    fineService.saveFine(fine);
    loadAllFines();
    clearFields();
} catch (Exception e){
    e.printStackTrace();
}
    }

    @FXML
    void btnUpdateFineOnAction(ActionEvent event) {
try{
    FineDto fine = new FineDto(Integer.parseInt(txtFineId.getText()),Long.parseLong(txtBorrowingId.getText()),new BigDecimal(txtFineAmount.getText()),Date.valueOf(txtFineDate.getText()),Boolean.parseBoolean(txtIsPaid.getText()));
    fineService.updateFine(fine);
    loadAllFines();
    clearFields();
} catch (Exception e){
    e.printStackTrace();
}
}
    
    
    private void clearFields() {
        txtFineId.clear();
        txtBorrowingId.clear();
        txtFineAmount.clear();
        txtFineDate.clear();
        txtIsPaid.clear();
    }
}
