package domain;

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
