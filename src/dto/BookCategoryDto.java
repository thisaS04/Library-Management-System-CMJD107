package dto;

public class BookCategoryDto {
    private int id;
    private String categoryName;

public BookCategoryDto(){

}
public BookCategoryDto(int id, String categoryName){
    this.id=id;
    this.categoryName=categoryName;

}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getCategoryName() {
    return categoryName;
}
public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
}
@Override
public String toString() {
    return "BookCategoryDto [id=" + id + ", categoryName=" + categoryName + "]";
}

}
