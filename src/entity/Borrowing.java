package entity;

import java.sql.Date;

public class Borrowing {

    private int transactionId;
    private int memberId;
    private int bookId;
    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private double fineAmount;


    public Borrowing(){

    }
    public Borrowing(int transactionId , int memberId, int bookId, Date dueDate, Date returnDate,double fineAmount){
       
        this.transactionId=transactionId;
        this.memberId=memberId;
        this.bookId=bookId;
        this.borrowDate=borrowDate;
        this.dueDate=dueDate;
        this.returnDate=returnDate;
        this.fineAmount=fineAmount;

    }
    public int getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public Date getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public double getFineAmount() {
        return fineAmount;
    }
    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }
    @Override
    public String toString() {
        return "Borrowing [transactionId=" + transactionId + ", memberId=" + memberId + ", bookId=" + bookId
                + ", borrowDate=" + borrowDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate + ", fineAmount="
                + fineAmount + "]";
    }
    


}
