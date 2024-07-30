package dao;

import java.sql.Connection;

import dao.custom.Impl.BookCategoryDaoImpl;
import dao.custom.Impl.BookDaoImpl;
import dao.custom.Impl.BorrowingsDaoImpl;
import dao.custom.Impl.MemberDaoImpl;
import dao.custom.Impl.UserDaoImpl;
import db.DBConnection;


public class DaoFactory {
    private static DaoFactory daoFactory;
    private Connection connection;

     private DaoFactory() {
        this.connection = DBConnection.getInstance().getConnection();

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
            return new BookDaoImpl(connection);
            case BOOKCATEGORY:
            return new BookCategoryDaoImpl(connection);
            case MEMBER:
            return new MemberDaoImpl(connection);
            case BORROWINGS:
            return new BorrowingsDaoImpl(connection);
            case USER:
            return new UserDaoImpl(connection);

            default:
            return null;
}
    }
    public enum DaoTypes {
        BOOK,BOOKCATEGORY,MEMBER,BORROWINGS,USER
    }

}
