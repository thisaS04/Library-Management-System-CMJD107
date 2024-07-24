package entity;

public class BookCategory {
    
    private int id;
    private String categoryName;

    public BookCategory(int id, String categoryName){
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
        return "BookCategory [id=" + id + ", categoryName=" + categoryName + "]";
    }
    

}
