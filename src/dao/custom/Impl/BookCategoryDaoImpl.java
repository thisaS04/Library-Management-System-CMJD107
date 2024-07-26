package dao.custom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.custom.BookCategoryDao;
import entity.BookCategory;

public class BookCategoryDaoImpl implements BookCategoryDao{


    private Connection connection;

    public BookCategoryDaoImpl(Connection connection){
        this.connection = connection;
    }
    @Override
    public String save(BookCategory category) throws Exception {
     String query = "INSERT INTO book book_categories (category_name) VALUES (?)";
     try(PreparedStatement stmt = connection.prepareStatement(query)){
        stmt.setString(1, category.getCategoryName());
        int rowsAffected = stmt.executeUpdate();

        if(rowsAffected > 0){
           try(ResultSet generatedKeys = stmt.getGeneratedKeys()){
            if(generatedKeys.next()){
                category.setCategoryId(generatedKeys.getLong(1));
            
            return "Saved successfully : " + category.getCategoryId();
        }else {
            return "Failed to Save";
        }
    }
    } else {
        return "failed to save";
    }
        
    } catch (SQLException e){
        e.printStackTrace();
        throw new Exception("Failed to Save the category", e);

    } 
    }

    @Override
    public String update(BookCategory category) throws Exception {
       String query = "UPDATE book_categories SET category_name = ? WHERE category_id = ?";
       try(PreparedStatement stmt = connection.prepareStatement(query)){
        stmt.setLong(1, category.getCategoryId());
        stmt.setString(2, category.getCategoryName());
        int rowsAffected = stmt.executeUpdate();

        return rowsAffected > 0 ? "Updated successfully" : "Failed to Update";
    } catch (SQLException e){
        e.printStackTrace();
        throw new Exception("Failed to Update the category", e);
    }
}

    @Override
    public String delete(Long id) throws Exception {
    String query = "DELETE FROM book_categories WHERE category_id = ?";
    try(PreparedStatement stmt = connection.prepareStatement(query)){
        stmt.setLong(1,id);
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0 ? "Deleted successfully" : "Failed to delete";
    } catch (SQLException e){
        e.printStackTrace();
        throw new Exception("Failed to delete the category", e);
    }
    }

    @Override
    public BookCategory get(Long id) throws Exception {
       String query ="SELECT * FROM book_categories WHERE category_id = ?";
       try (PreparedStatement stmt = connection.prepareStatement(query)){
        stmt.setLong(1, id);
        try(ResultSet rs = stmt.executeQuery()){
            if (rs.next()){
                return new BookCategory(rs.getLong("category_id"),rs.getString("category_name"));

            } else {
                return null;
            }
        }
       } catch  (SQLException e){
        e.printStackTrace();
        throw new Exception("Failed to get the category", e);
    }
}

    @Override
    public ArrayList<BookCategory> getAll() throws Exception {
        String query ="SELECT * FROM book_categories"; 
ArrayList<BookCategory> categories = new ArrayList<>();
try(PreparedStatement stmt = connection.prepareStatement(query);
     ResultSet rs = stmt.executeQuery()){
        while(rs.next()){
            categories.add(new BookCategory(rs.getLong("category_id"),rs.getString("category_name")));
        }
        return categories;
     } catch (SQLException e){
        e.printStackTrace();
        throw new Exception("Failed to get all categories", e);
     }

    }
    
}
