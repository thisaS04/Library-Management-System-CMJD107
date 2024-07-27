package service.custom.Impl;


import java.util.ArrayList;


import dao.DaoFactory;
import dao.custom.BookCategoryDao;
import dto.BookCategoryDto;
import entity.BookCategory;
import service.custom.BookCategoryService;

public class BookCategoryServiceImpl implements BookCategoryService {
    private BookCategoryDao bookCategoryDao = (BookCategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOKCATEGORY);
    @Override
    public String save(BookCategoryDto dto) throws Exception {
        BookCategory entity = new BookCategory(dto.getCategoryId(),dto.getCategoryName());
        return bookCategoryDao.save(entity);
    }

    @Override
    public String update(BookCategoryDto dto) throws Exception {
        BookCategory entity = new BookCategory(dto.getCategoryId(),dto.getCategoryName());
        return bookCategoryDao.update(entity);
    }

    @Override
    public String delete(Long id) throws Exception {
      return bookCategoryDao.delete(id);
    }

    @Override
    public BookCategoryDto get(Long id) throws Exception {
        BookCategory entity =bookCategoryDao.get(id);
        return new BookCategoryDto(entity.getCategoryId(),entity.getCategoryName());
    }

    @Override
    public ArrayList<BookCategoryDto> getAll() throws Exception {
        ArrayList<BookCategoryDto> dtos = new ArrayList<>();
        ArrayList<BookCategory> categories = bookCategoryDao.getAll();
        for (BookCategory category : categories) {
            dtos.add(new BookCategoryDto(category.getCategoryId(), category.getCategoryName()));
        }
        return dtos;
    }
    }
      
    
    
    



    
    

