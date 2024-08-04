package edu.ijse.cw2.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.ijse.cw2.dao.CrudUtil;
import edu.ijse.cw2.dao.custom.BookDao;
import edu.ijse.cw2.entity.BookEntity;

public class BookDaoImpl implements BookDao{

    @Override
    public boolean create(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO book Values(?,?,?,?,?,?)", t.getBookID(),t.getTitle(),t.getAuthor(),t.getiSBN(),t.getPublisher(),t.getCategoryID());
    }

    @Override
    public boolean update(BookEntity t) throws Exception {
       return CrudUtil.executeUpdate("UPDATE book SET Title=?,Author=?,ISBN=?,Publisher=?,CategoryID=? WHERE BookID = ? ", t.getTitle(),t.getAuthor(),t.getiSBN(),t.getPublisher(),t.getCategoryID(),t.getBookID());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM book WHERE BookID = ?", id);
    }

    @Override
    public BookEntity get(String id) throws Exception {
        ResultSet rst =CrudUtil.executeQuery("SELECT * FROM book WHERE BookID = ?", id);
        if (rst.next()) {
            BookEntity bookEntity = new BookEntity(rst.getString("BookID"), rst.getString("Title"), rst.getString("Author"), rst.getString("ISBN"), rst.getString("Publisher"), rst.getString("CategoryID"));
            return bookEntity;
        }
        return null;
    }

    @Override
    public ArrayList<BookEntity> getAll() throws Exception {
        ArrayList<BookEntity> bookEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM book");
        while (rst.next()) {
            BookEntity bookEntity = new BookEntity(rst.getString("BookID"), rst.getString("Title"), rst.getString("Author"), rst.getString("ISBN"), rst.getString("Publisher"), rst.getString("CategoryID"));
            bookEntities.add(bookEntity);
        }
        return bookEntities;
    }   
    
}
