package domain;

public class ItemFactory {
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
        item.setIsbn_num(vo.getIsbn_num().toString()); /*TODO: remove cheap hack*/
        item.setAvailable(vo.getAvailable());
        return item ;
    }
}
