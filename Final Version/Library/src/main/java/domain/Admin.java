//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: admin additional functionality for adding a new patron
//domain: domain and service Directory is the domain layer
package domain;

import DAO.PersonDao;
import service.userManagement.RegVO;

public class Admin extends Employee {

    //adding a new patron
    public Integer addPatron(RegVO rvo){
        System.out.println("Placeholder for addPatron");
        UserVO uvo = new UserVO();
        uvo.setName(rvo.getFirstname() + " " + rvo.getLastname());
        uvo.setPassword(rvo.getPassword());
        System.out.println("[dbg] before we get type from rvo!" + rvo.getType());
        uvo.setType(PersonType.fromInteger(rvo.getType()));
        uvo.setUsername(rvo.getUsername());
        System.out.println("[dbg] There is no Error until we use the factory!");
        System.out.println("[dbg] uvo: " + uvo.getUsername());
        System.out.println("[dbg] uvo: " + uvo.getPassword());
        System.out.println("[dbg] uvo: " + uvo.getType());
        System.out.println("[dbg] uvo: " + uvo.getName());

        Person newPerson = PersonFactory.getPerson(uvo);
        PersonDao pdo = new PersonDao();
        return pdo.savePerson(newPerson);
    }

    //setting the type of person to ADMIN
    @Override
    public void setType(PersonType type) {
        super.setType(PersonType.ADMIN);
    }
}


