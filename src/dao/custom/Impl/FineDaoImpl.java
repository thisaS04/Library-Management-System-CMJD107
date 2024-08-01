package dao.custom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dao.custom.FineDao;
import entity.Fine;

public class FineDaoImpl implements FineDao{
private Connection connection;


public FineDaoImpl(Connection connection) {
    this.connection = connection;
}
    @Override
    public String save(Fine fine) throws Exception {
       String sql = "INSERT INTO fines (fineId, borrowingId, fine_amount, fine_date, is_paid) VALUES (?, ?, ?, ?, ?)";
       PreparedStatement prepareStatement = connection.prepareStatement(sql);
       prepareStatement.setInt(1, fine.getFineId());
       prepareStatement.setLong(2, fine.getBorrowingId());
       prepareStatement.setBigDecimal(3, fine.getFineAmount());
       prepareStatement.setDate(4,new java.sql.Date(fine.getFineDate().getTime()) );
       prepareStatement.setBoolean(5, fine.isPaid());

       int result = prepareStatement.executeUpdate();
       return result > 0 ? "Fine Saved Successfully" : "Error at saving Fine";
    }

    @Override
    public Fine get(int fineId) throws Exception {
        String sql = "SELECT * FROM fines WHERE fineId = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1,fineId);
        ResultSet rst = prepareStatement.executeQuery();
        if(rst.next()){
            return new Fine(rst.getInt("fineId"),rst.getLong("borrowingId"),rst.getBigDecimal("fine_amount"),rst.getDate("fine_date"),rst.getBoolean("is_paid") );
        }
        return null;
    }

    @Override
    public List<Fine> getAll() throws Exception {
       String sql = "SELECT * FROM fines";
       List<Fine> fines = new ArrayList<>();
       try (PreparedStatement statement = connection.prepareStatement(sql);
       ResultSet rst = statement.executeQuery()) {
        
        while (rst.next()) {
            fines.add(new Fine(
                rst.getInt("fineId"),
                rst.getLong("borrowingId"), 
                rst.getBigDecimal("fine_amount"),
                rst.getDate("fine_date"),
                rst.getBoolean("is_paid")
            ));
        }
    } catch (SQLException e) {
        throw new Exception("Error fetching fines", e);
    }
    
    return fines;
       
    }

    @Override
    public String update(Fine fine) throws Exception {
        String sql = "UPDATE fines SET borrowingId = ?, fine_amount = ?, fine_date = ?, is_paid = ? WHERE fineId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, fine.getBorrowingId());
        preparedStatement.setBigDecimal(2, fine.getFineAmount());
        preparedStatement.setDate(3, new java.sql.Date(fine.getFineDate().getTime()));
        preparedStatement.setBoolean(4, fine.isPaid());
        preparedStatement.setInt(5, fine.getFineId());
        int result = preparedStatement.executeUpdate();
        return result > 0 ? "Fine Updated Successfully" : "Failed to Update Fine";
    }
    

    @Override
    public String delete(int fineId) throws Exception {
        String sql = "DELETE FROM fines WHERE fineId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, fineId);
        int result = preparedStatement.executeUpdate();
        return result > 0 ? "Fine Deleted Successfully" : "Failed to Delete Fine";
    }
    
}
