package dao.custom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.custom.BorrowingsDao;
import entity.Borrowings;

public class BorrowingsDaoImpl implements BorrowingsDao {
    private Connection connection;

    public BorrowingsDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String save(Borrowings borrowings) throws Exception {
    String query = "INSERT INTO borrowing_books (borrowingId, book_id, memberId, borrowing_date, due_date, return_date) VALUES (?, ?, ?, ?, ?, ?)";
      try(PreparedStatement stmt = connection.prepareStatement(query)){
        stmt.setLong(1, borrowings.getBorrowingId());
        stmt.setLong(2,borrowings.getBookId());
        stmt.setInt(3,borrowings.getMemberId());
        stmt.setDate(4,java.sql.Date.valueOf(borrowings.getBorrowingDate()));
        stmt.setDate(5,java.sql.Date.valueOf(borrowings.getDueDate()));
        stmt.setDate(6,borrowings.getReturnDate()!=null ? java.sql.Date.valueOf(borrowings.getReturnDate()) : null);

int rowsAffected = stmt.executeUpdate();
return rowsAffected > 0 ? "Success" : "Failed";
      } catch (SQLException e) {
        throw new Exception("Error saving Borrowings" , e);
      }
}
        
    @Override
    public String update(Borrowings borrowings) throws Exception {
        String query = "UPDATE borrowing_books SET  book_id=? ,memberId=? , borrowing_date=? , due_date = ? , return_date = ? WHERE borrowingId=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setLong(1,borrowings.getBookId());
            stmt.setInt(2,borrowings.getMemberId());
            stmt.setDate(3,java.sql.Date.valueOf(borrowings.getBorrowingDate()));
            stmt.setDate(4, java.sql.Date.valueOf(borrowings.getDueDate()));
            stmt.setDate(5, borrowings.getReturnDate() != null ? java.sql.Date.valueOf(borrowings.getReturnDate()) : null);
            stmt.setLong(6, borrowings.getBorrowingId());
       
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0 ? "Success" : "Failed";
        } catch (SQLException e){
            throw new Exception ("Error updating Borrowings", e);

        }
 }
    

    @Override
    public String delete(Long id) throws Exception {
        String query = "DELETE FROM borrowing_books WHERE  borrowingId = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setLong(1,id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0 ? "Success" : "Failed";
        } catch (SQLException e) {
            throw new Exception("Error deleting Borrowings", e);
        }

        }
    

    @Override
    public Borrowings get(Long id) throws Exception {
       String query = "SELECT * FROM borrowing_books WHERE borrowingId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Borrowings(
                        rs.getLong("borrowingId"),
                        rs.getLong("book_id"),
                        rs.getInt("memberId"),
                        rs.getDate("borrowing_date").toLocalDate(),
                        rs.getDate("due_date").toLocalDate(),
                        rs.getDate("return_date") != null ? rs.getDate("return_date").toLocalDate() : null
                    );
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error retrieving Borrowings", e);
        }
    }

    @Override
    public ArrayList<Borrowings> getAll() throws Exception {
        String query = "SELECT * FROM borrowing_books";
        ArrayList<Borrowings> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new Borrowings(
                    rs.getLong("borrowingId"),
                    rs.getLong("book_id"),
                    rs.getInt("memberId"),
                    rs.getDate("borrowing_date").toLocalDate(),
                    rs.getDate("due_date").toLocalDate(),
                    rs.getDate("return_date") != null ? rs.getDate("return_date").toLocalDate() : null
                ));
            }
        } catch (SQLException e) {
            throw new Exception("Error retrieving Borrowings", e);
        }
        return list;
    }
    }

    

