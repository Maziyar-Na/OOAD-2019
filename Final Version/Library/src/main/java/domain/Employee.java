//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: Employee additional functionalities
package domain;

public class Employee extends Person{

    //deleting an existing item
    public Integer deleteItem(BookVO bvo){
        System.out.println("Placeholder for deleteItem");
        Item newItem = ItemFactory.makeItem(bvo);

        Inventory.getInstance().deleteItem(newItem);
        return 0;
    }

    //adding a new item
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
