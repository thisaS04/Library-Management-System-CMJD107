package service.custom.Impl;

import java.util.ArrayList;
import java.util.List;

import dao.custom.FineDao;
import dto.FineDto;
import entity.Fine;
import service.custom.FineService;

public class FineServiceImpl implements FineService{
private final FineDao fineDao;

public FineServiceImpl(FineDao fineDao){
    this.fineDao = fineDao;
}

    @Override
    public String saveFine(FineDto fine) throws Exception {
        return fineDao.save(new Fine(fine.getFineId(),fine.getBorrowingId(),fine.getFineAmount(),fine.getFineDate(),fine.isPaid()));
    }

    @Override
    public FineDto getfine(int fineId) throws Exception {
        Fine fine = fineDao.get(fineId);
        if(fine!=null){
            return new FineDto(fine.getFineId(),fine.getBorrowingId(), fine.getFineAmount(), fine.getFineDate(), fine.isPaid());
        }
        return null;
    }

    @Override
    public List<FineDto> getAllFines() throws Exception {
       List<Fine>fines = fineDao.getAll();
       List<FineDto> fineDtos = new ArrayList<>();
       for (Fine fine :fines){
        fineDtos.add(new FineDto(fine.getFineId(),fine.getBorrowingId(),fine.getFineAmount(),fine.getFineDate(),fine.isPaid()));
       }
       return fineDtos;
    }

    @Override
    public String updateFine(FineDto fine) throws Exception {
        return fineDao.update(new Fine(fine.getFineId(),fine.getBorrowingId(),fine.getFineAmount(),fine.getFineDate(),fine.isPaid()));
    }

    @Override
    public String deleteFine(int fineId) throws Exception {
       return fineDao.delete(fineId);
    }
    
    
}
