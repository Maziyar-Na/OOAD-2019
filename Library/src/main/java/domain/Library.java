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

    public Double getTotalLateFees(List<Person> patrons){ /*TODO:  test this!!!*/
        Double lateFee =0.0;
        for (Person pp : patrons){
            lateFee += lateFee +pp.getOutStandingFees();
        }
        return lateFee;
    }

    public Integer modifyPerson(Person person){   /*TODO:  test this!!!*/
        Integer rc;
        PersonDao pd = new PersonDao();
        pd.connect();
        rc = pd.modifyPerson(person);
        return rc;
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
