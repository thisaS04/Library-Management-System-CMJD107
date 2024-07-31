package service.custom;

import dto.UserDto;
import service.SuperService;


public interface UserService extends SuperService{
    
    UserDto getUserByUsername(String username) throws Exception;
    String saveUser(UserDto user) throws Exception;
}
