package dao.custom.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.MemberDao;
import entity.Member;

public class MemberDaoImpl implements MemberDao{
    private Connection connection;
public MemberDaoImpl(Connection connection){
    this.connection = connection;
}

    @Override
    public String save(Member entity) throws Exception {
       boolean isSaved = CrudUtil.executeUpdate("INSERT INTO Members (memberId, memberName, phone) VALUES (?, ?, ?)",
                entity.getId(), entity.getMemberName(), entity.getPhone());
        return isSaved ? "Success" : "Fail";
    }

    @Override
    public String update(Member entity) throws Exception {
        boolean isUpdated = CrudUtil.executeUpdate( "UPDATE Members SET memberName = ?, phone = ? WHERE memberId = ?",
        entity.getMemberName(), entity.getPhone(), entity.getId());
return isUpdated ? "Success" : "Fail";
}
    

    @Override
    public String delete(Long id) throws Exception {
        boolean isDeleted = CrudUtil.executeUpdate("DELETE FROM Members WHERE memberId = ?", id);
        return isDeleted ? "Success" : "Fail";
      
    }

    @Override
    public Member get(Long id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Members WHERE memberId = ?", id);
        if (rst.next()) {
            return new Member(rst.getLong("memberId"), rst.getString("memberName"), rst.getString("phone"));
        }
        return null;
      
    }

    @Override
    public ArrayList<Member> getAll() throws Exception {
        ArrayList<Member> members = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Members");
        while (rst.next()) {
            Member entity = new Member(
                rst.getLong("memberId"),
                rst.getString("memberName"),
                rst.getString("phone")
            );
            members.add(entity);
        }
        return members;
    }
    }
    
    

