package edu.ijse.cw2.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import edu.ijse.cw2.dto.BookCategoryDto;
import edu.ijse.cw2.service.ServiceFactory;
import edu.ijse.cw2.service.custom.BookCategoryService;
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

public class BookCategoryController {

    private BookCategoryService bookCategoryService = (BookCategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOKCATEGORY);
    private BookCategoryDto bookCategoryDto;
    
    @FXML
    private TableColumn<BookCategoryDto, String> colId;

    @FXML
    private TableColumn<BookCategoryDto, String> colName;

    @FXML
    private TableView<BookCategoryDto> tblBookCategory;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtCategoryId;

    @FXML
    private TextField txtCategoryName;

    @FXML
    void getItems(MouseEvent event) {
         int  index =tblBookCategory.getSelectionModel().getSelectedIndex();
         BookCategoryDto b1 = new BookCategoryDto(colId.getCellData(index), colName.getCellData(index));
         if(b1!=null){
             txtCategoryId.setText(b1.getCategoryId());
             txtCategoryName.setText(b1.getCategoryName());
    }
}

    public void initialize() throws Exception{
        colId.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        loadTable();
    }

    @FXML
    void btnDeleteBookCategoryOnAction(ActionEvent event) {
        try {
            String categoryId=txtCategoryId.getText();
            String resp= delete(categoryId);
            new Alert(Alert.AlertType.CONFIRMATION, resp).show();
            clearForm();
            loadTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error While deleting Book Category").show();
        }
    }

    @FXML
    void btnSaveBookCategoryOnAction(ActionEvent event) {
        try {
            bookCategoryDto = new BookCategoryDto(txtCategoryId.getText(), txtCategoryName.getText());
            String resp= save(bookCategoryDto);
            new Alert(Alert.AlertType.CONFIRMATION, resp).show();
            clearForm();
            loadTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error While Saving Book Category").show();
        }

    }

    @FXML
    void btnUpdateBookCategoryOnAction(ActionEvent event) {
        try {
            BookCategoryDto bookCategoryDto = new BookCategoryDto(txtCategoryId.getText(), txtCategoryName.getText());
            String resp =update(bookCategoryDto);
            new Alert(Alert.AlertType.CONFIRMATION, resp).show();
            clearForm();
            loadTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error While updating Book Category").show();
        }
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        URL resource = this.getClass().getResource("/edu/ijse/cw2/view/AppHome.fxml");
        Parent node = FXMLLoader.load(resource);
        this.root.getChildren().add(node);
    }

    public String save(BookCategoryDto bookCategoryDto) throws Exception {
        return bookCategoryService.save(bookCategoryDto);
    }

    public String update(BookCategoryDto bookCategoryDto) throws Exception {
        return bookCategoryService.update(bookCategoryDto);
    }

    public String delete(String categoryId) throws Exception {
        return bookCategoryService.delete(categoryId);
    }

    public ArrayList<BookCategoryDto> getAll() throws Exception {
        return bookCategoryService.getAll();
    }

    public BookCategoryDto get(String categoryId) throws Exception {
        return bookCategoryService.get(categoryId);
    }

    private void clearForm() {
        txtCategoryId.setText("");
        txtCategoryName.setText("");
    }

    private void loadTable() throws Exception{
        ObservableList<BookCategoryDto> bookCategoryList = FXCollections.observableArrayList();
        ArrayList<BookCategoryDto> CategoryList = getAll();
        for (BookCategoryDto bookCategoryDto : CategoryList) {
            new BookCategoryDto(bookCategoryDto.getCategoryId(), bookCategoryDto.getCategoryName());
            bookCategoryList.add(bookCategoryDto);
        }
        tblBookCategory.setItems(bookCategoryList);
    }
    
   
}
