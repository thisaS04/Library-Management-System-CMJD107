package controller;

import java.util.ArrayList;

import dto.BookCategoryDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.custom.BookCategoryService;
import service.custom.Impl.BookCategoryServiceImpl;

public class BookCategorycontroller {
    @FXML
    private Button btnDeleteCategory;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<BookCategoryDto, Long> colCategoryId;

    @FXML
    private TableColumn<BookCategoryDto, String> colCategoryName;

    @FXML
    private Label lblCategoryId;

    @FXML
    private Label lblCategoryName;

    @FXML
    private TableView<BookCategoryDto> tblCategory;

    @FXML
    private TextField txtCategoryId;

    @FXML
    private TextField txtCategoryName;

    private BookCategoryService bookCategoryService = new BookCategoryServiceImpl();


    @FXML
    public void initialize(){
        colCategoryId.setCellValueFactory(new PropertyValueFactory<>("category_id"));
        colCategoryName.setCellValueFactory(new PropertyValueFactory<>("category_name"));

        loadTableData();
    }

    private void loadTableData() {
          try {
            ArrayList<BookCategoryDto> categories = bookCategoryService.getAll();
            ObservableList<BookCategoryDto> categoryList = FXCollections.observableArrayList(categories);
            tblCategory.setItems(categoryList);
        } catch (Exception e) {
            showAlert("Failed to load categories: " + e.getMessage());
        }
      
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
    try{
        Long id = Long.parseLong(txtCategoryId.getText());
        String result = bookCategoryService.delete(id);
        showAlert(result.equals("Success")? "Category deleted!" : "Failed to delete");
        clearFields();
        loadTableData();
    } catch (Exception e){
        showAlert("Failed to delete category: "+e.getMessage());
    }
    }

    private void clearFields() {
        txtCategoryId.clear();
        txtCategoryName.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
    try{
        String categoryName = txtCategoryName.getText();
        BookCategoryDto category = new BookCategoryDto(null, categoryName);
        String result = bookCategoryService.save(category);
        showAlert(result.equals("Success")? "Category Saved!" : "Failed to Save category");
        clearFields();
        loadTableData();
    } catch (Exception e){
        showAlert("Failed to Save category: "+e.getMessage());
    }
    }
    

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
     try{
        Long id = Long.parseLong(txtCategoryId.getText());
        String categoryName = txtCategoryName.getText();
        BookCategoryDto category = new BookCategoryDto(id, categoryName);
        String result = bookCategoryService.update(category);
        showAlert(result.equals("Success")? "Category Updated!" : "Failed to Update category");
        clearFields();
        loadTableData();
    } catch (Exception e){
        showAlert("Failed to Save category: "+e.getMessage());
    }
     }

    }



