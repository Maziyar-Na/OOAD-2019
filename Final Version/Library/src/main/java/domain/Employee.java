package domain;

public class Employee extends Person{

    public Integer updateItem(Item x){
        System.out.println("placholder for updateItem");
        return 0;
    }

    public Integer deleteItem(BookVO bvo){
        System.out.println("Placeholder for deleteItem");
        Item newItem = ItemFactory.makeItem(bvo);

        Inventory.getInstance().deleteItem(newItem);
        return 0;
    }

    public Integer addItem(BookVO bvo){
        System.out.println("Placeholder for addItem");
        System.out.println("[dbg] here we are in person add item! before factory");
        System.out.println("[dbg] bvo: " + bvo.getType());
        System.out.println("[dbg] bvo: " + bvo.getAuthor());
        System.out.println("[dbg] bvo: " + bvo.getBook_name());
        System.out.println("[dbg] bvo: " + bvo.getIsbn_num());
        System.out.println("[dbg] bvo: " + bvo.getSince_date());
        System.out.println("[dbg] bvo: " + bvo.getAvailable());
        Item newItem = ItemFactory.makeItem(bvo);
        System.out.println("[dbg] here we are in person add item!" + newItem.getType().toInteger());
        Inventory.getInstance().addItem(newItem);
        return 0;
    }
}
