package edu.ijse.cw2.controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class AppHomeController {
     @FXML
    private AnchorPane root;
   
  @FXML
    void btnBookBorrowingOnAction(ActionEvent event) {
        System.out.println("BookBorrowing button clikked");
    }

    @FXML
    void btnBookCategoryOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        URL resource = this.getClass().getResource("/edu/ijse/cw2/view/BookCategory.fxml");
        Parent node = FXMLLoader.load(resource);
        this.root.getChildren().add(node);
    }

    @FXML
    void btnBookOnAction(ActionEvent event) throws IOException {
        System.out.println("Book button clikked");
        this.root.getChildren().clear();
        URL resource = this.getClass().getResource("/edu/ijse/cw2/view/Book.fxml");
        Parent node = FXMLLoader.load(resource);
        this.root.getChildren().add(node);
    }

    @FXML
    void btnBookReturnOnAction(ActionEvent event) {
        System.out.println("BookReturn button clikked");
    }

    @FXML
    void btnMembersOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        URL resource = this.getClass().getResource("/edu/ijse/cw2/view/Member.fxml");
        Parent node = FXMLLoader.load(resource);
        this.root.getChildren().add(node);
    }
    
}
