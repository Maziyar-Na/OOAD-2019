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
        pub.getBook_name(BN);
        pub.setIsbn_num(ISBN);
        pub.setType(IT);
        pub.setAuthor(AUTH);
        pub.setAvailable(AV);
    }


}
