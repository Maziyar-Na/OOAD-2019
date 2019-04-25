package edu.cuboulder.unittests;
import domain.Item;
import domain.ItemType;
import DAO.InventoryDao;
import domain.Publication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/* Combining both unit and integration tests for speed of testing */
public class ItemDaoTest {
    private Publication pub;
    private String BN = "DUNE";
    private Integer ID = 999912345;
    private String ISBN    = "1234567890";
    private String NEWISBN = "1231567890";
    private Integer AV = 1;
    private Integer NAV = 0;
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

    @Test
    public void testAddAndDelete(){
        Integer rc;
        Item retItem;
        InventoryDao id = new InventoryDao();
        rc = id.connect();
        Assert.assertEquals(rc.intValue(), 0);
        rc = id.addItem(pub);
        Assert.assertEquals(rc.intValue(), 0);
        String qry = "Select * from book where id = " + ID;
        retItem = id.searchItem(qry);
        Assert.assertEquals(retItem.getId().intValue(),ID.intValue());
        Assert.assertEquals(retItem.getIsbn_num(),ISBN);
        Assert.assertEquals(retItem.getAuthor(),AUTH);
        Assert.assertEquals(retItem.getType(),IT);
        Assert.assertEquals(retItem.getAvailable(),AV);
        Assert.assertEquals(retItem.getBook_name(),BN);

        rc = id.deleteItem(pub.getId());

        Assert.assertEquals(rc.intValue(), 0);
        rc = id.close();
        Assert.assertEquals(rc.intValue(), 0);
    }

    @Test
    public void updateItem(){
        Integer rc;
        Item retItem;
        InventoryDao id = new InventoryDao();
        rc = id.connect();
        Assert.assertEquals(rc.intValue(), 0);
        rc = id.addItem(pub);
        pub.setIsbn_num(NEWISBN);
        pub.setAvailable(0);
        rc = id.saveItem(pub);
        String qry = "Select * from book where id = " + ID;
        retItem = id.searchItem(qry);
        Assert.assertEquals(retItem.getIsbn_num(),NEWISBN);
        Assert.assertEquals(retItem.getAvailable(),NAV);
        rc = id.deleteItem(pub.getId());
        Assert.assertEquals(rc.intValue(), 0);
        rc = id.close();
        Assert.assertEquals(rc.intValue(), 0);


    }


}
