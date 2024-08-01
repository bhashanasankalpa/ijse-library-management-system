package edu.ijse.cw2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class AppHomeController {
     @FXML
    private AnchorPane root;
   
  @FXML
    void btnBookBorrowingOnAction(ActionEvent event) {
        System.out.println("BookBorrowing button clikked");
    }

    @FXML
    void btnBookCategoryOnAction(ActionEvent event) {
        System.out.println("BookCategory button clikked");
    }

    @FXML
    void btnBookOnAction(ActionEvent event) {
        System.out.println("Book button clikked");
    }

    @FXML
    void btnBookReturnOnAction(ActionEvent event) {
        System.out.println("BookReturn button clikked");
    }

    @FXML
    void btnMembersOnAction(ActionEvent event) {
        System.out.println("Members button clikked");
    }
    
}
