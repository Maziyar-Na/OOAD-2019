package edu.cuboulder;

import java.util.List;

public class Patron extends Person {
    private double outStandingFees;
    List<BorrowedItem> borrowedItems;


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public double getOutStandingFees() {
        return outStandingFees;
    }

    public List<BorrowedItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(List<BorrowedItem> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public void setOutStandingFees(double outStandingFees) {
        this.outStandingFees = outStandingFees;
    }

    public int payFee(){
        System.out.println("placeholder for payFee");
        return 0;
    }

    public int setProfile(){
        System.out.println("Plaeholder for setProfile");
        return 0;
    }
}
