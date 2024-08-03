package edu.ijse.cw2.controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class BookController {
    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colCategoryId;

    @FXML
    private TableColumn<?, ?> colIsbn;

    @FXML
    private TableColumn<?, ?> colPublisher;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableColumn<?, ?> colbookId;

    @FXML
    private Label lblChekCategoryDetail;

    @FXML
    private TableView<?> tblBook;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtCategoryId;

    @FXML
    private TextField txtISBN;

    @FXML
    private TextField txtPublisher;

    @FXML
    private TextField txtTitle;

    @FXML
    private AnchorPane root;

    @FXML
    void btnChekCidOnAction(ActionEvent event) {
        System.out.println("hekCid button clicked");
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        URL resource = this.getClass().getResource("/edu/ijse/cw2/view/AppHome.fxml");
        Parent node = FXMLLoader.load(resource);
        this.root.getChildren().add(node);
    }
    @FXML
    void btnSaveBookOnAction(ActionEvent event) {
        System.out.println(" save book button clicked");
        
    }
    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        
        System.out.println(" delete button clicked");
    }
    
    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        System.out.println(" update button clicked");

    }
    @FXML
    void getItems(MouseEvent event) {
        System.out.println("button clicked");
    }
}
