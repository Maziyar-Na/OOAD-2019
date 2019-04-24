package domain;

public class PersonFactory {
    public static Person getPerson(UserVO uvo){
        Person person ;
        if (uvo.getType() == PersonType.ADMIN){
            person = new Admin();
        } else if(uvo.getType() == PersonType.LIBRIAN){
            person = new Librarian();
        } else if(uvo.getType() == PersonType.PATRON){
            person = new Patron();
        }else{
            return null;
        }
        person.setName(uvo.getName());
        person.setUsername(uvo.getUsername());
        person.setPassword(uvo.getPassword());
        person.setType(uvo.getType());
        return person ;
    }
}
