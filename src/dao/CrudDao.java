package dao;

import java.util.ArrayList;



public interface CrudDao<T, ID> extends SuperDAO {
     String save(T t) throws Exception;
     
    String update(T t) throws Exception;
    String delete(Long id) throws Exception;
    T get(String username) throws Exception;
    ArrayList<T> getAll() throws Exception;
}

