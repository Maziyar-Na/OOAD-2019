//authors: Sepideh Goodarzy, Maziyar Nazari
//purpose: this file only works as a data holder for passing the data from view layer to domain layer and also for passing the data between domain layer and data access layer
package domain;

import java.sql.Date;


//the data elements + getters an setters
public class BookVO {
    String book_name;
    String author;
    String isbn_num;
    Date since_date;
    Integer type;
    Integer available;

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn_num(String isbn_num) {
        this.isbn_num = isbn_num;
    }

    public void setSince_date(Date since_date) {
        this.since_date = since_date;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setAvailable(Integer available) {
        this.available = available;
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

    public Date getSince_date() {
        return since_date;
    }

    public Integer getType() {
        return type;
    }

    public Integer getAvailable() {
        return available;
    }

}
