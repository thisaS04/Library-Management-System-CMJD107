package service;


import service.custom.Impl.BookCategoryServiceImpl;
import service.custom.Impl.BookServiceImpl;
import service.custom.Impl.MemberServiceImpl;

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
            case BOOK_CATEGORY:
                return new BookCategoryServiceImpl();
            case MEMBER:
                return new MemberServiceImpl();

                default:
                return null;
        }
    }

public enum ServiceType{
        BOOK,BOOK_CATEGORY,MEMBER
    }


}
