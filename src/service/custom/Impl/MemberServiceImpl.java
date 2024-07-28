package service.custom.Impl;

import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import dao.custom.MemberDao;
import dto.MemberDto;
import entity.Member;
import service.custom.MemberService;

public class MemberServiceImpl implements MemberService{
    private MemberDao memberDao;

public MemberServiceImpl(){
    this.memberDao = (MemberDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.MEMBER);
}

    @Override
    public String save(MemberDto dto) throws Exception {
        Member member = new Member(dto.getId(),dto.getMemberName(),dto.getPhone());
        return memberDao.save(member);
    }

    @Override
    public String update(MemberDto dto) throws Exception {
        Member member = new Member(dto.getId(),dto.getMemberName(),dto.getPhone());
        return memberDao.update(member);
    }
    

    @Override
    public String delete(Long id) throws Exception {
       return memberDao.delete(id);
    }

    @Override
    public MemberDto get(Long id) throws Exception {
        Member member = memberDao.get(id);
        if (member != null){
            return new MemberDto(member.getId(), member.getMemberName(), member.getPhone());
        }
        return null;
        }
    

    @Override
    public ArrayList<MemberDto> getAll() throws Exception {
        List<Member> members = memberDao.getAll();
        ArrayList<MemberDto> memberDtos = new ArrayList<>();
        for (Member member : members) {
            memberDtos.add(new MemberDto(member.getId(), member.getMemberName(), member.getPhone()));
        }
        return memberDtos;
    }
    
    
}
