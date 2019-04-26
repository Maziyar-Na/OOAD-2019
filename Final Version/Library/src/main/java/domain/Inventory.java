//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: holding the inventory data and implementing functions related to inventory
//pattern usage: Inventory is based on singleton pattern
package domain;

import DAO.InventoryDao;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;
    private static Inventory instance ;

    private Inventory(){
        items = new ArrayList<Item>();
    }

    public static Inventory getInstance(){
        if(instance == null){
            instance = new Inventory();
        }
        return instance;
    }

    //adding a new item to inventory
    public Integer addItem(Item item){
        InventoryDao idao = new InventoryDao();
        return idao.addItem(item);
    }

    //deleting an Item from inventory
    public Integer deleteItem(Item item){
        InventoryDao idao = new InventoryDao();
        return idao.deleteItem(item);
    }

    //a helper function for converting BokkVO to items of inventory
    public List<Item> convert_BookVO_to_Item(List<BookVO>bvos){
        for (BookVO E:bvos) {
            items.add(ItemFactory.makeItem(E));
        }
        return items;
    }

    //search in the inventory for a book with defined criteria in the search form
    public List<BookVO> search(BookVO bvo){
        InventoryDao ido = new InventoryDao();
        return ido.searchItems(bvo);
    }

    //sorting the book in the in the search result
    //this is part of implementing the strategy pattern for different kinds of sort
    public List<BookVO> sort(List<BookVO> items, SortType sortType){
        SortInterface sortInterface = SortFactory.getSortAction(sortType); //setting the behaviour
        return sortInterface.sort(items); //implementing the sort itself
    }

}
