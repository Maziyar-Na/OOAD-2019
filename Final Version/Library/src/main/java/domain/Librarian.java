//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: librarian additional functionality for collecting the fee and returning the borrowed books to the inventory
package domain;

import DAO.PersonDao;

import java.sql.Date;

public class Librarian extends Employee {

    //collect the late fee if there is any
    public float collectFee(ReturnVO rvo){
        PersonDao pdo = new PersonDao();
        FeeVO fvo = pdo.calculateFee(rvo);
        if(fvo == null){
            return -1 ;
        }
        else{
            java.util.Date today = new java.util.Date();
            if(today.getTime() < fvo.getReturn_date().getTime())
                return 0 ;
            else {
                long numberOfDays = (long) ((today.getTime()) - (fvo.getReturn_date().getTime()) / (1000 * 60 * 60 * 24));
                return numberOfDays * (fvo.getLate_fee());
            }
        }

    }

    //return the borrowed book to the inventory
    public Integer returnBook(ReturnVO rvo){
        PersonDao pdo = new PersonDao();
        return pdo.returnBook(rvo);
    }

    //set the type of person to LIBRARIAN
    @Override
    public void setType(PersonType type) {
        super.setType(PersonType.LIBRIAN);
    }
}
