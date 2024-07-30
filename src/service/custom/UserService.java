package service.custom;

import entity.UserEntity;

public interface UserService {
    void register(UserEntity user) throws Exception;
    UserEntity getUser(String username) throws Exception;
}
