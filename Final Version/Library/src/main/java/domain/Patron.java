//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose:  patron additional functionality
package domain;

import DAO.PersonDao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Patron extends Person {
    List<BorrowedItem> borrowedItems;

    public Patron() {
        borrowedItems = new ArrayList<BorrowedItem>();
    }

    public List<BorrowedItem> getBorrowedItems() {
        return borrowedItems;
    }

    //patron updating his/her borrowed items
    public void addBorrowedItems(List<Item> Items) {
        PersonDao pdo = new PersonDao();
        for (Item item:
             Items) {
            BorrowedItem bitem = new BorrowedItem();
            bitem.setItem(item);
            bitem.setBorrowDate();
            bitem.setReturnDate();
            pdo.addBorrowedItems(this, bitem);
            borrowedItems.add(bitem);
        }
    }

    //setting the type of person to PATRON
    @Override
    public void setType(PersonType type) {
        super.setType(PersonType.PATRON);
    }

    //patron borrowing a list of items
    public boolean borrow(List<Item>items){
        this.addBorrowedItems(items);
        return true;
    }
}
