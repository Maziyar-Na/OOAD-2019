package edu.cuboulder;

import java.util.Date;

public class BorrowedItem {
    private String title;
    private Integer id;
    private Date borrowDate;
    private Date retutnDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getRetutnDate() {
        return retutnDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setRetutnDate(Date retutnDate) {
        this.retutnDate = retutnDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
