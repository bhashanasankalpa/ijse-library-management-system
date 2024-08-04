package edu.ijse.cw2.service.custom;

import java.util.ArrayList;

import edu.ijse.cw2.dto.BookDto;
import edu.ijse.cw2.service.SuperService;

public interface BookService extends SuperService{
    String save(BookDto bookDto)throws Exception;
    String update(BookDto bookDto)throws Exception;
    String delete(String bookId)throws Exception;
    BookDto get(String bookId)throws Exception;
    ArrayList<BookDto>getAll()throws Exception;
}
