//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: sort interface
package domain;
import java.awt.print.Book;
import java.util.List;

public interface SortInterface {
    public List<BookVO> sort(List<BookVO> items);
}
