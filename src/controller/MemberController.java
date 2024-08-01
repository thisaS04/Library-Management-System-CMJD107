package controller;

import java.io.IOException;
import java.util.ArrayList;

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
import service.custom.MemberService;

public class MemberController {

    @FXML
    private Button btnBack;
    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private TableColumn<MemberDto, Long> colMemberId;

    @FXML
    private TableColumn<MemberDto, String> colMemberName;

    @FXML
    private TableColumn<MemberDto, String> colPhone;

    @FXML
    private Label lblHeading;

    @FXML
    private Label lblMemberId;

    @FXML
    private Label lblMemberName;

    @FXML
    private Label lblPhone;

    @FXML
    private TableView<MemberDto> tblMembers;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtMemberName;

    @FXML
    private TextField txtPhone;


    private MemberService memberService;
    public MemberController(){
        this.memberService = (MemberService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);
    }

    @FXML
    public void initialize(){
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMemberName.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        loadMembers();
    }

    private void loadMembers() {
         try {
            ArrayList<MemberDto> members = memberService.getAll();
            ObservableList<MemberDto> memberList = FXCollections.observableArrayList(members);
            tblMembers.setItems(memberList);
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Failed to load members");
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
    void btnClearMemberOnAction(ActionEvent event) {
    clearFields();
    }

    @FXML
    void btnDeleteMemberOnAction(ActionEvent event) {
        try{
            Long id =Long.parseLong(txtMemberId.getText());
            String result = memberService.delete(id);
            showAlert(AlertType.INFORMATION, "Success", "Member deleted successfully: " + result);
        clearFields();
        loadMembers();
    } catch (Exception e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Error", "Failed to delete Member");
    }
    }
    @FXML
    void btnSaveMemberOnAction(ActionEvent event) {
    try{
        Long id =Long.parseLong(txtMemberId.getText());
        String memberName = txtMemberName.getText();
        String phone = txtPhone.getText();


        MemberDto memberDto = new MemberDto (id, memberName, phone);
        String result = memberService.save(memberDto);
        showAlert(AlertType.INFORMATION, "Success", "Member saved successfully: " + result);
        clearFields();
        loadMembers();

    } catch (Exception e){
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Error", "Failed to save member");
    }
    }

    private void clearFields() {
        txtMemberId.clear();
        txtMemberName.clear();
        txtPhone.clear();
    }

    @FXML
    void btnUpdateMemberOnAction(ActionEvent event) {
        try {
            Long id =Long.parseLong(txtMemberId.getText());
            String memberName = txtMemberName.getText();
            String phone = txtPhone.getText();
    
    
            MemberDto memberDto = new MemberDto (id, memberName, phone);
            String result = memberService.update(memberDto);
            showAlert(AlertType.INFORMATION, "Success", "Member Updated successfully: " + result);
            clearFields();
            loadMembers();
        } catch (Exception e){
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Failed to update member");
        }

    }
    @FXML
    void btnBackMemberOnAction(ActionEvent event) {
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
