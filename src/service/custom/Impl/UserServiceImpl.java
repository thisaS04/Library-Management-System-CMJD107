package service.custom.Impl;

import dao.custom.UserDao;
import dto.UserDto;
import entity.UserEntity;

import service.custom.UserService;

public class UserServiceImpl implements UserService{
private final UserDao userDao;


public UserServiceImpl(UserDao userDao){
    this.userDao = userDao;
}
    
    @Override
    public UserDto getUserByUsername(String username) throws Exception {
        try{
            UserEntity user = userDao.get(username);
            if (user!=null){
                return new UserDto(user.getName(),user.getUsername(),user.getPhone(),user.getPassword());
            } else {
                return null;
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("Error retrieving user",e);
        }
    }
    @Override
    public String saveUser(UserDto user) throws Exception{
        try{
            userDao.save(new UserEntity(user.getName(),user.getUsername(),user.getPhone(),user.getPassword()));
            return "User Saved Successfully";
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("Error saving user", e);
        }
    }
    }
    

