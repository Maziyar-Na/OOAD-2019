//authors: Sepideh Goodarzy, Maziyar Nazari
//purpose: this file only works as a data holder for passing the data from view layer to domain layer and also for passing the data between domain layer and data access layer
package domain;


//the data elements + getters an setters
public class ReturnVO {
    String username;
    String book_name;
    String isbn_num;

    public String getUsername() {
        return username;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getIsbn_num() {
        return isbn_num;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setIsbn_num(String isbn_num) {
        this.isbn_num = isbn_num;
    }
}
