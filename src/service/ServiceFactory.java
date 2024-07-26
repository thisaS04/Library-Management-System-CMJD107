package service;

import service.custom.Impl.BookServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    private ServiceFactory() {
    }
    public static ServiceFactory getInstance(){
        if(serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceType type){
        switch (type) {
            case BOOK:
                return new BookServiceImpl();

                default:
                return null;
        }
    }

public enum ServiceType{
        BOOK
    }


}
