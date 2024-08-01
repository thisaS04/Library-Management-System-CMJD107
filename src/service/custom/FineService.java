package service.custom;

import java.util.List;

import dto.FineDto;
import service.SuperService;

public interface FineService extends SuperService {
     String saveFine(FineDto fine) throws Exception;
     FineDto getfine(int fineId) throws Exception;
     List<FineDto> getAllFines()throws Exception;
     String updateFine(FineDto fine)throws Exception;
     String deleteFine(int fineId) throws Exception;


}
