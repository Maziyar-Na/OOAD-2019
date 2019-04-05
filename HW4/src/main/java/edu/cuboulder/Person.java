package edu.cuboulder;

import java.util.List;

public abstract class Person implements PersonInterface{
    private String name;
    private Integer id;
    private String password;
    private PersonType type;
    private Item item;

    public void setType(PersonType type) {
        this.type = type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }


    public PersonType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Item> search(){
        System.out.println("PlaceHolder for search");
        return null;
    }


    public Item borrow(){
        System.out.println("PlaceHoler for borrow");
        return null;
    }

    public Integer returnItem(){

        return null;

    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
