package edu.ijse.cw2.controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class LoginController {

    @FXML
    private AnchorPane root;

     @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        System.out.println("Login Button Clicked");
        //new stage load
        
        this.root.getChildren().clear();
        URL resource = this.getClass().getResource("/edu/ijse/cw2/view/AppHome.fxml");
        Parent node = FXMLLoader.load(resource);
        this.root.getChildren().add(node);
    }
}
