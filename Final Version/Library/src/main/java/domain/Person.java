package domain;

import java.util.List;

public abstract class Person{
    private Integer id;
    private String name;
    private String username;
    private String password;
    private PersonType type;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setType(PersonType type) {
        this.type = type;
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


    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public boolean borrow(List<Item>items){
        System.out.println("PlaceHoler for borrow");
        return false;
    }

}