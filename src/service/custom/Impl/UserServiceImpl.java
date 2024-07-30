package service.custom.Impl;

import dao.custom.UserDao;
import entity.UserEntity;
import service.SuperService;
import service.custom.UserService;

public class UserServiceImpl implements UserService, SuperService {
private UserDao userDao;
public UserServiceImpl(UserDao userDao){
    this.userDao = userDao;
}
    @Override
    public void register(UserEntity user) throws Exception {
       userDao.save(user); 
    }

    @Override
    public UserEntity getUser(String username) throws Exception {
        return userDao.get(username);
    }
    
}
