package service.custom;

import java.util.ArrayList;


import dto.MemberDto;
import service.SuperService;

public interface MemberService extends SuperService {
      public String save(MemberDto dto) throws Exception;
    public String update(MemberDto dto) throws Exception;
    public String delete(Long id) throws Exception;
    public MemberDto get(Long id) throws Exception;
    public ArrayList<MemberDto> getAll() throws Exception;
}