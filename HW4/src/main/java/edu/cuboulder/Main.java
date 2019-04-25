package edu.cuboulder;

public class Main {

    public static void main(String[] args) {

    PersonDao pD = new PersonDao();
    Person person = new Person;
    Integer rc;

    rc = pD.connect();

    person.setName("Dwight Browne");
    person.setId(1001);
    person.setPassword("TESTING");
    person.setType(PersonType.PATRON);
    person.setDob();

    rc = pD.savePerson(person);




    }
}
