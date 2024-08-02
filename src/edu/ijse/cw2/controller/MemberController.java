package edu.ijse.cw2.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import edu.ijse.cw2.dto.MemberDto;
import edu.ijse.cw2.service.ServiceFactory;
import edu.ijse.cw2.service.custom.MemberService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MemberController {
    private MemberService memberService=(MemberService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);

     @FXML
    private TableColumn<MemberDto, String> colAddress;

    @FXML
    private TableColumn<MemberDto, String> colEmail;

    @FXML
    private TableColumn<MemberDto, String> colId;

    @FXML
    private TableColumn<MemberDto, String> colName;

    @FXML
    private TableColumn<MemberDto, String> colPhone;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<MemberDto> tblMembers;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtMemberName;

    @FXML
    private TextField txtPhone;

    public void initialize() throws Exception{
        colId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("memberEmail"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("memberPhone"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("memberAddress"));
        loadTable();
    }

    @FXML
    void btnDeleteMembersOnAction(ActionEvent event) {
        try {
            String resp = delete(txtMemberId.getText());
            new Alert(Alert.AlertType.INFORMATION,resp).show();
            clearForm();
            loadTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error While delete  member").show();
        }
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        URL resource = this.getClass().getResource("/edu/ijse/cw2/view/AppHome.fxml");
        Parent node = FXMLLoader.load(resource);
        this.root.getChildren().add(node);
    }

    @FXML
    void btnSaveMembersOnAction(ActionEvent event) {
        try {
            MemberDto dto = new MemberDto(txtMemberId.getText(), txtMemberName.getText(), txtEmail.getText(), txtPhone.getText(), txtAddress.getText());
            String resp = save(dto);
            new Alert(Alert.AlertType.INFORMATION,resp).show();
            clearForm();
            loadTable();
        } catch (Exception e) {
           new Alert(Alert.AlertType.ERROR, "Error While Saving  member").show();
        }
    }

    @FXML
    void btnUpdateMembersOnAction(ActionEvent event) {
        try {
            MemberDto dto = new MemberDto(txtMemberId.getText(), txtMemberName.getText(), txtEmail.getText(), txtPhone.getText(), txtAddress.getText());
            String resp = update(dto);
            new Alert(Alert.AlertType.INFORMATION,resp).show();
            clearForm();
            loadTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error While update  member").show();
        }
    }

    @FXML
    void getItem(MouseEvent event) {
       int index = tblMembers.getSelectionModel().getSelectedIndex();
       MemberDto dto =new MemberDto(colId.getCellData(index), colName.getCellData(index), colEmail.getCellData(index), colPhone.getCellData(index), colAddress.getCellData(index));
       if (dto !=null) {
        txtMemberId.setText(dto.getMemberId());
        txtMemberName.setText(dto.getMemberName());
        txtEmail.setText(dto.getMemberEmail());
        txtPhone.setText(dto.getMemberPhone());
        txtAddress.setText(dto.getMemberAddress());
       }
    }

    public String save(MemberDto memberDto)throws Exception{
        return memberService.save(memberDto);
    }
    public String update(MemberDto memberDto)throws Exception{
        return memberService.update(memberDto);
    }
    public String delete(String memberId)throws Exception{
        return memberService.delete(memberId);
    }
    public ArrayList<MemberDto> getAll()throws Exception{
        return memberService.getAll();
    }
    public MemberDto get(String memberId)throws Exception{
        return memberService.get(memberId);  
    }

    private void clearForm(){
        txtMemberId.setText("");
        txtMemberName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
    }

    private void loadTable() throws Exception{
        ObservableList<MemberDto> observableList = FXCollections.observableArrayList();
        ArrayList<MemberDto> memberList =getAll();
        for (MemberDto memberDto : memberList) {
            new MemberDto(memberDto.getMemberId(), memberDto.getMemberName(), memberDto.getMemberEmail(), memberDto.getMemberPhone(), memberDto.getMemberAddress());
            observableList.add(memberDto);
        }
        tblMembers.setItems(observableList);
    }
}
