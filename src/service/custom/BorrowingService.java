package service.custom;

import java.util.List;

import dto.BorrowingsDto;

public  interface BorrowingService {
    String save(BorrowingsDto borrowingsDto) throws Exception;
    String update(BorrowingsDto borrowingsDto) throws Exception;
    String delete(BorrowingsDto borrowingsDto) throws Exception;
   BorrowingsDto getBorrowing(Long borrowingId) throws Exception;
   List<BorrowingsDto> getAllBorrowings() throws Exception;
}
