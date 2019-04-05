package edu.cuboulder;
import java.util.List;

public class Library {
    private Inventory inventory;
    private List<Person> users;
    private Double lateFees;
    private PersonDao personDao;
    private InventoryDao inventoryDao;


    Person addPerson(String name, String password, PersonType personType){
        System.out.println("Placeholder for addperson");
        return null;
    }

    Person getPerson(String name){
        System.out.println("Placeholder for getPerson");
        return null;
    }

    Person getPerson(Integer id){
        System.out.println("Placeholder for getPerson");
        return null;
    }

    Double getTotalLateFees(List<Person> patrons){
        System.out.println("Placeholder for getTotalLateFees");
        return 0.0;
    }

    Person modifyPerson(Person person){
        System.out.println("modify person place holder");
        return null;
    }

    Integer login(String userName, String password){
        System.out.println("Placeholder for login");
        return 0;
    }

    List<Person> getUsers(){
        System.out.println("Placeholder for getUsers");
        return null;
    }


}
