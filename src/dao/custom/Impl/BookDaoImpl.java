package dao.custom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.BookDao;
import entity.BookEntity;

public class BookDaoImpl implements BookDao {
    private Connection connection;
     public BookDaoImpl(Connection connection) {
        this.connection = connection;
    }
    

    @Override
    public String save(BookEntity entity) throws Exception{
        String query = "INSERT INTO books (title,author,category_id,available) VALUES (?,?,?,?)";
       try(PreparedStatement stmt = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS)){
           stmt.setString(1, entity.getTitle());
           stmt.setString(2, entity.getAuthor());
           stmt.setLong(3, entity.getCategoryId());
           stmt.setBoolean(4, entity.isAvailable());
           int rowsAffected = stmt.executeUpdate();

           if(rowsAffected > 0){
            try(ResultSet generatedKeys = stmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    entity.setId(generatedKeys.getLong(1));
                    return "Saved successfully: " + entity.getId();

                }else{
                    return "Success";
                }
            }
       } else {
        return "Failed to Save";
    }
}catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Failed to save the book", e);
    }
}

    @Override
    public String update(BookEntity entity) throws Exception {
        String query = "UPDATE books SET title = ? ,author = ? ,category_id = ?,available = ? WHERE book_id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, entity.getTitle());
            stmt.setString(2, entity.getAuthor());
            stmt.setLong(3, entity.getCategoryId());
            stmt.setBoolean(4, entity.isAvailable());
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0? "Updated Successfully" : "Failed to update";
        } catch (SQLException e){
            e.printStackTrace();
            throw new Exception("Failed to Update the book", e);

        }
    }
    

    @Override
    public String delete(Long id) throws Exception {
        String query = "DELETE FROM books WHERE book_id=?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setLong(1, id);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0? "Deleted Successfully" : "Failed to delete";
        } catch (SQLException e){
            e.printStackTrace();
            throw new Exception("Failed to Delete the book", e);

        }

    }

    @Override
    public BookEntity get(Long id) throws Exception {
        String query = "SELECT * FROM books WHERE book_id=?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new BookEntity(rs.getLong("book_id"), rs.getString("title"), rs.getString("author"),
                            rs.getLong("category_id"), rs.getBoolean("available"));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Failed to get the book", e);
        } 
        }



        @Override
        public ArrayList<BookEntity> getAll() throws Exception {
            String query = "SELECT * FROM books";
            ArrayList<BookEntity> books = new ArrayList<>();
            try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    books.add(new BookEntity(rs.getLong("book_id"), rs.getString("title"), rs.getString("author"),
                            rs.getLong("category_id"), rs.getBoolean("available")));
                }
                return books;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new Exception("Failed to get all books", e);
            }
        }
    
    }

   