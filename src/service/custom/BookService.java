package service.custom;

import java.util.ArrayList;

import dto.BookDto;
import service.SuperService;

public interface BookService extends SuperService {
      public String save(BookDto dto) throws Exception;
    public String update(BookDto dto) throws Exception;
    public String delete(Long id) throws Exception;
    public BookDto get(Long id) throws Exception;
    public ArrayList<BookDto> getAll() throws Exception;
}

