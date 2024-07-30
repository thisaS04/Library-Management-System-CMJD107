package service.custom;

import java.util.List;

import dto.BorrowingsDto;
import service.SuperService;

public  interface BorrowingService extends SuperService {
    String save(BorrowingsDto borrowingsDto) throws Exception;
    String update(BorrowingsDto borrowingsDto) throws Exception;
    String delete(Long borrowingId) throws Exception;
   BorrowingsDto getBorrowing(Long borrowingId) throws Exception;
   List<BorrowingsDto> getAllBorrowings() throws Exception;
}
