package edu.ijse.cw2.dao;

import edu.ijse.cw2.dao.custom.impl.BookCategoryDaoImpl;
import edu.ijse.cw2.dao.custom.impl.BookDaoImpl;
import edu.ijse.cw2.dao.custom.impl.MemberDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getInstance(){
        if (daoFactory==null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }
    public SuperDao getDao(DaoTypes daoTypes){
        switch (daoTypes) {
            case BOOKCATEGORY:
            return new BookCategoryDaoImpl();

            case MEMBER:
            return new MemberDaoImpl();

            case BOOK:
            return new BookDaoImpl();
        
            default:
            return null;
        }
    }

    public enum DaoTypes{
        BOOKCATEGORY,MEMBER,BOOK
    }
}
