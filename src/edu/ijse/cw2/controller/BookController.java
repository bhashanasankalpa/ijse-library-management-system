package edu.ijse.cw2.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import edu.ijse.cw2.dto.BookCategoryDto;
import edu.ijse.cw2.dto.BookDto;
import edu.ijse.cw2.service.ServiceFactory;
import edu.ijse.cw2.service.custom.BookCategoryService;
import edu.ijse.cw2.service.custom.BookService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class BookController {

  private BookCategoryService categoryService = (BookCategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOKCATEGORY);

    private BookService bookService = (BookService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);

    @FXML
    private TableColumn<BookDto, String> colAuthor;

    @FXML
    private TableColumn<BookDto, String> colCategoryId;

    @FXML
    private TableColumn<BookDto, String> ColISBN;

    @FXML
    private TableColumn<BookDto, String> colPublisher;

    @FXML
    private TableColumn<BookDto, String> colTitle;

    @FXML
    private TableColumn<BookDto, String> colbookId;

    @FXML
    private Label lblChekCategoryDetail;

    @FXML
    private TableView<BookDto> tblBook;

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

    public void initialize() throws Exception{
        colbookId.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colPublisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        colCategoryId.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
        ColISBN.setCellValueFactory(new PropertyValueFactory<>("bookISBn"));
        loadTable();
    } 

    @FXML
    void btnChekCidOnAction(ActionEvent event) throws Exception {
       try {
        String categoryid=txtCategoryId.getText();
        BookCategoryDto dto = categoryService.get(categoryid);
        if (dto!=null) {
            lblChekCategoryDetail.setText(dto.getCategoryId()+" | "+dto.getCategoryName());
        }else{
            lblChekCategoryDetail.setText("Book Category Not Found");
        }
       } catch (Exception e) {
        new Alert(Alert.AlertType.ERROR, "Error While searching Book Category").show();
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
    void btnSaveBookOnAction(ActionEvent event) {
        try {
            BookDto bookDto = new BookDto(txtBookId.getText(), txtTitle.getText(), txtAuthor.getText(), txtISBN.getText(), txtPublisher.getText(), txtCategoryId.getText());
            String resp = save(bookDto);
            new Alert(Alert.AlertType.INFORMATION,resp).show();
            loadTable();
            clearForm();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error While saving Book ").show();
        }
        
    }
    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try {
            String bookId = txtBookId.getText();
            String resp = delete(bookId);
            new Alert(Alert.AlertType.INFORMATION,resp).show();
            loadTable();
            clearForm();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error While deleting Book ").show();
        }
    }
    
    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            BookDto bookDto = new BookDto(txtBookId.getText(), txtTitle.getText(), txtAuthor.getText(), txtISBN.getText(), txtPublisher.getText(), txtCategoryId.getText());
            String resp = update(bookDto);
            new Alert(Alert.AlertType.INFORMATION,resp).show();
            loadTable();
            clearForm();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error While saving Book ").show();
        }
    }
    @FXML
    void getItems(MouseEvent event) {
        System.out.println("button clicked");
        int index = tblBook.getSelectionModel().getSelectedIndex();
        BookDto dto =new BookDto(colbookId.getCellData(index), colTitle.getCellData(index), colAuthor.getCellData(index), ColISBN.getCellData(index), colPublisher.getCellData(index), colCategoryId.getCellData(index));
        if (dto!=null) {
            txtBookId.setText(dto.getBookID());
            txtTitle.setText(dto.getTitle());
            txtAuthor.setText(dto.getAuthor());
            txtISBN.setText(dto.getBookISBn());
            txtPublisher.setText(dto.getPublisher());
            txtCategoryId.setText(dto.getCategoryID());
        }

    }

    public String save(BookDto bookDto)throws Exception{
        return bookService.save(bookDto);
    }
    public String update(BookDto bookDto)throws Exception{
        return bookService.update(bookDto);
    }
    public String delete(String bookId)throws Exception{
        return bookService.delete(bookId);
    }
    public BookDto get(String bookId)throws Exception{
        return bookService.get(bookId);
    }
    public ArrayList<BookDto> getAll()throws Exception{
        return bookService.getAll();
    }

    private void clearForm(){
        txtBookId.setText("");
        txtTitle.setText("");
        txtAuthor.setText("");
        txtISBN.setText("");
        txtPublisher.setText("");
        txtCategoryId.setText("");
    }
    private void loadTable() throws Exception{
        ObservableList<BookDto> observableList = FXCollections.observableArrayList();
        ArrayList<BookDto> arrayList = getAll();
        for (BookDto bookDto : arrayList) {
            new BookDto(bookDto.getBookID(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getBookISBn(), bookDto.getPublisher(), bookDto.getCategoryID());
            observableList.add(bookDto);
        }
        tblBook.setItems(observableList);
    }
}
