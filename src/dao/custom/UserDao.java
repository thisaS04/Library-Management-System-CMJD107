package dao.custom;

import entity.UserEntity;

public interface UserDao {
 String save(UserEntity user) throws Exception;
    UserEntity get(String username) throws Exception;
}
