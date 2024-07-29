package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BorrowingsController {
     
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
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colBorrowingDate;

    @FXML
    private TableColumn<?, ?> colBorrowingId;

    @FXML
    private TableColumn<?, ?> colDueDate;

    @FXML
    private TableColumn<?, ?> colMemberId;

    @FXML
    private TableColumn<?, ?> colReturnDate;

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
    private TableView<?> tableBorrowings;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBorrowingId;

    @FXML
    private TextField txtMemberId;

    @FXML
    void btnClearBorrowingOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteBorrowingOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveBorrowingOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchBorrowingOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateBorrowingOnAction(ActionEvent event) {

    }
}
