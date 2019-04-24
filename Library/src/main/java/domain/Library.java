package domain;

import DAO.PersonDao;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static Library instance ;
    private List<Person> users ;

    private Library(){
        users = new ArrayList<Person>();
    }

    public static Library getInstance(){
        if(instance == null){
            instance = new Library();
        }
        return instance ;
    }

    public void addPerson(Person p){
        users.add(p);
    }

    public Person getPerson(String username){
        for (Person user:
             this.getUsers()) {
            if(username.equals(user.getUsername())){
                return user ;
            }
        }
        return null ;
    }

    public Double getTotalLateFees(List<Person> patrons){
        System.out.println("Placeholder for getTotalLateFees");
        return 0.0;
    }

    public Person modifyPerson(Person person){
        System.out.println("modify person place holder");
        return null;
    }

    public Person login(UserVO uvo){
        System.out.println("Placeholder for login");
        PersonDao pd = new PersonDao();
        UserVO activeUserVO = pd.checkPerson(uvo);
        if ( activeUserVO != null){
            Person activeUser = PersonFactory.getPerson(activeUserVO);
            this.addPerson(activeUser);
            return activeUser;
        }
        return null;
    }

    public List<Person> getUsers(){
        return this.users ;
    }

    public Inventory getInventory(){
        return Inventory.getInstance() ;
    }
}
