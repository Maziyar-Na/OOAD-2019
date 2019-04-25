package domain;

import java.sql.Date;
import java.util.Calendar;

public class BorrowedItem {
    private Item item;
    private Date borrowDate;
    private Date returnDate;
    private float lateFee = 1;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setBorrowDate() {
        this.borrowDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());;
    }

    public void setReturnDate() {
        java.util.Date currentDate;
        currentDate = new java.util.Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 7);
        this.returnDate = new Date(c.getTime().getTime());
    }

    public float getLateFee(){
        return lateFee;
    }
}
