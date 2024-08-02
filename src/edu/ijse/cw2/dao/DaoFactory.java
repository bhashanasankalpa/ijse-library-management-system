package edu.ijse.cw2.dao;

import edu.ijse.cw2.dao.custom.impl.BookCategoryDaoImpl;

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
        
            default:
            return null;
        }
    }

    public enum DaoTypes{
        BOOKCATEGORY
    }
}
