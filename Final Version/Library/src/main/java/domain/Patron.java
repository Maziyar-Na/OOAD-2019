package domain;

import DAO.PersonDao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Patron extends Person {
    private Double outStandingFees;
    List<BorrowedItem> borrowedItems;

    public Patron(){
        outStandingFees = 0.0;
        borrowedItems = new ArrayList<BorrowedItem>();
        setType(PersonType.PATRON);
    }

    public Double getOutStandingFees() {
        return outStandingFees;
    }

    public List<BorrowedItem> getBorrowedItems() {
        return borrowedItems;
    }

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

    public void setOutStandingFees(Double outStandingFees) {
        this.outStandingFees = outStandingFees;
    }

    public int payFee(){
        System.out.println("placeholder for payFee");
        return 0;
    }

    @Override
    public void setType(PersonType type) {
        super.setType(PersonType.PATRON);
    }

    public boolean borrow(List<Item>items){
        System.out.println("[dbg] correct borrow");
        this.addBorrowedItems(items);
        return true;
    }
}
