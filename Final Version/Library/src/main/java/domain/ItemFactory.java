//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: for making new items in our inventory
//pattern usage: we used the simple factory  pattern in here
package domain;

public class ItemFactory {

    //makes a new Item based on type of it
    public static Item makeItem(BookVO vo){
        ItemType type = ItemType.fromInteger(vo.getType());
        Item item ;
        if (type == ItemType.AUDIOPROGRAM){
            item = new AudioProgram();
        } else if(type == ItemType.PUBLICATION){
            item = new Publication();
        } else if(type == ItemType.VISUALPROGRAM){
            item = new VisualProgram();
        }else{
            item = null;
        }

        item.setBook_name(vo.getBook_name());
        item.setAuthor(vo.getAuthor());
        item.setIsbn_num(vo.getIsbn_num());
        item.setDate(vo.getSince_date());
        item.setAvailable(vo.getAvailable());
        item.setType(type);
        return item ;
    }
}
