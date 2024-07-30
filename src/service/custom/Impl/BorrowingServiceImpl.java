package service.custom.Impl;

import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import dao.custom.BorrowingsDao;
import dto.BorrowingsDto;
import entity.Borrowings;
import service.custom.BorrowingService;

public class BorrowingServiceImpl  implements BorrowingService {
    private BorrowingsDao borrowingsDao;
    public BorrowingServiceImpl(){
        this.borrowingsDao =(BorrowingsDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BORROWINGS);
    }
    
    @Override
    public String save(BorrowingsDto borrowingsDto) throws Exception {
        Borrowings borrowings = new Borrowings(borrowingsDto.getBorrowingId(),borrowingsDto.getBookId(),borrowingsDto.getMemberId(),borrowingsDto.getBorrowingDate(),borrowingsDto.getDueDate(),borrowingsDto.getReturnDate());
        return borrowingsDao.save(borrowings);
    }

    @Override
    public String update(BorrowingsDto borrowingsDto) throws Exception {
        Borrowings borrowings = new Borrowings(borrowingsDto.getBorrowingId(),borrowingsDto.getBookId(),borrowingsDto.getMemberId(),borrowingsDto.getBorrowingDate(),borrowingsDto.getDueDate(),borrowingsDto.getReturnDate());
        return borrowingsDao.update(borrowings);
    }

    @Override
    public String delete(Long borrowingId) throws Exception {
        return borrowingsDao.delete(borrowingId);
    }

    @Override
    public BorrowingsDto getBorrowing(Long borrowingId) throws Exception {
        Borrowings borrowings = borrowingsDao.get(borrowingId);
        if (borrowings != null){
            return new BorrowingsDto(borrowings.getBorrowingId(),borrowings.getBookId(), borrowings.getMemberId(),borrowings.getBorrowingDate(),borrowings.getDueDate(),borrowings.getReturnDate());
        }
        return null;
        }
    

    @Override
    public ArrayList<BorrowingsDto> getAllBorrowings() throws Exception {
        List<Borrowings> borrowingsList = borrowingsDao.getAll();
        ArrayList<BorrowingsDto> borrowingsDtos = new ArrayList<>();
        for (Borrowings borrowings : borrowingsList) {
            borrowingsDtos.add(new BorrowingsDto(borrowings.getBorrowingId(),borrowings.getBookId(),borrowings.getMemberId(),borrowings.getBorrowingDate(),borrowings.getDueDate(),borrowings.getReturnDate()));
        }
        return borrowingsDtos;
    }
    }


