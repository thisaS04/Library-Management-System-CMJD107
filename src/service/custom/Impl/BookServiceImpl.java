package service.custom.Impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.BookDao;
import dto.BookDto;
import entity.BookEntity;
import service.custom.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);

    @Override
    public String save(BookDto dto) throws Exception {
   BookEntity entity = new BookEntity(null,dto.getTitle(),dto.getAuthor(), dto.getCategoryId(), dto.isAvailable());

   return bookDao.save(entity);

    }

    @Override
    public String update(BookDto dto) throws Exception {
        BookEntity entity = new BookEntity(null,dto.getTitle(),dto.getAuthor(), dto.getCategoryId(), dto.isAvailable());
        return bookDao.update(entity);     
        
    }

    @Override
    public String delete(Long id) throws Exception {
        return bookDao.delete(id);
    }

    @Override
    public BookDto get(Long id) throws Exception {
        BookEntity entity = bookDao.get(id);
        return new BookDto(entity.getId(),entity.getTitle(),entity.getAuthor(),entity.getCategoryId(),entity.isAvailable());

    }

    @Override
    public ArrayList<BookDto> getAll() throws Exception {
        ArrayList<BookDto> bookDtos = new ArrayList<>();
        ArrayList<BookEntity> bookEntities= bookDao.getAll();
        for (BookEntity bookEntity : bookEntities) {
            BookDto dto = new BookDto(bookEntity.getId(),bookEntity.getTitle(),bookEntity.getAuthor(),bookEntity.getCategoryId(),bookEntity.isAvailable());
            bookDtos.add(dto);
        }
        return bookDtos;
    }
   
    }
 

