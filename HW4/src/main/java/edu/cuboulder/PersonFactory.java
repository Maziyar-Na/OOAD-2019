package edu.cuboulder;

public class PersonFactory {
    public static PersonInterface getPerson(PersonType personType){
        if (personType == PersonType.ADMIN){
            return new Admin();
        } else if(personType == PersonType.LIBRIAN){
            return new Librarian();
        } else if(personType == PersonType.PATRON){
            return new Patron();
        }else{
            return null;
        }
    }
}
