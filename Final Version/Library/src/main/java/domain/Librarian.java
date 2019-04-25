package domain;

import DAO.PersonDao;

import java.sql.Date;

public class Librarian extends Employee {
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
                System.out.println("[dbg] number of days" + numberOfDays);
                return numberOfDays * (fvo.getLate_fee());
            }
        }

    }

    public Integer returnBook(ReturnVO rvo){
        PersonDao pdo = new PersonDao();
        return pdo.returnBook(rvo);
    }

    @Override
    public void setType(PersonType type) {
        super.setType(PersonType.LIBRIAN);
    }
}
