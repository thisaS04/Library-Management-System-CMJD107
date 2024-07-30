package dto;

import java.time.LocalDate;

public class BorrowingsDto {
    private long borrowingId;
    private long bookId;
    private int memberId;
    private LocalDate borrowingDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public BorrowingsDto(){

    }
    public BorrowingsDto(long borrowingId, long bookId, int memberId, LocalDate borrowingDate, LocalDate dueDate, LocalDate returnDate) {
        this.borrowingId = borrowingId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowingDate = borrowingDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public long getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(long borrowingId) {
        this.borrowingId = borrowingId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BorrowingsDto [borrowingId=" + borrowingId + ", bookId=" + bookId + ", memberId=" + memberId
                + ", borrowingDate=" + borrowingDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate + "]";
    }

}