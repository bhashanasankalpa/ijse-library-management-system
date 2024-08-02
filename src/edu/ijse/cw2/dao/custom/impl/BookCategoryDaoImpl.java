package edu.ijse.cw2.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.ijse.cw2.dao.CrudUtil;
import edu.ijse.cw2.dao.custom.BookCategoryDao;
import edu.ijse.cw2.entity.BookCategoryEntity;

public class BookCategoryDaoImpl implements BookCategoryDao{

    @Override
    public boolean create(BookCategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO BookCategory Values(?,?)", t.getCategoryId(),t.getCategoryName());
    }

    @Override
    public boolean update(BookCategoryEntity t) throws Exception {
       return CrudUtil.executeUpdate("UPDATE BookCategory SET CategoryName=? WHERE CategoryID = ? ", t.getCategoryName(),t.getCategoryId());
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("DELETE FROM BookCategory WHERE CategoryID = ?", id);
    }

    @Override
    public BookCategoryEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM BookCategory WHERE CategoryID = ?", id);
        if (rst.next()) {
            BookCategoryEntity bookCategoryEntity = new BookCategoryEntity(rst.getString("CategoryID"), rst.getString("CategoryName"));
            return bookCategoryEntity;
        }
        return null;
    }

    @Override
    public ArrayList<BookCategoryEntity> getAll() throws Exception {
        ArrayList<BookCategoryEntity> bookCategoryEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM BookCategory");

        while (rst.next()) {
            BookCategoryEntity bookCategoryEntity = new BookCategoryEntity(rst.getString("CategoryID"), rst.getString("CategoryName"));
            bookCategoryEntities.add(bookCategoryEntity);
        }
        return bookCategoryEntities;
    }
    
}
