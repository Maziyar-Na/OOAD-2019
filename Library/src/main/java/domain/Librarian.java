package domain;

public class Librarian extends Employee {
    public Integer collectFee(Double fee){
        System.out.println("Placeholder for collect fee");
        return 0;
    }

    @Override
    public void setType(PersonType type) {
        super.setType(PersonType.LIBRIAN);
    }
}
