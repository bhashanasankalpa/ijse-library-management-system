package edu.ijse.cw2.service.custom.impl;

import java.util.ArrayList;

import edu.ijse.cw2.dao.DaoFactory;
import edu.ijse.cw2.dao.custom.BookDao;
import edu.ijse.cw2.dto.BookDto;
import edu.ijse.cw2.entity.BookEntity;
import edu.ijse.cw2.service.custom.BookService;

public class BookServiceImpl implements BookService{

    private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);

    @Override
    public String save(BookDto bookDto) throws Exception {
        BookEntity bookEntity = getBookEntity(bookDto);
        return bookDao.create(bookEntity)?"Success":"Fail";
    }

    @Override
    public String update(BookDto bookDto) throws Exception {
        BookEntity bookEntity = getBookEntity(bookDto);
        return bookDao.update(bookEntity)?"Success":"Fail";
    }

    @Override
    public String delete(String bookId) throws Exception {
        return bookDao.delete(bookId)?"Success":"Fail";
    }

    @Override
    public BookDto get(String bookId) throws Exception {
       BookEntity bookEntity = bookDao.get(bookId);
       if (bookEntity!= null) {
        return getBookDto(bookEntity);
       }
       return null;
    }

    @Override
    public ArrayList<BookDto> getAll() throws Exception {
        ArrayList<BookEntity> bookEntities = bookDao.getAll();
        if (bookEntities!=null && !bookEntities.isEmpty()) {
            ArrayList <BookDto> bookDtos = new ArrayList<>();
            for (BookEntity bookEntity : bookEntities) {
                bookDtos.add(getBookDto(bookEntity));
            }
            return bookDtos;
        }
        return null;
    }

    private BookEntity getBookEntity(BookDto bookDto){
        return new BookEntity(bookDto.getBookID(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getBookISBn(), bookDto.getPublisher(), bookDto.getCategoryID());
    } 

    private BookDto getBookDto(BookEntity bookEntity){
        return new BookDto(bookEntity.getBookID(), bookEntity.getTitle(), bookEntity.getAuthor(), bookEntity.getiSBN(), bookEntity.getPublisher(), bookEntity.getCategoryID());
    }

    
}