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
        Item newItem = ItemFactory.makeItem(bvo);
        Inventory.getInstance().addItem(newItem);
        return 0;
    }
}
