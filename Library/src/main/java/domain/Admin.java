package domain;

public class Admin extends Employee {
    Integer addPatron(Patron x){
        System.out.println("Placeholder for addPatron");
        return 0;
    }
    Integer deletePatron(Patron x){
        System.out.println("Placeholder for deletePatron");
        return 0;
    }
    Integer updatePatron(Patron x){
        System.out.println("Placeholder for addPatron");
        return 0;
    }

    @Override
    public void setType(PersonType type) {
        super.setType(PersonType.ADMIN);
    }
}


