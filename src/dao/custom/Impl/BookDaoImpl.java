package dao.custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.BookDao;
import entity.BookEntity;

public class BookDaoImpl implements BookDao {
    

    @Override
    public String save(BookEntity entity) throws Exception{
        boolean isSaved= CrudUtil.executeUpdate("INSERT INTO books VALUES(?,?,?,?,?)",
        entity.getId(), entity.getTitle(), entity.getAuthor(), entity.getCategoryId(),entity.isAvailable());
        return isSaved ? "Success" : "Fail";
    }

    @Override
    public String update(BookEntity t) throws Exception {
      boolean isUpdated =  CrudUtil.executeUpdate("UPDATE books SET title=?,author=?,category_id=?,available=? WHERE book_id=?",
      t.getTitle(),t.getAuthor(),t.getCategoryId(),t.isAvailable());
      return isUpdated ? "Success" : "Fail";
    }

    @Override
    public String delete(Long id) throws Exception {
        boolean isDeleted = CrudUtil.executeUpdate("DELETE FROM books WHERE book_id =?", id);
        return isDeleted ? "Success" : "Fail";
    }

    @Override
    public BookEntity get(Long id) throws Exception {
        
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM books WHERE  book_id=?", id);
            if (rst.next()) {
                return new BookEntity(rst.getLong("book_id"), rst.getString("title"),
                        rst.getString("author"), rst.getLong("category_id"), rst.getBoolean("available"));
            }
            return null;
        }


    @Override
    public ArrayList<BookEntity> getAll() throws Exception {
        ArrayList<BookEntity> bookEntitys = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM books");
        while (rst.next()) {
            BookEntity entity = new BookEntity(rst.getLong("book_id"), rst.getString("title"),
            rst.getString("author"), rst.getLong("category_id"), rst.getBoolean("available"));
        }

        return bookEntitys;
        
    }
}




