package service.custom;

import dto.UserDto;


public interface UserService {
    
    UserDto getUserByUsername(String username) throws Exception;
    String saveUser(UserDto user) throws Exception;
}
