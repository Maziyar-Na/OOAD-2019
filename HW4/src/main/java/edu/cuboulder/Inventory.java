package edu.cuboulder;

import java.util.List;

public class Inventory {
    private List<Item> items;
    InventoryDao dao = null;
    public Integer addItem(Item item){
        System.out.println("Placeholder for addItem \n");
        return -1;
    }

    public Item getItem(String criteria){
        System.out.println("Placeholder for getItem");
        return null;
    }

    public List<Item> getBorrowedItems(){
        System.out.println("Placeholder for getBorrowed Items\n");
        return null;
    }
    public Integer delteItem(Integer id){
        System.out.println("Placeholder for deleteItem\n");
        return -1;
    }

    public List<Item> getItems(List<String>){
        System.out.println("GetItems Placeholder\n");
        return null;
    }

    public List<Item> sort(){
        System.out.println("Placeholder for sort");
        return null;
    }
}
