package dao;

import dao.custom.Impl.BookDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){

    }
    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }
    
    public SuperDAO getDao(DaoTypes type) {
        switch (type) {
            case BOOK:
            return new BookDaoImpl();
            default:
            return null;
}
    }
    public enum DaoTypes {
        BOOK
    }

}
