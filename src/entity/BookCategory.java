package entity;

public class BookCategory {
    
    private Long categoryId;
    private String categoryName;

    public BookCategory(Long categoryId, String categoryName){
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
        return "BookCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
    }

   

}
