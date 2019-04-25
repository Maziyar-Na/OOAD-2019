package edu.cuboulder.unittests;
import domain.Patron;
import domain.Person;
import domain.PersonType;
import DAO.PersonDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/* Combining both unit and integration tests for speed of testing */
public class PersonDaoTest {
    private Patron patron;
    private String  DJB ="dbrowne";
    private Patron patron_ref;
    private String PATRON_NAME = "testy Tester";
    private String PATRON_PASS ="FUNKYMONKEY";
    private String PATRON_EMAIL ="hellot@saeerw.com";
    private String DOB = "1990-02-27";
    private String GENDER = "F";
    private String PHONE = "917-123-4567";
    private PersonType PT = PersonType.PATRON;
    private Double OUTSTANDING_FEE = 1000.32;
    private Integer patId = 100001;
    private Integer refID = 100023;


    @Before
    public void initialize(){

        patron= new Patron();
        patron.setId(patId);
        patron.setUsername("testing");
        patron.setName(PATRON_NAME);
        patron.setPassword(PATRON_PASS);
        patron.setEmail(PATRON_EMAIL);
        patron.setGender(GENDER);
        patron.setPhoneNumber(PHONE);
        patron.setOutStandingFees(OUTSTANDING_FEE);
        patron.setDob(DOB);

    }
    @Test
    public void testPatronCreation(){
        Assert.assertEquals(PATRON_NAME,patron.getName());
    }

    @Test
    public void testDBConnect(){
        Integer rc;
        PersonDao pd = new PersonDao();
        rc = pd.connect();
        Assert.assertEquals(rc.intValue(), 0);

        rc = pd.close();

        Assert.assertEquals(rc.intValue(), 0);
    }

    @Test
    public void testaddanddDelete(){
        Integer rc;
        PersonDao pd = new PersonDao();
        rc = pd.connect();
        Assert.assertEquals(rc.intValue(), 0);
        rc = pd.savePerson(patron);
        Assert.assertEquals(rc.intValue(), 0);
        rc = pd.deletePerson(patron.getId());
        Assert.assertEquals(rc.intValue(), 0);
        rc = pd.close();
        Assert.assertEquals(rc.intValue(), 0);

    }


    @Test
    public void testQuery(){
        Integer rc;
        List<Person> personList;
        Person pp;

        PersonDao pd = new PersonDao();
        rc = pd.connect();
        Assert.assertEquals(rc.intValue(), 0);
        personList = pd.loadPeople();

        rc = personList.size();
        Assert.assertNotEquals(rc.intValue(),0);  /* ensure it is not 0 len */
        pp = personList.get(0);

        Assert.assertEquals(DJB,pp.getUsername());

        rc = pd.close();
        Assert.assertEquals(rc.intValue(), 0);


    }

}
