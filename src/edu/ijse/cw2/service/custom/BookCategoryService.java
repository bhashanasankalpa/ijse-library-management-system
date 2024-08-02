package edu.ijse.cw2.service.custom;

import java.util.ArrayList;

import edu.ijse.cw2.dto.BookCategoryDto;
import edu.ijse.cw2.service.SuperService;

public interface BookCategoryService extends SuperService{
    String save(BookCategoryDto bookCategoryDto) throws Exception;
    String update(BookCategoryDto bookCategoryDto) throws Exception;
    String delete(String categoryId)throws Exception;
    BookCategoryDto get(String categoryId)throws Exception;
    ArrayList<BookCategoryDto> getAll()throws Exception;
}
