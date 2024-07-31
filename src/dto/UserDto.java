package dto;

public class UserDto {
    private String name;
    private String username;
    private String phone;
    private String password;

    public UserDto(String name, String username, String phone, String password) {
        this.name=name;
        this.username=username;
        this.phone=phone;
        this.password=password;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto [name=" + name + ", username=" + username + ", phone=" + phone + ", password=" + password + "]";
    }

}
