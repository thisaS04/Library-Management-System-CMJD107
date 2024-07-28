package dto;

public class MemberDto {
    private Long id;
    private String memberName;
    private String phone;

    public MemberDto(){
        
    }
    public MemberDto(Long id, String memberName, String phone){
        this.id=id;
        this.memberName=memberName;
        this.phone=phone;

}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
        return "MemberDto [id=" + id + ", memberName=" + memberName + ", phone=" + phone + "]";
    }
   

}
