package dto;

public class BookDto {
    private Long id;
    private String title;
    private String author;
    private Long categoryId;
    private boolean available;

 public BookDto(){

 }
public BookDto(Long id, String title,String author,Long categoryId,boolean available ){
    this.id=id;
    this.title=title;
    this.author=author;
    this.categoryId=categoryId;
    this.available=available;
    
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
}
public String getAuthor() {
    return author;
}
public void setAuthor(String author) {
    this.author = author;
}
public Long getCategoryId() {
    return categoryId;
}
public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
}
public boolean isAvailable() {
    return available;
}
public void setAvailable(boolean available) {
    this.available = available;
}
@Override
public String toString() {
    return "BookDto [id=" + id + ", title=" + title + ", author=" + author + ", categoryId=" + categoryId
            + ", available=" + available + "]";
}


}
