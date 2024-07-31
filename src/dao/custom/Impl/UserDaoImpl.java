package dao.custom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import dao.custom.UserDao;
import entity.UserEntity;

public class UserDaoImpl implements  UserDao{

    private Connection connection;

    public UserDaoImpl(Connection connection){
       this.connection=connection; 
    }

    @Override
    public String save(UserEntity user) throws Exception {
        String sql = "INSERT INTO users (name,username,phone,password) VALUES (?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPhone());
            stmt.setString(4, user.getPassword());
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0){
                return "User Saved Successfully";
            } else {
                throw new Exception("Failed to save User");

            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new Exception ("Error saving user",e);

        }
        }
    

    @Override
    public UserEntity get(String username) throws Exception {
        String sql = "SELECT * FROM users WHERE username = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            String name= rs.getString("name");
            String phone= rs.getString("phone");
            String password = rs.getString("password");

            return new UserEntity(name,username,phone,password);
        }
        return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving user", e);
        
    }

    
    }
    
    
}
