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
    public Integer addItem(Item item){
        InventoryDao idao = new InventoryDao();
        return idao.addItem(item);
    }

    public Item getItem(String criteria){
        System.out.println("Placeholder for getItem");
        return null;
    }

    public List<Item> getBorrowedItems(){
        System.out.println("Placeholder for getBorrowed Items\n");
        return null;
    }
    public Integer deleteItem(Item item){
        System.out.println("Placeholder for deleteItem\n");
        InventoryDao idao = new InventoryDao();
        return idao.deleteItem(item);
    }

    public List<Item> convert_BookVO_to_Item(List<BookVO>bvos){
        for (BookVO E:bvos) {
            items.add(ItemFactory.makeItem(E));
        }
        return items;
    }

    public List<BookVO> search(BookVO bvo){
        InventoryDao ido = new InventoryDao();
        return ido.searchItems(bvo);
    }

    public List<Item> sort(List<Item> items, SortType sortType){
        SortInterface sortInterface = SortFactory.getSortAction(sortType);
        System.out.println("Placeholder for sort: " + sortInterface);
        return null;
    }

}
