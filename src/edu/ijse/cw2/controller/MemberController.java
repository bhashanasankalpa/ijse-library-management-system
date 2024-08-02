package edu.ijse.cw2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MemberController {
     @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblMembers;

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

    @FXML
    void btnDeleteMembersOnAction(ActionEvent event) {
        System.out.println("DeleteMembers Button clicked");
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        System.out.println("Home Button clicked");
    }

    @FXML
    void btnSaveMembersOnAction(ActionEvent event) {
        System.out.println("SaveMember Button clicked");
    }

    @FXML
    void btnUpdateMembersOnAction(ActionEvent event) {
        System.out.println("UpdateMember Button clicked");
    }

    @FXML
    void getItem(MouseEvent event) {
        System.out.println("getItem Button clicked");
    }
}
