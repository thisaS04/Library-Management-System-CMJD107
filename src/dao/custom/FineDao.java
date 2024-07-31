package dao.custom;

import java.util.List;
import dao.SuperDAO;
import entity.Fine;

public interface FineDao extends SuperDAO {
    String save(Fine fine) throws Exception;
    Fine get(int fineId) throws Exception;
    List<Fine> getAll() throws Exception;
    String update(Fine fine) throws Exception;
    String delete(int fineId) throws Exception;
}
