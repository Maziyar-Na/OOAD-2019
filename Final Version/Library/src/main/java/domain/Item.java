package domain;

import java.util.Date;

public abstract class Item{
    private String book_name;
    private String author;
    private String isbn_num;
    private Date date;
    private Integer available;
    ItemType type;

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn_num(String isbn_num) {
        this.isbn_num = isbn_num;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn_num() {
        return isbn_num;
    }

    public Date getDate() {
        return date;
    }

    public Integer getAvailable() {
        return available;
    }

    public ItemType getType() {
        return type;
    }


}
