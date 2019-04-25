package domain;

import DAO.PersonDao;
import service.userManagement.RegVO;

public class Admin extends Employee {
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


