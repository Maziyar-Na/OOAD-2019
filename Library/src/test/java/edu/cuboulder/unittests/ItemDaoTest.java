package edu.cuboulder.unittests;
import domain.Inventory;
import domain.Item;
import domain.ItemType;
import DAO.InventoryDao;
import domain.Publication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
public class ItemDaoTest {
    private Publication pub;
    private String BN = "DUNE";
    private Integer ID = 999912345;
    private String ISBN ="1234567890";
    private Integer AV = 1;
    private  ItemType IT = ItemType.PUBLICATION;
    private String AUTH ="Frank Herbert";

    @Before
    public void initialize(){
        pub = new Publication();
        pub.setId(ID);
        pub.setBook_name(BN);
        pub.setIsbn_num(ISBN);
        pub.setType(IT);
        pub.setAuthor(AUTH);
        pub.setAvailable(AV);
    }

    @Test
    public void testPubVals(){
        Assert.assertEquals(pub.getId().intValue(),ID.intValue());
        Assert.assertEquals(pub.getIsbn_num(),ISBN);
        Assert.assertEquals(pub.getAuthor(),AUTH);
        Assert.assertEquals(pub.getType(),IT);
        Assert.assertEquals(pub.getAvailable(),AV);
        Assert.assertEquals(pub.getBook_name(),BN);

    }
    @Test
    public void testDBConnect(){
        Integer rc;
        InventoryDao id =new InventoryDao();
        rc = id.connect();
        Assert.assertEquals(rc.intValue(), 0);
        rc = id.close();
        Assert.assertEquals(rc.intValue(), 0);
    }

}
