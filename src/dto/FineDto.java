package dto;

import java.math.BigDecimal;
import java.sql.Date;

public class FineDto {
    private int fineId;
    private Long borrowingId;
    private BigDecimal fineAmount;
    private Date fineDate;
    private boolean isPaid;

    public FineDto(int fineId, Long borrowingId, BigDecimal fineAmount, Date fineDate, boolean isPaid) {
        this.fineId = fineId;
        this.borrowingId = borrowingId;
        this.fineAmount = fineAmount;
        this.fineDate = fineDate;
        this.isPaid = isPaid;
    }

    public int getFineId() {
        return fineId;
    }

    public void setFineId(int fineId) {
        this.fineId = fineId;
    }

    public Long getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Long borrowingId) {
        this.borrowingId = borrowingId;
    }

    public BigDecimal getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(BigDecimal fineAmount) {
        this.fineAmount = fineAmount;
    }

    public Date getFineDate() {
        return fineDate;
    }

    public void setFineDate(Date fineDate) {
        this.fineDate = fineDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public String toString() {
        return "FineDto [fineId=" + fineId + ", borrowingId=" + borrowingId + ", fineAmount=" + fineAmount
                + ", fineDate=" + fineDate + ", isPaid=" + isPaid + "]";
    }

   
    
}
