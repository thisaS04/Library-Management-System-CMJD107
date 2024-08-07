package dto;

public class BookCategoryDto {
    private Long categoryId;
    private String categoryName;

public BookCategoryDto(){

}
public BookCategoryDto(Long categoryId , String categoryName){
    this.categoryId=categoryId;
    this.categoryName=categoryName;

}
public Long getCategoryId() {
    return categoryId;
}
public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
}
public String getCategoryName() {
    return categoryName;
}
public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
}
@Override
public String toString() {
    return "BookCategoryDto [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
}


}
