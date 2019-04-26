//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: this is the Library main class
//pattern usage: Library is based on singleton pattern
package domain;

import DAO.PersonDao;

import java.util.ArrayList;
import java.util.List;

public class Library {

    //
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

    //adding an active person (someone who is logged into the system) to the list of active users
    public void addPerson(Person p){
        users.add(p);
    }

    //this function is used for getting an active person based on its username
    public Person getPerson(String username){
        for (Person user:
             this.getUsers()) {
            if(username.equals(user.getUsername())){
                return user ;
            }
        }
        return null ;
    }

    //login a person
    public Person login(UserVO uvo){
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
