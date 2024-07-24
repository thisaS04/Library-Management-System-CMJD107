package entity;

public class Member {
    private int id;
    private String memberName;
    private String phone;

    public Member(int id, String MemberName, String Phone){
        this.id=id;
        this.memberName=memberName;
        this.phone=phone;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", memberName=" + memberName + ", phone=" + phone + "]";
    }

    
}
