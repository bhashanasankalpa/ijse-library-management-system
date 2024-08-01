package edu.ijse.cw2.controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class BookCategoryController {
    @FXML
    private AnchorPane root;

    @FXML
    void btnDeleteBookCategoryOnAction(ActionEvent event) {
        System.out.println("DeleteBookCategory button Clicked");
    }

    @FXML
    void btnSaveBookCategoryOnAction(ActionEvent event) {
        System.out.println("SaveBookCategory button Clicked");
    }

    @FXML
    void btnUpdateBookCategoryOnAction(ActionEvent event) {
        System.out.println("UpdateBookCategory button Clicked");
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        URL resource = this.getClass().getResource("/edu/ijse/cw2/view/AppHome.fxml");
        Parent node = FXMLLoader.load(resource);
        this.root.getChildren().add(node);
    }

}
