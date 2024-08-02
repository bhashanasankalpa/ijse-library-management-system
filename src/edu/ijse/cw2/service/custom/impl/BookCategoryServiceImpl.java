package edu.ijse.cw2.service.custom.impl;

import java.util.ArrayList;

import edu.ijse.cw2.dao.DaoFactory;
import edu.ijse.cw2.dao.custom.BookCategoryDao;
import edu.ijse.cw2.dto.BookCategoryDto;
import edu.ijse.cw2.entity.BookCategoryEntity;
import edu.ijse.cw2.service.custom.BookCategoryService;

public class BookCategoryServiceImpl implements BookCategoryService{

    private BookCategoryDao bookCategoryDao = (BookCategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOKCATEGORY);

    @Override
    public String save(BookCategoryDto bookCategoryDto) throws Exception {
    BookCategoryEntity bookCategoryEntity = getBookCategoryEntity(bookCategoryDto);
      return bookCategoryDao.create(bookCategoryEntity)?"Success":"Fail";
    }

    @Override
    public String update(BookCategoryDto bookCategoryDto) throws Exception {
        BookCategoryEntity bookCategoryEntity = getBookCategoryEntity(bookCategoryDto);
        return bookCategoryDao.update(bookCategoryEntity)?"Success":"Fail";
    }

    @Override
    public String delete(String categoryId) throws Exception {
        return bookCategoryDao.delete(categoryId)?"Success":"Fail";
    }

    @Override
    public BookCategoryDto get(String categoryId) throws Exception {
        BookCategoryEntity bookCategoryEntity =bookCategoryDao.get(categoryId);
        if (bookCategoryEntity != null) {
            return getBookCategoryDto(bookCategoryEntity);
            
        }
        return null;
    }

    @Override
    public ArrayList<BookCategoryDto> getAll() throws Exception {
       ArrayList<BookCategoryEntity> bookCategoryEntities = bookCategoryDao.getAll();
       if (bookCategoryEntities != null && !bookCategoryEntities.isEmpty()) {
        ArrayList<BookCategoryDto> bookCategoryDtos = new ArrayList<>();

        for (BookCategoryEntity bookCategoryEntity : bookCategoryEntities) {
            bookCategoryDtos.add(getBookCategoryDto(bookCategoryEntity));
        }
        return bookCategoryDtos;
       }
       return null;
    }


    private BookCategoryEntity getBookCategoryEntity(BookCategoryDto bookCategoryDto){
        return new BookCategoryEntity(bookCategoryDto.getCategoryId(), bookCategoryDto.getCategoryName());
    }
    private BookCategoryDto getBookCategoryDto(BookCategoryEntity bookCategoryEntity){
        return new BookCategoryDto(bookCategoryEntity.getCategoryId(), bookCategoryEntity.getCategoryName());
    }
}
