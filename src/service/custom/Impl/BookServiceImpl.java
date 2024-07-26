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
   BookEntity entity =getBookEntity(dto);
   return bookDao.save(entity);

    }

    @Override
    public String update(BookDto dto) throws Exception {
        BookEntity entity = getBookEntity(dto);
        return bookDao.update(entity);     
        
    }

    @Override
    public String delete(Long id) throws Exception {
        return bookDao.delete(id);
    }

    @Override
    public BookDto get(Long id) throws Exception {
        BookEntity entity = bookDao.get(id);
        return getBookDto(entity);
    }

    @Override
    public ArrayList<BookDto> getAll() throws Exception {
        ArrayList<BookDto> bookDtos = new ArrayList<>();
        ArrayList<BookEntity> bookEntitys = bookDao.getAll();
        for (BookEntity bookEntity : bookEntitys) {
            BookDto dto = getBookDto(bookEntity);
            bookDtos.add(dto);
        }
        return bookDtos;
    }
    private BookDto getBookDto(BookEntity entity){
        BookDto bookDto = new BookDto(entity.getId(), entity.getTitle(),
        entity.getAuthor(), entity.getCategoryId(), entity.isAvailable());
return bookDto;
    }
    
    private BookEntity getBookEntity(BookDto dto){
         BookEntity entity = new BookEntity(dto.getId(), dto.getTitle(),
                dto.getAuthor(), dto.getCategoryId(), dto.isAvailable());
         return entity;
    }
 

}