import edu.cuboulder.Patron;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PatronTest {
    private Patron patron;
    private Patron patron_ref;
    private String PATRON_NAME = "testy Tester";
    private String PATRON_PASS ="FUNKYMONKEY";
    private Double OUTSTANDING_FEE = 1000.32;
    @Before
    public void initialize(){

        patron = new Patron();
        patron.setId(100);
        patron.setName(PATRON_NAME);
        patron.setPassword(PATRON_PASS);
        patron_ref = new Patron();
        patron_ref.setId(101);
        patron_ref.setName("Refereential Integrity");
        patron_ref.setId(110);
        patron_ref.setOutStandingFees(OUTSTANDING_FEE);
        patron_ref.setPassword("funky");
    }


    @Test
    public void testPatronCreation(){
        Assert.assertEquals(PATRON_NAME, patron.getName());
        Assert.assertEquals(Integer.valueOf(100),patron.getId());
        Assert.assertEquals(OUTSTANDING_FEE,patron_ref.getOutStandingFees());
    }


}
