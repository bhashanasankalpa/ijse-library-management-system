package edu.ijse.cw2.service;

import edu.ijse.cw2.service.custom.impl.BookCategoryServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceType serviceType) {
        switch (serviceType) {
            case BOOKCATEGORY:
                return new BookCategoryServiceImpl();

            default:
                return null;
        }
    }

    public enum ServiceType {
        BOOKCATEGORY
    }
}
